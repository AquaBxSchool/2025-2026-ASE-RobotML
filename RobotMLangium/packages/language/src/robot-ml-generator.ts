import type { BinaryExpr } from "./generated.ts";
import { SymbolTable } from "./SymbolTable.ts";
import type {
	ArgumentDec,
	Assignation,
	Backward,
	Block,
	BoolLiteral,
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

const typeMap: Map<Type, string> = new Map();
typeMap.set("string", "std::string");
typeMap.set("boolean", "bool");
typeMap.set("integer", "int");
typeMap.set("float", "float");
typeMap.set("void", "void");

export class RobotMLGeneratorVisitor extends RobotMlValidationVisitor {
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
	visitGetClock(node: GetClock): string {
		throw new Error("Method visitGetClock() not implemented.");
	}
	visitGetSensor(node: GetSensor): string {
		throw new Error("Method visitGetSensor() not implemented.");
	}
	visitGetSpeed(node: GetSpeed): string {
		throw new Error("Method visitGetSpeed() not implemented.");
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

		return `${includes.join("\n")}\n\n${node.functions.map((p) => this.visitFunctionDeclaration(p)).join("\n\n")}`;
	}
	visitStatement(node: Statement): string {
		switch (node.$type) {
			case "FunctionDeclaration":
				return this.visitFunctionDeclaration(
					node as FunctionDeclaration,
				);
			case "VariableDec":
				return this.visitVariableDec(node as VariableDec);
			case "SetSpeed":
				return this.visitSetSpeed(node as SetSpeed);
			case "FnReturn":
				return this.visitFnReturn(node as FnReturn);
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
			case "FunctionDeclaration":
				return this.visitFunctionDeclaration(
					node as FunctionDeclaration,
				);
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
			case "VariableDec":
				return this.visitVariableDec(node as VariableDec);
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
	visitCondition(node: Condition): string {
		throw new Error("Method visitCondition() not implemented.");
	}
	visitFnReturn(node: FnReturn): string {
		return `return ${this.visitExpression(node.expression)}`;
	}
	visitFunctionDeclaration(node: FunctionDeclaration): string {
		return `${typeMap.get(node.returnType)} ${node.name} ( ${node.parameters.map((p) => this.visitArgumentDec(p)).join(", ")} )\n${this.visitBlock(node.block)}`;
	}
	visitLoop(node: Loop): string {
		throw new Error("Method visitLoop() not implemented.");
	}
	visitMovement(node: Movement): string {
		throw new Error("Method visitMovement() not implemented.");
	}
	visitBackward(node: Backward): string {
		return `
			dist_accel = speed * 2.9940119760479043;
			delaying = (167 * (-${this.visitExpression(node.expression)} - dist_accel)) / speed;
			Omni.setCarAdvance(speed);
			Omni.setCarSpeedMMPS(speed, 500);
			delay(delaying);
			Omni.setCarSlow2Stop(500);
			delay(500);
		`;
	}
	visitForward(node: Forward): string {
		return `
			dist_accel = speed * 2.9940119760479043;
			delaying = (167 * (${this.visitExpression(node.expression)} - dist_accel)) / speed;
			Omni.setCarAdvance(speed);
			Omni.setCarSpeedMMPS(speed, 500);
			delay(delaying);
			Omni.setCarSlow2Stop(500);
			delay(500);
		`;
	}
	visitLeftward(node: Leftward): string {
		throw new Error("Method visitLeftward() not implemented.");
	}
	visitRightward(node: Rightward): string {
		throw new Error("Method visitRightward() not implemented.");
	}
	visitRotate(node: Rotate): string {
		return `
			dist_accel = speed * 2.9940119760479043;
			delaying = (167 * ((${this.visitExpression(node.expression)} * 2.4638813) - dist_accel)) / speed;
			Omni.setCarRotateRight(speed);
			Omni.setCarSpeedMMPS(speed, 500);
			delay(delaying);
			Omni.setCarSlow2Stop(500);
			delay(500);
		`;
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
}
