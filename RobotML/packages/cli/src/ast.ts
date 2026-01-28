import { createRobotMlServices } from "robot-ml-language";
import {
    FunctionDeclaration as FunctionDeclarationT,
    RobotML as RobotMLT,
    Block as BlockT,
    Statement as StatementT,
    Backward as BackwardT,
    Condition as ConditionT,
    Forward as ForwardT,
    FunctionCall as FunctionCallT,
    Leftward as LeftwardT,
    Movement as MovementT,
    Rightward as RightwardT,
    Rotate as RotateT,
    SetClock as SetClockT,
    SetSpeed as SetSpeedT,
    Expression as ExpressionT,
    ArgumentDec as ArgumentDecT,
    GetClock as GetClockT,
    GetSensor as GetSensorT,
    GetSpeed as GetSpeedT,
    VariableRef as VariableRefT,
    VariableDec as VariableDecT,
    Loop as LoopT,
    Type as TypeT,
    Unary as UnaryT,
    Literal as LiteralT,
    BinaryExpr as BinaryExprT,
    FnReturn as FnReturnT,
    Assignation as AssignationT
} from "robot-ml-language";
import { EmptyFileSystem, Reference } from "langium";
import { parseHelper } from "langium/test";
import { parseArgs } from "util";
import assert from "assert";

interface Visitor { }
interface Statement { }
interface Expression { }

class Robot implements Visitor {
    functions: FunctionDeclaration[]

    constructor(robot: RobotMLT) {
        this.functions = robot.functions.map(el => new FunctionDeclaration(el))
    }
}

class FunctionDeclaration implements Visitor, Statement {
    name: string
    block: Block
    returnType: TypeT
    parameters: ArgumentDec[]

    constructor(el: FunctionDeclarationT) {
        assert.strictEqual(el.$type,  "FunctionDeclaration");

        this.name = el.name
        this.block = new Block(el.block)
        this.returnType = el.returnType
        this.parameters = el.parameters.map(el => new ArgumentDec(el))
    }
}

class ArgumentDec implements Visitor, Statement {
    name: string
    returnType?: TypeT

    constructor(el: ArgumentDecT) {
      this.name = el.name
      this.returnType = el.type
    }
}

class Block implements Visitor, Statement {
    statements: Statement[]

    constructor(el: BlockT) {
        assert.strictEqual(el.$type,  "Block");
        this.statements = el.statements.map(StatementVisit)
    }
}

class Backward implements Visitor, Statement {
    constructor(el: BackwardT) {
        assert.strictEqual(el.$type,  "Backward");
        throw `Not Implemented ${el.$type}`
    }
}
class Condition implements Visitor, Statement {
    blocks: Block[]
    expression: Expression[]

    constructor(el: ConditionT) {
        assert.strictEqual(el.$type,  "Condition");
        console.log(el)
        console.log(el.conditions)
        this.expression = el.conditions.map(ExpressionVisit)
        this.blocks = el.block.map(el => new Block(el))
    }
}
class Forward implements Visitor, Statement {
    constructor(el: ForwardT) {
        assert.strictEqual(el.$type,  "Forward");
        throw `Not Implemented ${el.$type}`
    }
}
class FunctionCall implements Visitor, Statement, Expression {
    parameters : Expression[]
    decl : string
    constructor(el: FunctionCallT) {
        assert.strictEqual(el.$type,  "FunctionCall");
        this.decl = ReferenceParse(el.functiondeclaration)
        this.parameters = el.parameters
    }
}
class Leftward implements Visitor, Statement {
    constructor(el: LeftwardT) {
        assert.strictEqual(el.$type,  "Leftward");
        throw `Not Implemented ${el.$type}`
    }
}
class Movement implements Visitor, Statement {
    constructor(el: MovementT) {
        assert.strictEqual(el.$type,  "Movement");
        throw `Not Implemented ${el.$type}`
    }
}
class Rightward implements Visitor, Statement {
    constructor(el: RightwardT) {
        assert.strictEqual(el.$type,  "Rightward");
        throw `Not Implemented ${el.$type}`
    }
}
class Rotate implements Visitor, Statement {
    constructor(el: RotateT) {
        assert.strictEqual(el.$type,  "Rotate");
        throw `Not Implemented ${el.$type}`
    }
}
class SetClock implements Visitor, Statement {
    constructor(el: SetClockT) {
        assert.strictEqual(el.$type,  "SetClock");
        throw `Not Implemented ${el.$type}`
    }
}

class SetSpeed implements Visitor, Statement {
    constructor(el: SetSpeedT) {
        assert.strictEqual(el.$type,  "SetSpeed");
        throw `Not Implemented ${el.$type}`
    }
}

class VariableDec implements Visitor, Statement {
    name : string
    type ?: TypeT
    expression ?: Expression
    constructor(el: VariableDecT) {
        this.name = el.name
        this.type = el.type
        this.expression = el.expression ? ExpressionVisit(el.expression) : undefined
    }
}

