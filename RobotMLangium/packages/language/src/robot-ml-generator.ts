import type { BinaryExpr } from "./generated.ts";
import { SymbolTable } from "./SymbolTable.ts";
import type {
	ArgumentDec,
	Assignation,
	Backward,
	Block,
	BoolLiteral,
	Cast,
	Condition,
	Expression,
	FloatLiteral,
	FnReturn,
	Forward,
	FunctionCall,
	FunctionDeclaration,
	GetClock,
	GetSensor,
	GetSpeed,
	IntLiteral,
	Leftward,
	Loop,
	Movement,
	Rightward,
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
	return angle * pi / 180 * 141.17
}
float delaying(float distance) {
	return (167*(distance/speed - 2.9940119760479043));
}
void forward(Omni4WD & Omni, int distance) {
	float delaying = delaying(distance);
	Omni.setCarAdvance(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delaying); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	// 50.1mm
}
void leftward(Omni4WD & Omni, int distance) {
	float delaying = delaying(distance);
	Omni.setCarLeft(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delaying); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	// 50.1mm
}
void rightward(Omni4WD & Omni, int distance) {
	float delaying = delaying(distance);
	Omni.setCarRight(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delaying); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	// 50.1mm
}
void backward(Omni4WD & Omni, int distance) {
	float delaying = delaying(distance);
	Omni.setCarBackoff(speed);
	Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
	delay(delaying); // 35.1mm
	Omni.setCarSpeedMMPS(0, 500); // 7.8mm
	// 50.1mm
}
void rotateLeft(Omni4WD & Omni, int angle) {
	float delaying = delaying(distanceRadial(angle));
	Omni.setCarRotateLeft(speed);
	Omni.setCarSpeedMMPS(speed, 500);
	delay(delaying);
	Omni.setCarSpeedMMPS(0, 500);
}
void rotateRight(Omni4WD & Omni, int angle) {
	float delaying = delaying(distanceRadial(angle));
	Omni.setCarRotateRight(speed);
	Omni.setCarSpeedMMPS(speed, 500);
	delay(delaying);
	Omni.setCarSpeedMMPS(0, 500);
}
void rotate(Omni4WD & Omni, int angle) {
	if (angle < 0){
		rotateLeft(Omni, -angle);
	}
	else {
		rotateRight(Omni, angle);
	}
}
`;

const typeMap: Map<Type, string> = new Map();
typeMap.set("string", "std::string");
typeMap.set("boolean", "bool");
typeMap.set("integer", "int");
typeMap.set("float", "float");
typeMap.set("void", "void");

export class RobotMLGeneratorVisitor extends RobotMlValidationVisitor {
	visitCast(node: Cast) {
		throw new Error("Method not implemented.");
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
		return `${node.functiondeclaration.ref.name}(${node.parameters.map((p) => this.visitExpression(p)).join(", ")})`;
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
			"#include <string>",
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
		];

		return `${includes.join("\n")}\n\n${constants.join(";\n")}\n\n${functions}\n\n${node.functions.map((p) => this.visitFunctionDeclaration(p)).join("\n\n")}`;
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
			case "Backward":
				return this.visitBackward(node as Backward);
			case "Block":
				return this.visitBlock(node as Block);
			case "Condition":
				return this.visitCondition(node as Condition);
			case "FnReturn":
				return this.visitFnReturn(node as FnReturn);
			case "Forward":
				return this.visitForward(node as Forward);
			case "FunctionCall":
				return this.visitFunctionCall(node as FunctionCall);
			case "Leftward":
				return this.visitLeftward(node as Leftward);
			case "Loop":
				return this.visitLoop(node as Loop);
			case "Movement":
				return this.visitMovement(node as Movement);
			case "Rightward":
				return this.visitRightward(node as Rightward);
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
		return `{\n${node.statements.map((p) => this.visitStatement(p)).join(";\n")}\n}`;
	}
	visitFnReturn(node: FnReturn): string {
		return `return ${this.visitExpression(node.expression)}`;
	}
	visitFunctionDeclaration(node: FunctionDeclaration): string {
		return `${typeMap.get(node.returnType)} ${node.name} ( ${node.parameters.map((p) => this.visitArgumentDec(p)).join(", ")} )\n${this.visitBlock(node.block)}`;
	}
	visitBackward(node: Backward): string {
		return `backward(Omni,${this.visitExpression(node.expression)})`;
	}
	visitForward(node: Forward): string {
		return `forward(Omni,${this.visitExpression(node.expression)})`;
	}
	visitRotate(node: Rotate): string {
		return `rotate(Omni,${this.visitExpression(node.expression)})`;
	}
	visitLeftward(node: Leftward): string {
		return `leftward(Omni,${this.visitExpression(node.expression)})`;
	}
	visitRightward(node: Rightward): string {
		return `rightward(Omni,${this.visitExpression(node.expression)})`;
	}
	visitCondition(node: Condition): string {
		throw new Error("Method visitCondition() not implemented.");
	}
	visitLoop(node: Loop): string {
		throw new Error("Method visitLoop() not implemented.");
	}
	visitMovement(node: Movement): string {
		throw new Error("Method visitMovement() not implemented.");
	}
	visitSetClock(node: SetClock): string {
		throw new Error("Method visitSetClock() not implemented.");
	}
	visitSetSpeed(node: SetSpeed): string {
		throw new Error("Method visitSetSpeed() not implemented.");
	}
	visitVariableDec(node: VariableDec): string {
		throw new Error("Method visitVariableDec() not implemented.");
	}
	visitGetClock(node: GetClock): string {
		throw new Error("Method visitGetClock() not implemented.");
	}
	visitGetSensor(node: GetSensor): string {
		throw new Error("Method visitGetSensor() not implemented.");
	}
	visitGetSpeed(node: GetSpeed): string {
		throw new Error("Method visitGetSpeed() not implemented.");
	}
}
