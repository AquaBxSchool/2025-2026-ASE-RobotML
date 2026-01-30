import type { BinaryExpr } from "./generated.ts";
import { SymbolTable } from "./SymbolTable.ts";
import {
	type ArgumentDec,
	type Assignation,
	type Backward,
	type Block,
	type Condition,
	type Expression,
	type FnReturn,
	type Forward,
	type FunctionCall,
	type FunctionDeclaration,
	type GetClock,
	type GetSensor,
	type GetSpeed,
	type Leftward,
	type Literal,
	type Loop,
	type Movement,
	type Rightward,
	type RobotML,
	RobotMlValidationVisitor,
	type Rotate,
	type SetClock,
	type SetSpeed,
	type Statement,
	type Type,
	type Unary,
	type VariableDec,
	type VariableRef,
} from "./semantics.ts";

export class RobotMLGeneratorVisitor extends RobotMlValidationVisitor {
	symbolTable: SymbolTable;

	constructor() {
		super();
		this.symbolTable = new SymbolTable();
	}

	visitArgumentDec(node: ArgumentDec) {
		throw new Error("Method not implemented.");
	}
	visitExpression(node: Expression) {
		throw new Error("Method not implemented.");
	}
	visitFunctionCall(node: FunctionCall) {
		throw new Error("Method not implemented.");
	}
	visitGetClock(node: GetClock) {
		throw new Error("Method not implemented.");
	}
	visitGetSensor(node: GetSensor) {
		throw new Error("Method not implemented.");
	}
	visitGetSpeed(node: GetSpeed) {
		throw new Error("Method not implemented.");
	}
	visitLiteral(node: Literal) {
		throw new Error("Method not implemented.");
	}
	visitUnary(node: Unary) {
		throw new Error("Method not implemented.");
	}
	visitVariableRef(node: VariableRef) {
		throw new Error("Method not implemented.");
	}
	visitRobotML(node: RobotML) {
		throw new Error("Method not implemented.");
	}
	visitStatement(node: Statement) {
		throw new Error("Method not implemented.");
	}
	visitAssignation(node: Assignation) {
		throw new Error("Method not implemented.");
	}
	visitBlock(node: Block) {
		throw new Error("Method not implemented.");
	}
	visitCondition(node: Condition) {
		throw new Error("Method not implemented.");
	}
	visitFnReturn(node: FnReturn) {
		throw new Error("Method not implemented.");
	}
	visitFunctionDeclaration(node: FunctionDeclaration) {
		throw new Error("Method not implemented.");
	}
	visitLoop(node: Loop) {
		throw new Error("Method not implemented.");
	}
	visitMovement(node: Movement) {
		throw new Error("Method not implemented.");
	}
	visitBackward(node: Backward) {
		return `
			dist_accel = speed * 2.9940119760479043;
			delaying = (167 * (${-300} - dist_accel)) / speed;
			Omni.setCarAdvance(speed);
			Omni.setCarSpeedMMPS(speed, 500);
			delay(delaying);
			Omni.setCarSlow2Stop(500);
			delay(500);
		`;
	}
	visitForward(node: Forward) {
		return `
			dist_accel = speed * 2.9940119760479043;
			delaying = (167 * (${300} - dist_accel)) / speed;
			Omni.setCarAdvance(speed);
			Omni.setCarSpeedMMPS(speed, 500);
			delay(delaying);
			Omni.setCarSlow2Stop(500);
			delay(500);
		`;
	}
	visitLeftward(node: Leftward) {
		throw new Error("Method not implemented.");
	}
	visitRightward(node: Rightward) {
		throw new Error("Method not implemented.");
	}
	visitRotate(node: Rotate) {
		return `
			dist_accel = speed * 2.9940119760479043;
			delaying = (167 * ((${90} * 2.4638813) - dist_accel)) / speed;
			Omni.setCarRotateRight(speed);
			Omni.setCarSpeedMMPS(speed, 500);
			delay(delaying);
			Omni.setCarSlow2Stop(500);
			delay(500);
		`;
	}
	visitSetClock(node: SetClock) {
		throw new Error("Method not implemented.");
	}
	visitSetSpeed(node: SetSpeed) {
		throw new Error("Method not implemented.");
	}
	visitVariableDec(node: VariableDec) {
		throw new Error("Method not implemented.");
	}
}
