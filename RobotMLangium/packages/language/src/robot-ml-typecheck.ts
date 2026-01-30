import type { BinaryExpr } from "./generated.ts";
import { SymbolTable } from "./SymbolTable.ts";
import {
	type ArgumentDec,
	type Assignation,
	type Backward,
	type Block,
	BoolLiteral,
	type Condition,
	type Expression,
	FloatLiteral,
	type FnReturn,
	type Forward,
	type FunctionCall,
	type FunctionDeclaration,
	type GetClock,
	type GetSensor,
	type GetSpeed,
	IntLiteral,
	type Leftward,
	type Loop,
	type Movement,
	type Rightward,
	type RobotML,
	RobotMlValidationVisitor,
	type Rotate,
	type SetClock,
	type SetSpeed,
	type Statement,
	StringLiteral,
	type Type,
	type Unary,
	type VariableDec,
	type VariableRef,
} from "./semantics.ts";

interface Value {
	type: Type;
}

export class RobotMLTypeCheckVisitor extends RobotMlValidationVisitor {
	visitBoolLiteral(node: BoolLiteral): Value {
		return { type: "boolean" };
	}
	visitFloatLiteral(node: FloatLiteral): Value {
		return { type: "float" };
	}
	visitIntLiteral(node: IntLiteral): Value {
		return { type: "integer" };
	}
	visitStringLiteral(node: StringLiteral): Value {
		return { type: "string" };
	}
	symbolTable: SymbolTable;

