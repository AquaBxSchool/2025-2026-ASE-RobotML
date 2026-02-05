import type { BinaryExpr } from "./generated.ts";
import { SymbolTable } from "./SymbolTable.ts";
import type {
	ArgumentDec,
	Assignation,
	Block,
	BoolLiteral,
	Cast,
	Condition,
	Delay,
	Expression,
	FloatLiteral,
	FnReturn,
	FunctionCall,
	FunctionDeclaration,
	GetClock,
	GetSensor,
	GetSpeed,
	IntLiteral,
	Loop,
	Movement,
	RobotML,
	Rotate,
	SetClock,
	SetSpeed,
	Statement,
	StringLiteral,
	Type,
	Unary,
	VariableDec,
	VariableRef,
} from "./semantics.ts";
import { RobotMlValidationVisitor } from "./semantics.ts";

const functions = `
float distanceRadial(float angle) {
	return angle * PI / 180 * 141.17;
}
float delaying(float distance) {
	return (167*(distance/speed - 2.9940119760479043));
}
void forward(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarAdvance(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void leftward(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarLeft(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void rightward(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarRight(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void backward(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarBackoff(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void lowerleft(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarLowerLeft(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void upperleft(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarUpperLeft(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void upperright(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarUpperRight(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void lowerright(Omni4WD & Omni, int distance) {
	float delay_time = delaying(distance);
	Omni.setCarLowerRight(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delay_time); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	delay(500);
	// 50.1mm
}
void rotateLeft(Omni4WD & Omni, int angle) {
	float delay_time = delaying(distanceRadial(angle));
	Omni.setCarRotateLeft(speed);
	Omni.setCarSpeedMMPS(speed, 500);
	delay(delay_time);
	Omni.setCarSpeedMMPS(0, 500);
	delay(500);
}
void rotateRight(Omni4WD & Omni, int angle) {
	float delay_time = delaying(distanceRadial(angle));
	Omni.setCarRotateRight(speed);
	Omni.setCarSpeedMMPS(speed, 500);
	delay(delay_time);
	Omni.setCarSpeedMMPS(0, 500);
	delay(500);
}
void rotate(Omni4WD & Omni, int angle) {
	if (angle < 0){
		rotateLeft(Omni, -angle);
	}
	else {
		rotateRight(Omni, angle);
	}
}
long getDistance() {
	pinMode(6, OUTPUT);
	digitalWrite(6, LOW);
	delayMicroseconds(2);
	digitalWrite(6, HIGH);
	delayMicroseconds(5);
	digitalWrite(6, LOW);
	pinMode(6, INPUT);

	long duration = pulseIn(6,HIGH);
	delay(100);

	return duration / 29 / 2 * 10;
}

void setup()
{
    TCCR1B = TCCR1B & 0xf8 | 0x01; // Pin9,Pin10 PWM 31250Hz
    TCCR2B = TCCR2B & 0xf8 | 0x01; // Pin3,Pin11 PWM 31250Hz

    Omni.PIDEnable(0.31, 0.01, 0, 10);
}
void loop(){main_(); return;}
`;

const typeMap: Map<Type, string> = new Map();
typeMap.set("string", "const char *");
typeMap.set("boolean", "bool");
typeMap.set("integer", "int");
typeMap.set("float", "float");
typeMap.set("void", "void");

// Function name inside robotml => function name inside .ino
const functionDecMap: Map<string, string> = new Map<string, string>([]);
const forbidenFunctionNames = ["loop", "setup", "main"];

function join_comma(value: string[]) {
	return value.map((el) => (el += ";\n")).join("");
}

export class RobotMLGeneratorVisitor extends RobotMlValidationVisitor {
	visitDelay(node: Delay): string {
		return `delay((int)${this.visitExpression(node.expression)})`;
	}
	visitCast(node: Cast): string {
	  const type = typeMap.get(node.type);
    const expr = this.visitExpression(node.expression);
    return `(${type})(${expr})`;
	}
	symbolTable: SymbolTable;

	constructor() {
		super();
		this.symbolTable = new SymbolTable();
	}
	visitBoolLiteral(node: BoolLiteral) {
		return `${node.value}`;
	}

