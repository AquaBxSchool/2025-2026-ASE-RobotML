import type {
  ArgumentDec,
  Assignation,
  Backward,
  Block,
  Condition,
  Expression,
  FnReturn,
  Forward,
  FunctionCall,
  FunctionDeclaration,
  GetClock,
  GetSensor,
  GetSpeed,
  Leftward,
  Literal,
  Loop,
  Movement,
  Rightward,
  RobotML,
  RobotMlVisitor,
  Rotate,
  SetClock,
  SetSpeed,
  Statement,
  Unary,
  VariableDec,
  VariableRef,
} from "./semantics.ts";

function print(text: string) {
  process.stdout.write(text);
}

export class RobotMLAstPrinterVisitor implements RobotMlVisitor {
  visitArgumentDec(node: ArgumentDec) {
    print(`${node.name} ${node.type ? ": " + node.type : ""}`);
  }
  visitExpression(node: Expression) {
    print('Expression')
  }
  visitFunctionCall(node: FunctionCall) {
    throw new Error("Method visitFunctionCall() not implemented.");
  }
  visitGetClock(node: GetClock) {
    throw new Error("Method visitGetClock() not implemented.");
  }
  visitGetSensor(node: GetSensor) {
    throw new Error("Method visitGetSensor() not implemented.");
  }
  visitGetSpeed(node: GetSpeed) {
    throw new Error("Method visitGetSpeed() not implemented.");
  }
  visitLiteral(node: Literal) {
    throw new Error("Method visitLiteral() not implemented.");
  }
  visitUnary(node: Unary) {
    throw new Error("Method visitUnary() not implemented.");
  }
  visitVariableRef(node: VariableRef) {
    throw new Error("Method visitVariableRef() not implemented.");
  }
  visitRobotML(node: RobotML) {
    print("RobotML Program\n");

    node.functions.forEach((node) => { this.visitFunctionDeclaration(node); });
  }
  visitStatement(node: Statement) {
    switch (node.$type) {
      case "FunctionDeclaration":
        this.visitFunctionDeclaration(node as FunctionDeclaration);
        break;
      case "VariableDec":
        this.visitVariableDec(node as VariableDec);
        break;
      case "SetSpeed":
        this.visitSetSpeed(node as SetSpeed);
        break;
      case "FnReturn":
        this.visitFnReturn(node as FnReturn);
        break;

      default:
        throw new Error(`Undefined Statement: ${node.$type}`);
    }
  }
  visitAssignation(node: Assignation) {
    throw new Error("Method visitAssignation() not implemented.");
  }
  visitBlock(node: Block) {
    print("{\n");

    node.statements.forEach((p) => {
      this.visitStatement(p);
    });

    print("\n}\n");
  }
  visitCondition(node: Condition) {
    throw new Error("Method visitCondition() not implemented.");
  }
  visitFnReturn(node: FnReturn) {
    print('return ')
    this.visitExpression(node.expression)
  }
  visitFunctionDeclaration(node: FunctionDeclaration) {
    print("FunctionDecl(");

    node.parameters.forEach((p) => {
      this.visitArgumentDec(p);
      print(",");
    });

    print(") ");

    this.visitBlock(node.block);
  }
  visitLoop(node: Loop) {
    throw new Error("Method visitLoop() not implemented.");
  }
  visitMovement(node: Movement) {
    throw new Error("Method visitMovement() not implemented.");
  }
  visitBackward(node: Backward) {
    throw new Error("Method visitBackward() not implemented.");
  }
  visitForward(node: Forward) {
    throw new Error("Method visitForward() not implemented.");
  }
  visitLeftward(node: Leftward) {
    throw new Error("Method visitLeftward() not implemented.");
  }
  visitRightward(node: Rightward) {
    throw new Error("Method visitRightward() not implemented.");
  }
  visitRotate(node: Rotate) {
    throw new Error("Method visitRotate() not implemented.");
  }
  visitSetClock(node: SetClock) {
    throw new Error("Method visitSetClock() not implemented.");
  }
  visitSetSpeed(node: SetSpeed) {
    print("visitSetSpeed\n")
  }
  visitVariableDec(node: VariableDec) {
    print(`visitVariableDec(${node.name})\n`)
  }
}
