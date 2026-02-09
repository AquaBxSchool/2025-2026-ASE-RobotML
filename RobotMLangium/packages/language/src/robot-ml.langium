grammar RobotMl

entry RobotML:
    ( functions+=FunctionDeclaration )*;

type BinaryOp = '&&'  | '||'  | '!'  | '=='  | '!='  | '<='  | '>='  | '<'  | '>'  | '+'  | '-'  | '*'  | '/'  | '%';
type UnaryOp = '!' | '-';

// Statements

interface Statement {
}

Statement returns Statement:
    FunctionDeclaration | Block | Delay | VariableDec | Loop | Assignation | FunctionCall | Condition | SetSpeed | Rotate | Movement | FnReturn
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
    unit1: DistanceUnit
    unit2: TimeUnit
}

SetSpeed returns SetSpeed:
    'SetSpeed(' expression=BinaryExpr ',' unit1=DistanceUnit ',' unit2=TimeUnit ')'
;

type TimeUnit =
    "millisecond" |
    "second" |
    "minute";

TimeUnit returns TimeUnit:
    "millisecond" |
    "second" |
    "minute";

interface Delay extends Statement {
    expression: Expression
    unit: TimeUnit
}

Delay returns Delay:
    'Delay(' expression=BinaryExpr ',' unit=TimeUnit ')'
;

interface Rotate extends Statement {
    expression: Expression
    unit: RotateType
}

type RotateType =
    "degrees"|"radians";
RotateType returns RotateType:
    "degrees"|"radians"
;

Rotate returns Rotate:
    'Rotate(' expression=BinaryExpr ',' unit=RotateType  ')'
;

// Movement Statement

type MovementType =
    "LowerLeft" |
    "UpperRight" |
    "LowerRight" |
    "UpperLeft" |
    "Forward" |
    "Backward" |
    "Left" |
    "Right"
;

MovementType returns MovementType:
    "LowerLeft" |
    "UpperRight" |
    "LowerRight" |
    "UpperLeft" |
    "Forward" |
    "Backward" |
    "Left" |
    "Right"
;

type DistanceUnit =
    "millimeter" |
    "centimeter" |
    "decimeter" |
    "meter"
;

DistanceUnit returns DistanceUnit:
    "millimeter" |
    "centimeter" |
    "decimeter" |
    "meter"
;

interface Movement extends Statement {
    expression: Expression
    type: MovementType
    unit: DistanceUnit
}

Movement returns Movement:
    'Move(' type=MovementType ',' expression=Expr ',' unit=DistanceUnit ')';

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

Unary returns Expression:
    {Unary} op=("!"|"-") expr=Atomic;

interface Cast extends Expression {
    expression: Expression
    type: Type
}

Cast returns Expression:
    {Cast} expression=Atomic 'in' type=Type;

PrimaryExpr returns Expression:
    Unary | Cast | Atomic;

Atomic returns Expression:
    '(' Expr ')' | PrimaryExpression;

Expr returns Expression:
    BinaryExpr;

infix BinaryExpr on PrimaryExpr:
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

type Builtins = GetSpeed | GetDistance

Builtins returns Builtins:
    GetSpeed | GetDistance
;

interface GetSpeed extends Expression {
    unit1: DistanceUnit
    unit2: TimeUnit
}

GetSpeed returns GetSpeed:
    {GetSpeed} 'GetSpeed(' unit1=DistanceUnit ',' unit2=TimeUnit ')'
;

interface GetDistance extends Expression {
    unit: DistanceUnit
}

GetDistance returns GetDistance:
    'GetDistance' '(' unit=DistanceUnit ')'
;

terminal FLOAT returns number: /[0-9]+\.[0-9]*([eE][+-]?[0-9]+)?/;
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
