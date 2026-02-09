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
	GetDistance,
	GetSpeed,
	GetTimestamp,
	IntLiteral,
	Loop,
	Movement,
	RobotML,
	RobotMlVisitor,
	Rotate,
	SetSpeed,
	Statement,
	StringLiteral,
	Unary,
	VariableDec,
	VariableRef,
} from "./semantics.ts";

export class RobotMLFunctionPass implements RobotMlVisitor {
	visitGetTimestamp(node: GetTimestamp) {
		throw new Error("Method not implemented.");
	}
	functionDecMap: Map<string, string> = new Map<string, string>([]);
	forbidenFunctionNames = ["loop", "setup", "main"];

	visitFunctionDeclaration(node: FunctionDeclaration) {
		const robotMLName = node.name;
		var inoName = robotMLName;

		if (this.forbidenFunctionNames.find((name) => name == robotMLName)) {
			inoName = `${inoName}_`;
		}

		if (this.functionDecMap.has(robotMLName)) {
			inoName = `${inoName}_`;
		}

		this.functionDecMap.set(robotMLName, inoName);
	}
	visitRobotML(node: RobotML) {
		node.functions.map((p) => this.visitFunctionDeclaration(p));

		return this.functionDecMap;
	}

	visitGetDistance(node: GetDistance) {
		throw new Error("Method not implemented.");
	}

	visitArgumentDec(node: ArgumentDec) {
		throw new Error("Method not implemented.");
	}
	visitExpression(node: Expression) {
		throw new Error("Method not implemented.");
	}
	visitBoolLiteral(node: BoolLiteral) {
		throw new Error("Method not implemented.");
	}
	visitCast(node: Cast) {
		throw new Error("Method not implemented.");
	}
	visitFloatLiteral(node: FloatLiteral) {
		throw new Error("Method not implemented.");
	}
	visitFunctionCall(node: FunctionCall) {
		throw new Error("Method not implemented.");
	}
	visitGetSpeed(node: GetSpeed) {
		throw new Error("Method not implemented.");
	}
	visitIntLiteral(node: IntLiteral) {
		throw new Error("Method not implemented.");
	}
	visitStringLiteral(node: StringLiteral) {
		throw new Error("Method not implemented.");
	}
	visitUnary(node: Unary) {
		throw new Error("Method not implemented.");
	}
	visitVariableRef(node: VariableRef) {
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
	visitDelay(node: Delay) {
		throw new Error("Method not implemented.");
	}
	visitFnReturn(node: FnReturn) {
		throw new Error("Method not implemented.");
	}
	visitLoop(node: Loop) {
		throw new Error("Method not implemented.");
	}
	visitMovement(node: Movement) {
		throw new Error("Method not implemented.");
	}
	visitRotate(node: Rotate) {
		throw new Error("Method not implemented.");
	}
	visitSetSpeed(node: SetSpeed) {
		throw new Error("Method not implemented.");
	}
	visitVariableDec(node: VariableDec) {
		throw new Error("Method not implemented.");
	}
}
