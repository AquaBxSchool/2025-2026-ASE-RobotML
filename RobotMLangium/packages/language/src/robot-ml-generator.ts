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
	GetDistance,
	GetSpeed,
	IntLiteral,
	Loop,
	Movement,
	RobotML,
	Rotate,
	SetSpeed,
	Statement,
	StringLiteral,
	Type,
	Unary,
	VariableDec,
	VariableRef,
	DistanceUnit,
	RotateType,
	TimeUnit,
} from "./semantics.ts";
import { RobotMlValidationVisitor } from "./semantics.ts";

const typeMap: Map<Type, string> = new Map();
typeMap.set("string", "const char *");
typeMap.set("boolean", "bool");
typeMap.set("integer", "int");
typeMap.set("float", "float");
typeMap.set("void", "void");

const measureMap: Map<DistanceUnit, number> = new Map();
measureMap.set("millimeter", 10 ** 0);
measureMap.set("centimeter", 10 ** 1);
measureMap.set("decimeter", 10 ** 2);
measureMap.set("meter", 10 ** 3);

const rotateMap: Map<RotateType, string> = new Map();
rotateMap.set("degrees", "PI / 180");
rotateMap.set("radians", "1");

const timeMap: Map<TimeUnit, number> = new Map();
timeMap.set("millisecond", 1);
timeMap.set("second", 10 ** 3);
timeMap.set("minute", 60 * 10 ** 3);

function join_comma(value: string[]) {
	return value.map((el) => (el += ";\n")).join("");
}

export class RobotMLGeneratorVisitor extends RobotMlValidationVisitor {
	visitDelay(node: Delay): string {
		return `delay((int)${this.visitExpression(node.expression)} * ${timeMap.get(node.unit)})`;
	}
	visitCast(node: Cast): string {
		const type = typeMap.get(node.type);
		const expr = this.visitExpression(node.expression);
		return `(${type})(${expr})`;
	}
	symbolTable: SymbolTable;
	// Function name inside robotml => function name inside .ino
	functionDecMap: Map<string, string>;

	constructor() {
		super();
		this.symbolTable = new SymbolTable();
	}

	public setFunctionDec(functionDecMap: Map<string, string>) {
		this.functionDecMap = functionDecMap;
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
			case "GetDistance":
				return this.visitGetDistance(node as GetDistance);
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

		const inoName = this.functionDecMap.get(robotMLName);

		return `${inoName}(${node.parameters.map((p) => this.visitExpression(p)).join(", ")})`;
	}
	visitUnary(node: Unary): string {
		return `${node.op} ${this.visitExpression(node.expr)}`;
	}
	visitVariableRef(node: VariableRef): string {
		return `${node.ref.ref.name}`;
	}
	visitRobotML(node: RobotML): string {
		const robotmlFunctions = node.functions.map((p) =>
			this.visitFunctionDeclaration(p),
		);

		return `${robotmlFunctions.join("\n\n")}`;
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
		const inoName = this.functionDecMap.get(robotMLName);

		if (robotMLName == "main") {
			type = "int";
		}

		return `${type} ${inoName}( ${params} ) ${block}`;
	}
	visitRotate(node: Rotate): string {
		return `rotate(Omni,${this.visitExpression(node.expression)} * ${rotateMap.get(node.unit)})`;
	}
	visitSetSpeed(node: SetSpeed): string {
		return `speed = ${this.visitExpression(node.expression)} / ${timeMap.get(node.timeUnit) / measureMap.get(node.distanceUnit) / timeMap.get("second")}`;
	}
	visitGetSpeed(node: GetSpeed): string {
		return `speed * ${timeMap.get(node.timeUnit) / measureMap.get(node.distanceUnit) / timeMap.get("second")}`;
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
				return `backward(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
			case "Forward":
				return `forward(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
			case "Left":
				return `left(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
			case "Right":
				return `right(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
			case "LowerLeft":
				return `lowerleft(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
			case "UpperLeft":
				return `upperleft(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
			case "UpperLeft":
				return `upperleft(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
			case "UpperRight":
				return `upperright(Omni, ${this.visitExpression(node.expression)} * ${measureMap.get(node.unit)})`;
		}
	}
	visitGetDistance(node: GetDistance): string {
		return `getDistance() / ${measureMap.get(node.unit)}`;
	}
}