	constructor() {
		super();
		this.symbolTable = new SymbolTable();
	}
	visitArgumentDec(node: ArgumentDec) {
		this.symbolTable.put(node.name, node.type, { node: node });
	}
	visitExpression(node: Expression): Value {
		switch (node.$type) {
			case "BinaryExpr": {
				const node2 = node as unknown as BinaryExpr;

				switch (node2.operator) {
					// bool only
					case "&&":
					case "||": {
						const { type: typeL } =
							this.visitExpression(
								node2.left as unknown as Expression,
							);
						const { type: typeR } =
							this.visitExpression(
								node2.right as unknown as Expression,
							);
						if (
							typeL !== typeR ||
							typeL !== "boolean"
						) {
							this.validationAccept(
								"error",
								`Could not apply the operation ${node2.operator} between a ${typeL} and a ${typeR} ${node}`,
								{
									node: node,
								},
							);
							throw "Error";
						}
						return { type: "boolean" };
					}

					// t1 == t1 or int == float or float == int
					case "!=":
					case "==": {
						const { type: typeL } =
							this.visitExpression(
								node2.left as unknown as Expression,
							);
						const { type: typeR } =
							this.visitExpression(
								node2.right as unknown as Expression,
							);

						const checkNumber =
							(typeL === "float" &&
								typeR === "integer") ||
							(typeL === "integer" &&
								typeR === "float");

						if (
							!(
								typeL === typeR &&
								typeL !== "void"
							) &&
							!checkNumber
						) {
							this.validationAccept(
								"error",
								`Could not apply the operation ${node2.operator} between a ${typeL} and a ${typeR} ${node}`,
								{
									node: node,
								},
							);
							throw "Error";
						}
						return { type: "boolean" };
					}

					// (t1 == t1 and t1 != bool and t1 != t1) or int + float or float + int

					case "+": {
						const { type: typeL } =
							this.visitExpression(
								node2.left as unknown as Expression,
							);
						const { type: typeR } =
							this.visitExpression(
								node2.right as unknown as Expression,
							);

						const checkNumber =
							(typeL === "float" &&
								typeR === "integer") ||
							(typeL === "integer" &&
								typeR === "float");

						if (
							!(
								typeL === typeR &&
								typeL !== "boolean" &&
								typeL !== "void"
							) &&
							!checkNumber
						) {
							this.validationAccept(
								"error",
								`Could not add a ${typeL} to a ${typeR} ${node}`,
								{
									node: node,
								},
							);
							throw "Error";
						}

						if (checkNumber) {
							return { type: "float" };
						} else {
							return { type: typeR };
						}
					}

					case "*":
					case "-":
					case "/":
					case "^": {
						const { type: typeL } =
							this.visitExpression(
								node2.left as unknown as Expression,
							);
						const { type: typeR } =
							this.visitExpression(
								node2.right as unknown as Expression,
							);

						const checkNumber1 =
							(typeL === "float" &&
								typeR === "integer") ||
							(typeL === "integer" &&
								typeR === "float");

						const checkNumber2 =
							(typeL === "float" &&
								typeR === "float") ||
							(typeL === "integer" &&
								typeR === "integer");

						if (!checkNumber1 && !checkNumber2) {
							this.validationAccept(
								"error",
								`Could not apply the operation ${node2.operator} between a ${typeL} and a ${typeR} ${node}`,
								{
									node: node,
								},
							);
							throw "Error";
						}

						if (checkNumber1) {
							return { type: "float" };
						} else {
							return { type: typeR };
						}
					}

					case "<":
					case "<=":
					case ">":
					case ">=": {
						const { type: typeL } =
							this.visitExpression(
								node2.left as unknown as Expression,
							);
						const { type: typeR } =
							this.visitExpression(
								node2.right as unknown as Expression,
							);

						const checkNumber1 =
							(typeL === "float" &&
								typeR === "integer") ||
							(typeL === "integer" &&
								typeR === "float");

						const checkNumber2 =
							(typeL === "float" &&
								typeR === "float") ||
							(typeL === "integer" &&
								typeR === "integer");

						if (!checkNumber1 && !checkNumber2) {
							this.validationAccept(
								"error",
								`Could not apply the operation ${node2.operator} between a ${typeL} and a ${typeR} ${node}`,
								{
									node: node,
								},
							);
							throw "Error";
						}
						return { type: "boolean" };
					}
				}
				return;
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
	visitFunctionCall(node: FunctionCall): Value {
		const name = node.functiondeclaration.ref.name;
		if (!this.symbolTable.inScope(name)) {
			this.validationAccept(
				"error",
				`Function ${name} does not exist`,
				{
					node: node,
				},
			);
		}

		node.parameters.forEach((e) => {
			// TODO do check on function arguments <=> parameters expression
			this.visitExpression(e);
		});

		const type = this.symbolTable.type(name);

		if (!type) {
			this.validationAccept(
				"warning",
				`Can't find function return type`,
				{
					node: node,
				},
			);
		}

		return { type: type ?? "void" };
	}
	visitGetClock(_node: GetClock): Value {
		return { type: "integer" };
	}
	visitGetSensor(_node: GetSensor): Value {
		return { type: "float" };
	}
	visitGetSpeed(_node: GetSpeed): Value {
		return { type: "float" };
	}
	visitUnary(node: Unary): Value {
		const { type } = this.visitExpression(node.expr);

		const check =
			(node.op === "!" && type === "boolean") ||
			(node.op === "-" && (type === "integer" || type === "float"));

		if (!check) {
			this.validationAccept(
				"error",
				`Could not apply ${node.op} on a ${type}`,
				{
					node: node,
				},
			);
		}

		return { type: type };
	}
	visitVariableRef(node: VariableRef): Value {
		if (!node.ref.ref) {
			this.validationAccept("error", `ref does not exist`, {
				node: node,
			});
		}

		const name = node.ref.ref.name;

		if (!this.symbolTable.inScope(name)) {
			// console.trace(this.symbolTable.inScope(name));
			this.validationAccept(
				"error",
				`Variable ${name} does not exist`,
				{
					node: node,
				},
			);
		}

		const type = this.symbolTable.type(name);

		if (!type) {
			this.validationAccept("warning", `Can't find variable type`, {
				node: node,
			});
		}

		return { type: type ?? "void" };
	}
	visitRobotML(node: RobotML) {
		// throw new Error("Method not implemented.");

		const main_function = node.functions.find((f) => f.name === "main");
		if (main_function === undefined) {
			this.validationAccept(
				"error",
				"There is no main functions defined",
				{
					node: node,
				},
			);
		}

		this.symbolTable.beginScope();

		node.functions.forEach((node) => {
			this.visitFunctionDeclaration(node);
		});

		this.symbolTable.endScope();
	}
	visitStatement(node: Statement) {
		try {
			switch (node.$type) {
				case "FunctionDeclaration":
					this.visitFunctionDeclaration(
						node as FunctionDeclaration,
					);
					break;
				case "Block":
					this.visitBlock(node as Block);
					break;
				case "VariableDec":
					this.visitVariableDec(node as VariableDec);
					break;
				case "Loop":
					this.visitLoop(node as Loop);
					break;
				case "Assignation":
					this.visitAssignation(node as Assignation);
					break;
				case "FunctionCall":
					this.visitFunctionCall(node as FunctionCall);
					break;
				case "Condition":
					this.visitCondition(node as Condition);
					break;
				case "SetSpeed":
					this.visitSetSpeed(node as SetSpeed);
					break;
				case "SetClock":
					this.visitSetClock(node as SetClock);
					break;
				case "Rotate":
					this.visitRotate(node as Rotate);
					break;
				case "Forward":
					this.visitForward(node as Forward);
					break;
				case "Backward":
					this.visitBackward(node as Backward);
					break;
				case "Leftward":
					this.visitLeftward(node as Leftward);
					break;
				case "Rightward":
					this.visitRightward(node as Rightward);
					break;
				case "FnReturn":
					this.visitFnReturn(node as FnReturn);
					break;
				default:
					break;
			}
		} catch {}
	}
	visitAssignation(node: Assignation) {
		this.visitVariableRef(node.variableRef);
		this.visitExpression(node.expression);
		// FIXME: Check type
	}

	visitBlock(node: Block) {
		this.symbolTable.beginScope();

		node.statements.forEach((s) => {
			this.visitStatement(s);
		});

		this.symbolTable.beginScope();
	}
	visitCondition(node: Condition) {
		node.conditions.forEach((value, index) => {
			this.visitExpression(value);
			this.visitBlock(node.block.at(index));
		});

		if (node.conditions.length < node.block.length) {
			this.visitBlock(node.block.at(-1));
		}
	}
	visitFnReturn(node: FnReturn) {
		// TODO add check for return type on function decl
		this.visitExpression(node.expression);
	}
	visitFunctionDeclaration(node: FunctionDeclaration) {
		var type = node.returnType ?? "void";

		this.symbolTable.put(node.name, type, { node: node });

		node.parameters.forEach((p) => {
			this.visitArgumentDec(p);
		});

		this.visitBlock(node.block);
	}
	visitLoop(node: Loop) {
		this.visitExpression(node.condition);
		this.visitBlock(node.block);
	}
	visitMovement(node: Movement) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`Movement does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitBackward(node: Backward) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`Backward does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitForward(node: Forward) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`Forward does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitLeftward(node: Leftward) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`Leftward does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitRightward(node: Rightward) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`Rightward does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitRotate(node: Rotate) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`Rotate does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitSetClock(node: SetClock) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`SetClock does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitSetSpeed(node: SetSpeed) {
		const { type } = this.visitExpression(node.expression);
		if (type !== "float" && type !== "integer") {
			this.validationAccept(
				"error",
				`SetSpeed does not support type ${type}`,
				{
					node: node,
				},
			);
		}
	}
	visitVariableDec(node: VariableDec) {
		if (node.expression) {
			const { type } = this.visitExpression(node.expression);
			if (!node.type) {
				node.type = type;
			}
			if (node.type !== type) {
				this.validationAccept(
					"error",
					`Missmatch type between rtype ${type} and ltype ${node.type} `,
					{
						node: node,
					},
				);
			}
		}

		if (!node.name.startsWith("_")) {
			this.symbolTable.put(node.name, node.type ?? "void", { node });
		}
	}
}
