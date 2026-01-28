import  { ArgumentDec, Assignation, Backward, Block, Condition, Expression, FnReturn, Forward, FunctionCall, FunctionDeclaration, GetClock, GetSensor, GetSpeed, Leftward, Literal, Loop, Movement, Rightward, RobotML, RobotMlVisitor, Rotate, SetClock, SetSpeed, Statement, Unary, VariableDec, VariableRef } from "./semantics/robot-ml-visitor.js";
export class RobotMLAstPrinterVisitor implements RobotMlVisitor {
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