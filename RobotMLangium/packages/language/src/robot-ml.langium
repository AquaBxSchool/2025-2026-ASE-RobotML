grammar RobotMl

entry RobotML:
    ( functions+=FunctionDeclaration )*;

type BinaryOp = '&&'  | '||'  | '!'  | '=='  | '!='  | '<='  | '>='  | '<'  | '>'  | '+'  | '-'  | '*'  | '/'  | '%';
type UnaryOp = '!' | '-';

// Statements

interface Statement {
}

Statement returns Statement:
    FunctionDeclaration | Block | VariableDec | Loop | Assignation | FunctionCall | Condition | SetSpeed | SetClock | Rotate | Forward | Backward | Leftward | Rightward | FnReturn
;

interface FnReturn extends Statement {
    expression: Expression
}

FnReturn returns FnReturn:
    'return' expression=BinaryExpr
;

interface Block extends Statement {
    statements: Statement[]
}

Block returns Block:
    {Block} '{' ( statements+=Statement)* '}'
;

// Control Flow

interface Condition extends Statement {
    block: Block[]
    conditions: Expression[]
}

Condition returns Condition:
    'if' '(' conditions+=BinaryExpr ')' block+=Block ('elif' '(' conditions+=BinaryExpr ')' block+=Block )*  ('else'  block+=Block )?
;

interface Loop extends Statement {
	condition: Expression
	block: Block
}

Loop returns Loop:
    'while' '(' condition=BinaryExpr ')' block=Block
;

// Builtins Statements

interface SetSpeed extends Statement {
    expression: Expression
}

SetSpeed returns SetSpeed:
    'setSpeed(' expression=BinaryExpr ')'
;

interface SetClock extends Statement {
    expression: Expression
}

SetClock returns SetClock:
    'SetClock(' expression=BinaryExpr ')'
;

interface Rotate extends Statement {
    expression: Expression
}

Rotate returns Rotate:
    'Rotate(' expression=BinaryExpr  ')'
;

// Movement Statement

interface Movement extends Statement {
    expression: Expression
}

interface Forward extends Movement {
}
Forward returns Forward:
    'Forward(' expression=BinaryExpr  ')'
;

interface Backward extends Movement {
}
Backward returns Backward:
    'Backward(' expression=BinaryExpr  ')'
;

interface Leftward extends Movement {
}
Leftward returns Leftward:
    'Leftward(' expression=BinaryExpr  ')'
;

interface Rightward extends Movement {
}
Rightward returns Rightward:
    'Rightward(' expression=BinaryExpr  ')'
;

// Declaration Statemens

type Type = 'string' | 'boolean' | 'integer' | 'float' | 'void' | 'error';
Type returns Type:
    'string' | 'boolean' | 'integer' | 'float' | 'void' | 'error';

interface VariableDec extends Statement {
    name: string
    ^type?: Type
    expression?: Expression
}

VariableDec returns VariableDec:
    'let' name=ID (':' ^type=Type  )? ('=' expression=BinaryExpr)?
;

interface ArgumentDec {
    name: string
    ^type?: Type
}

ArgumentDec returns ArgumentDec:
    name=ID (':' ^type=Type  )?
;

interface FunctionDeclaration extends Statement {
    returnType: Type
    name: string
    block: Block
    parameters: ArgumentDec[]
}

FunctionDeclaration returns FunctionDeclaration:
    returnType=Type name=ID '(' ( parameters+=ArgumentDec  ("," parameters+=ArgumentDec  )* )? ')'  block=Block
;

// Asignation

interface Assignation extends Statement {
    variableRef: VariableRef
    expression: Expression
}

Assignation returns Assignation:
    variableRef=VariableRef '=' expression=BinaryExpr
;

// Expression

interface Expression {
}


interface Unary extends Expression {
    op:("-"|"!")
    expr:Expression
}

Unary returns Unary:
    op=("!"|"-") expr=Expr;

Expr returns Expression:
    '(' {Expression} BinaryExpr ')' | PrimaryExpression | {Unary} Unary;

infix BinaryExpr on Expr:
    right assoc '^'
    > '*' | '/'
    > '+' | '-'
    > "!=" | "==" | ">=" | "<=" | ">" | "<"
    > "&&"
    > "||"
    ;

interface IntLiteral extends Expression {
    value : number
}
interface StringLiteral extends Expression {
    value : string
}
interface FloatLiteral extends Expression {
    value : number
}
interface BoolLiteral extends Expression {
    value : boolean
}

PrimaryExpression:
    {VariableRef} VariableRef  |
    {FunctionCall} FunctionCall |
    {Builtins} Builtins |
    {IntLiteral} value=INT |
    {StringLiteral} value=STRING |
    {FloatLiteral} value=FLOAT |
    {BoolLiteral} value=BOOL
;

type Declaration = VariableDec | ArgumentDec;

interface VariableRef extends Expression {
    ref: @Declaration
}

VariableRef returns VariableRef:
    ref=[Declaration:ID]
;

interface FunctionCall extends Statement, Expression {
    functiondeclaration: @FunctionDeclaration
    parameters: Expression[]
}

FunctionCall returns FunctionCall:
    functiondeclaration=[FunctionDeclaration:ID] '(' ( parameters+=BinaryExpr ("," parameters+=BinaryExpr )*  )? ')'
;

// Builtins

type Builtins = GetSpeed | GetClock | GetSensor

Builtins returns Builtins:
    GetClock | GetSpeed | GetSensor
;

interface GetSpeed extends Expression {
}

GetSpeed returns GetSpeed:
    {GetSpeed} 'GetSpeed()'
;

interface GetClock extends Expression {
}

GetClock returns GetClock:
    {GetClock} 'GetClock()'
;

interface GetSensor extends Expression {
    sensor?: Sensor
}

GetSensor returns GetSensor:
    'GetSensor' '(' sensor=Sensor ')'
;

type Sensor = 'Distance' | 'Color';

Sensor returns Sensor:
    'Distance' | 'Color'
;

terminal FLOAT returns number: /[0-9]+\.[0-9]+([eE][+-]?[0-9]+)?/;
terminal BOOL returns boolean: 'true' | 'false';
terminal ID returns string:'^'? (/[a-z]+/ | /[A-Z]+/ | '_' )(/[a-z]+/ | /[A-Z]+/ | '_' | /[0-9]+/ )*;
terminal INT returns number: /[0-9]+/;
terminal STRING returns string:'"' ('\\' . |  !('\\' | '"' ))*'"'  | "'" ('\\' . |  !('\\' | "'" ))*"'";
// hidden terminal ML_COMMENT returns string:'/*'  -> '*/'  ;
// hidden terminal SL_COMMENT returns string:'//'  !('\n' | '\r' )('\r'? '\n' )?  ;
// hidden terminal WS returns string:(' ' | '\t' | '\r' | '\n' )+;

hidden terminal WS: /\s+/;
hidden terminal ML_COMMENT: /\/\*[\s\S]*?\*\//;
hidden terminal SL_COMMENT: /\/\/[^\n\r]*/;