class GetClock implements Visitor, Expression {
    constructor(el: GetClockT) {
        assert.strictEqual(el.$type,  "GetClock");
        throw `Not Implemented ${el.$type}`
    }
}
class GetSensor implements Visitor, Expression {
    constructor(el: GetSensorT) {
        assert.strictEqual(el.$type,  "GetSensor");
        throw `Not Implemented ${el.$type}`
    }
}
class GetSpeed implements Visitor, Expression {
    constructor(el: GetSpeedT) {}
}

class Unary implements Visitor, Expression {
    op : "-"|"!"
    expr : Expression
    constructor(el: UnaryT) {
        this.op = el.op
        this.expr = ExpressionVisit(el.expr)
    }
}

class BinaryExpression implements Visitor, Expression {
    operator : any
    left : Expression
    right : Expression
    constructor(el: BinaryExprT) {
        this.left = ExpressionVisit(el.left)
        this.right = ExpressionVisit(el.right)
        this.operator = el.operator
    }
}

class VariableRef implements Visitor, Expression {
    ref : String
    constructor(el: VariableRefT) {
        assert.strictEqual(el.$type,  "VariableRef");
        this.ref = ReferenceParse(el.ref)
    }
}

class Literal<T> implements Visitor, Expression {
    value : T
    constructor(el: T) {
        this.value = el
    }
}

class Loop implements Visitor, Statement {
    condition: Expression
    block: Block
    constructor(el: LoopT) {

        assert.strictEqual(el.$type,  "Loop");
        this.condition =  ExpressionVisit(el.condition)
        this.block = new Block(el.block)
    }
}

class Assignation implements Visitor, Statement {
  variable: string
  expr: Expression

  constructor(el: AssignationT) {
      this.variable = ReferenceParse(el.variableRef.ref)
      this.expr = ExpressionVisit(el.expression)
  }
}

class FnReturn implements Visitor, Statement {
  expr: Expression
  constructor(el: FnReturnT) {
    this.expr = ExpressionVisit(el.expression)
  }
}

function ReferenceParse(el:Reference) {
    return el.$refText
}

function ExpressionVisit(el: ExpressionT): Expression {
    switch (el.$type) {
        case "FunctionCall": {
            return new FunctionCall(el as FunctionCallT)
        }
        case "GetClock": {
            return new GetClock(el as GetClockT)
        }
        case "GetSensor": {
            return new GetSensor(el as GetSensorT)
        }
        case "GetSpeed": {
            return new GetSpeed(el as GetSpeedT)
        }
        case "VariableRef": {
            return new VariableRef(el as VariableRefT)
        }
        case "BinaryExpr": {
            return new BinaryExpression(el as BinaryExprT)
        }
        case "Unary": {
            return new Unary(el as UnaryT)
        }
        case "Literal": {
            return new Literal((el as LiteralT).value)
        }
        default: {
            throw `Expression Not defined ${el.$type}`
        }
    }
}

function StatementVisit(el: StatementT): Statement {
    switch (el.$type) {
        case "Backward": {
            return new Backward(el as BackwardT)
        }
        case "Block": {
            return new Block(el as BlockT)
        }
        case "Condition": {
            return new Condition(el as ConditionT)
        }
        case "Forward": {
            return new Forward(el as ForwardT)
        }
        case "FunctionCall": {
            return new FunctionCall(el as FunctionCallT)
        }
        case "FunctionDeclaration": {
            return new FunctionDeclaration(el as FunctionDeclarationT)
        }
        case "Leftward": {
            return new Leftward(el as LeftwardT)
        }
        case "Movement": {
            return new Movement(el as MovementT)
        }
        case "Rightward": {
            return new Rightward(el as RightwardT)
        }
        case "Rotate": {
            return new Rotate(el as RotateT)
        }
        case "SetClock": {
            return new SetClock(el as SetClockT)
        }
        case "SetSpeed": {
            return new SetSpeed(el as SetSpeedT)
        }
        case "VariableDec": {
            return new VariableDec(el as VariableDecT)
        }
        case "Loop": {
            return new Loop(el as LoopT)
        }
        case "Assignation": {
            return new Assignation(el as AssignationT)
        }
        case "FnReturn": {
          return new FnReturn(el as FnReturnT)
        }
        default: {
            throw `Statement Not defined ${el.$type}`
        }
    }
}

const services = createRobotMlServices(EmptyFileSystem);
const parse = parseHelper(services.RobotMl);

const { values } = parseArgs({
  args: Bun.argv,
  options: {
    file: {
      type: "string",
    },
  },
  strict: true,
  allowPositionals: true,
});

if (values.file === undefined) {
    throw "File not providen"
}

const file = Bun.file(values.file);
console.log(file)
const filetext = await file.text()
const document = await parse(filetext, { validation: true }); //enable validation, otherwise the validator will not be called!

const ast = new Robot(document.parseResult.value as RobotMLT)
console.log(JSON.stringify(ast,null,2))
