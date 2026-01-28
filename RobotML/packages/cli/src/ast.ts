import { createRobotMlServices } from "robot-ml-language";
import type {
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
    VariableDec as VariableDecT
} from "robot-ml-language";
import { EmptyFileSystem, Reference } from "langium";
import { parseHelper } from "langium/test";
import { parseArgs } from "util";

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
    block
    returnType: string
    parameters: ArgumentDec[]

    constructor(el: FunctionDeclarationT) {
        this.name = el.name
        this.block = new Block(el.block)
        this.returnType = el.returnType
        this.parameters = el.parameters.map(el => new ArgumentDec(el))
    }
}

class ArgumentDec implements Visitor, Statement {
    constructor(el: ArgumentDecT) {
    }
}

class Block implements Visitor, Statement {
    statements: Statement[]

    constructor(el: BlockT) {
        this.statements = el.statements.map(StatementVisit)
    }
}

class Backward implements Visitor, Statement {
    constructor(el: BackwardT) {
        throw `Not Implemented ${el.$type}`
    }
}
class Condition implements Visitor, Statement {
    blocks: Block[]
    expression: Expression[]

    constructor(el: ConditionT) {
        this.expression = el.conditions.map(ExpressionVisit)
        this.blocks = el.block.map(el => new Block(el))
        this.blocks = el.block.map(el => new Block(el))
    }
}
class Forward implements Visitor, Statement {
    constructor(el: ForwardT) {
        throw `Not Implemented ${el.$type}`
    }
}
class FunctionCall implements Visitor, Statement, Expression {
    parameters : Expression[]
    decl : string
    constructor(el: FunctionCallT) {
        this.decl = ReferenceParse(el.functiondeclaration)
        this.parameters = el.parameters
    }
}
class Leftward implements Visitor, Statement {
    constructor(el: LeftwardT) {
        throw `Not Implemented ${el.$type}`
    }
}
class Movement implements Visitor, Statement {
    constructor(el: MovementT) {
        throw `Not Implemented ${el.$type}`
    }
}
class Rightward implements Visitor, Statement {
    constructor(el: RightwardT) {
        throw `Not Implemented ${el.$type}`
    }
}
class Rotate implements Visitor, Statement {
    constructor(el: RotateT) {
        throw `Not Implemented ${el.$type}`
    }
}
class SetClock implements Visitor, Statement {
    constructor(el: SetClockT) {
        throw `Not Implemented ${el.$type}`
    }
}
class SetSpeed implements Visitor, Statement {
    constructor(el: SetSpeedT) {
        throw `Not Implemented ${el.$type}`
    }
}

class GetClock implements Visitor, Expression {
    constructor(el: GetClockT) {
        throw `Not Implemented ${el.$type}`
    }
}
class GetSensor implements Visitor, Expression {
    constructor(el: GetSensorT) {
        throw `Not Implemented ${el.$type}`
    }
}
class GetSpeed implements Visitor, Expression {
    constructor(el: GetSpeedT) {}
}
class VariableRef implements Visitor, Expression {
    ref : String
    constructor(el: VariableRefT) {
        this.ref = ReferenceParse(el.ref)
    }
}

class VariableDec implements Visitor, Statement {
    constructor(el: VariableDecT) {
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
