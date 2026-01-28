import  { ArgumentDec, Assignation, Backward, Block, Condition, Expression, FnReturn, Forward, FunctionCall, FunctionDeclaration, GetClock, GetSensor, GetSpeed, Leftward, Literal, Loop, Movement, Rightward, RobotML, RobotMlVisitor, Rotate, SetClock, SetSpeed, Statement, Unary, VariableDec, VariableRef } from "./semantics/robot-ml-visitor.js";
export class RobotMLAstPrinterVisitor implements RobotMlVisitor {
    visitArgumentDec(node: ArgumentDec) {
        throw new Error("Method visitArgumentDec() not implemented.");
    }
    visitExpression(node: Expression) {
        throw new Error("Method visitExpression() not implemented.");
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
        console.log("RobotML Program")

        node.functions.map(this.visitFunctionDeclaration)
    }
    visitStatement(node: Statement) {
        throw new Error("Method visitStatement() not implemented.");
    }
    visitAssignation(node: Assignation) {
        throw new Error("Method visitAssignation() not implemented.");
    }
    visitBlock(node: Block) {
        throw new Error("Method visitBlock() not implemented.");
    }
    visitCondition(node: Condition) {
        throw new Error("Method visitCondition() not implemented.");
    }
    visitFnReturn(node: FnReturn) {
        throw new Error("Method visitFnReturn() not implemented.");
    }
    visitFunctionDeclaration(node: FunctionDeclaration) {
        console.log("FunctionDecl", node.name)
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
        throw new Error("Method visitSetSpeed() not implemented.");
    }
    visitVariableDec(node: VariableDec) {
        throw new Error("Method visitVariableDec() not implemented.");
    }
}