	visitFloatLiteral(node: FloatLiteral) {
		return `${node.value}`;
	}

	visitIntLiteral(node: IntLiteral) {
		return `${node.value}`;
	}

	visitStringLiteral(node: StringLiteral) {
		return `"${node.value}"`;
	}
	visitArgumentDec(node: ArgumentDec): string {
		return `${typeMap.get(node.type)} ${node.name}`;
	}
	visitExpression(node: Expression): string {
		switch (node.$type) {
			case "BinaryExpr": {
				const node2 = node as unknown as BinaryExpr;
				return `${this.visitExpression(node2.left as unknown as Expression)} ${node2.operator} ${this.visitExpression(node2.right as unknown as Expression)}`;
			}
			case "Expression":
				return this.visitExpression(node as Expression);
			case "FunctionCall":
				return this.visitFunctionCall(node as FunctionCall);
			case "GetClock":
				return this.visitGetClock(node as GetClock);
			case "GetSensor":
				return this.visitGetSensor(node as GetSensor);
			case "GetSpeed":
				return this.visitGetSpeed(node as GetSpeed);
			case "StringLiteral":
				return this.visitStringLiteral(node as StringLiteral);
			case "FloatLiteral":
				return this.visitFloatLiteral(node as FloatLiteral);
			case "IntLiteral":
				return this.visitIntLiteral(node as IntLiteral);
			case "BoolLiteral":
				return this.visitBoolLiteral(node as BoolLiteral);
			case "Unary":
				return this.visitUnary(node as Unary);
			case "VariableRef":
				return this.visitVariableRef(node as VariableRef);
		}
	}
	visitFunctionCall(node: FunctionCall): string {
		const robotMLName = node.functiondeclaration.ref.name;

		const inoName = functionDecMap.get(robotMLName);

		return `${inoName}(${node.parameters.map((p) => this.visitExpression(p)).join(", ")})`;
	}
	visitUnary(node: Unary): string {
		return `${node.op} ${this.visitExpression(node.expr)}`;
	}
	visitVariableRef(node: VariableRef): string {
		return `${node.ref.ref.name}`;
	}
	visitRobotML(node: RobotML): string {
		const includes = [
			"#include <PinChangeInt.h>",
			"#include <PinChangeIntConfig.h>",
			"#include <EEPROM.h>",
			"#define _NAMIKI_MOTOR // for Namiki 22CL-103501PG80:1",
			"#include <fuzzy_table.h>",
			"#include <PID_Beta6.h>",
			"#include <MotorWheel.h>",
			"#include <Omni4WD.h>",
		];

		const constants = [
			"irqISR(irq1, isr1)",
			"MotorWheel wheel1(3, 2, 4, 5, &irq1)",
			"irqISR(irq2, isr2)",
			"MotorWheel wheel2(11, 12, 14, 15, &irq2)",
			"irqISR(irq3, isr3)",
			"MotorWheel wheel3(9, 8, 16, 17, &irq3)",
			"irqISR(irq4, isr4)",
			"MotorWheel wheel4(10, 7, 18, 19, &irq4)",
			"Omni4WD Omni(&wheel1, &wheel2, &wheel3, &wheel4)",
			"float speed = 0.0",
		];

		const entrypoint = "";

		return `${includes.join("\n")}\n\n${join_comma(constants)}\n${functions}\n${node.functions.map((p) => this.visitFunctionDeclaration(p)).join("\n\n")} ${entrypoint}`;
	}
	visitStatement(node: Statement): string {
		switch (node.$type) {
			case "FunctionDeclaration":
				return this.visitFunctionDeclaration(
					node as FunctionDeclaration,
				);
			case "VariableDec":
				return this.visitVariableDec(node as VariableDec);
			case "Assignation":
				return this.visitAssignation(node as Assignation);
			case "Block":
				return this.visitBlock(node as Block);
			case "Delay":
				return this.visitDelay(node as Delay);
			case "Condition":
				return this.visitCondition(node as Condition);
			case "FnReturn":
				return this.visitFnReturn(node as FnReturn);
			case "FunctionCall":
				return this.visitFunctionCall(node as FunctionCall);
			case "Loop":
				return this.visitLoop(node as Loop);
			case "Movement":
				return this.visitMovement(node as Movement);
			case "Rotate":
				return this.visitRotate(node as Rotate);
			case "SetClock":
				return this.visitSetClock(node as SetClock);
			case "SetSpeed":
				return this.visitSetSpeed(node as SetSpeed);
			case "Statement":
				return this.visitStatement(node as Statement);
			default:
				throw new Error(`Undefined Statement: ${node.$type}`);
		}
	}
	visitAssignation(node: Assignation): string {
		return `${this.visitVariableRef(node.variableRef)} = ${this.visitExpression(node.expression)}`;
	}
	visitBlock(node: Block): string {
		return `{\n${join_comma(node.statements.map((p) => this.visitStatement(p)))}\n}`;
	}
	visitFnReturn(node: FnReturn): string {
		return `return ${this.visitExpression(node.expression)}`;
	}
	visitFunctionDeclaration(node: FunctionDeclaration): string {
		const robotMLName = node.name;
		const params = node.parameters
			.map((p) => this.visitArgumentDec(p))
			.join(", ");
		const block = `\n${this.visitBlock(node.block)}`;
		var type = typeMap.get(node.returnType);
		var inoName = robotMLName;

		if (robotMLName == "main") {
			type = "int";
		}

		if (forbidenFunctionNames.find((name) => name == robotMLName)) {
			inoName = `${inoName}_`;
		}

		if (functionDecMap.has(robotMLName)) {
			inoName = `${inoName}_`;
		}

		functionDecMap.set(robotMLName, inoName);

		return `${type} ${inoName}( ${params} ) ${block}`;
	}
	visitRotate(node: Rotate): string {
		return `rotate(Omni,${this.visitExpression(node.expression)})`;
	}
	visitSetSpeed(node: SetSpeed): string {
		return `speed = ${this.visitExpression(node.expression)}`;
	}
	visitGetSpeed(node: GetSpeed): string {
		return "speed";
	}
	visitVariableDec(node: VariableDec): string {
		return `${typeMap.get(node.type)} ${node.name} = ${this.visitExpression(node.expression)}`;
	}
	visitLoop(node: Loop): string {
		return `while (${this.visitExpression(node.condition)}) \n ${this.visitBlock(node.block)}`;
	}
	visitCondition(node: Condition): string {
		let conditionText = "";
		for (let i = 0; i < node.conditions.length; i++) {
			conditionText += `${i == 0 ? "if" : "else if"} (${this.visitExpression(node.conditions.at(i))}) ${this.visitBlock(node.block.at(i))}`;
		}

		if (node.conditions.length < node.block.length) {
			conditionText += `else ${this.visitBlock(node.block.at(-1))}`;
		}

		return conditionText;
	}
	visitMovement(node: Movement): string {
		switch (node.type) {
			case "Backward":
				return `backward(Omni, ${this.visitExpression(node.expression)})`;
			case "Forward":
				return `forward(Omni, ${this.visitExpression(node.expression)})`;
			case "Left":
				return `left(Omni, ${this.visitExpression(node.expression)})`;
			case "Right":
				return `right(Omni, ${this.visitExpression(node.expression)})`;
			case "LowerLeft":
				return `lowerleft(Omni, ${this.visitExpression(node.expression)})`;
			case "UpperLeft":
				return `upperleft(Omni, ${this.visitExpression(node.expression)})`;
			case "UpperLeft":
				return `upperleft(Omni, ${this.visitExpression(node.expression)})`;
			case "UpperRight":
				return `upperright(Omni, ${this.visitExpression(node.expression)})`;
		}
	}
	visitSetClock(node: SetClock): string {
		throw new Error("Method visitSetClock() not implemented.");
	}
	visitGetClock(node: GetClock): string {
		throw new Error("Method visitGetClock() not implemented.");
	}
	visitGetSensor(node: GetSensor): string {
		switch (node.sensor) {
			case "Distance":
				return "getDistance()";
			case "Color":
				throw new Error("GetSensor Color not implemented.");
		}
	}
}
