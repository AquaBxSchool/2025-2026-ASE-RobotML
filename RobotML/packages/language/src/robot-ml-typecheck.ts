import { SymbolInfo, SymbolTable } from "./SymbolTable.ts";
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
	type Unary,
	type VariableDec,
	type VariableRef,
} from "./semantics.ts";

export class RobotMLTypeCheckVisitor extends RobotMlValidationVisitor {
	symbolTable: SymbolTable = new SymbolTable();

	visitArgumentDec(node: ArgumentDec) {}
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
		// throw new Error("Method not implemented.");

		const main_function = node.functions.find((f) => f.name === "main");
		if (main_function === undefined) {
			this.validationAccept("error", "There is no main functions defined", {
				node: node,
			});
		}

		this.symbolTable.beginScope();

		node.functions.forEach((node) => {
			this.visitFunctionDeclaration(node);
		});

		this.symbolTable.endScope();
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
		this.symbolTable.put(
			node.name,
			new SymbolInfo(node.$cstNode.offset, 0, node.$cstNode.text),
		);

		// TODO check return type

		node.parameters.forEach((p) => {
			this.visitArgumentDec(p);
		});

		this.visitBlock(node.block);
	}
	visitLoop(node: Loop) {
		throw new Error("Method not implemented.");
	}
	visitMovement(node: Movement) {
		throw new Error("Method not implemented.");
	}
	visitBackward(node: Backward) {
		throw new Error("Method not implemented.");
	}
	visitForward(node: Forward) {
		throw new Error("Method not implemented.");
	}
	visitLeftward(node: Leftward) {
		throw new Error("Method not implemented.");
	}
	visitRightward(node: Rightward) {
		throw new Error("Method not implemented.");
	}
	visitRotate(node: Rotate) {
		throw new Error("Method not implemented.");
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
