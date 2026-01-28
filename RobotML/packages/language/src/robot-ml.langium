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
    'return' expression=Expression
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
    'if' '(' conditions+=Expression ')' block+=Block ('elif' '(' conditions+=Expression ')' block+=Block )*  ('else'  block+=Block )?
;

interface Loop extends Statement {
	condition: Expression
	block: Block
}

Loop returns Loop:
    'while' '(' condition=Expression ')' block=Block
;

// Builtins Statements

interface SetSpeed extends Statement {
    expression: Expression
}

SetSpeed returns SetSpeed:
    'setSpeed(' expression=Expression ')'
;

interface SetClock extends Statement {
    expression: Expression
}

SetClock returns SetClock:
    'SetClock(' expression=Expression ')'
;

interface Rotate extends Statement {
    expression: Expression
}

Rotate returns Rotate:
    'Rotate(' expression=Expression  ')'
;

// Movement Statement

interface Movement extends Statement {
    expression: Expression
}

interface Forward extends Movement {
}
Forward returns Forward:
    'Forward(' expression=Expression  ')'
;

interface Backward extends Movement {
}
Backward returns Backward:
    'Backward(' expression=Expression  ')'
;

interface Leftward extends Movement {
}
Leftward returns Leftward:
    'Leftward(' expression=Expression  ')'
;

interface Rightward extends Movement {
}
Rightward returns Rightward:
    'Rightward(' expression=Expression  ')'
;

// Declaration Statemens

type Type = 'String' | 'Boolean' | 'Integer' | 'Float' | 'Void';
Type returns Type:
    'String' | 'Boolean' | 'Integer' | 'Float' | 'Void';

interface VariableDec extends Statement {
    name: string
    ^type?: Type
    expression?: Expression
}

VariableDec returns VariableDec:
    'let' name=ID (':' ^type=Type  )? ('=' expression=Expression)?
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
    variableRef=VariableRef '=' expression=Expr
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
    '(' {Expression} BinaryExpr ')' |  {Expression} BinaryExpr  | PrimaryExpression | {Unary} Unary;

infix BinaryExpr on Expr:
    right assoc '^'
    > '*' | '/'
    > '+' | '-'
    > "!=" | "==" | ">=" | "<=" | ">" | "<"
    > "&&"
    > "||"
    ;

interface Literal extends Expression {
    value : number | string | boolean
}

PrimaryExpression:
    {VariableRef} VariableRef  |
    {FunctionCall} FunctionCall |
    {Builtins} Builtins |
    {Literal} (value=INT | value=STRING | value=FLOAT | value=BOOL)
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
    functiondeclaration=[FunctionDeclaration:ID] '(' ( parameters+=Expression ("," parameters+=Expression )*  )? ')'
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
terminal BOOL returns number: 'true' | 'false';
terminal ID returns string:'^'? (/[a-z]+/ | /[A-Z]+/ | '_' )(/[a-z]+/ | /[A-Z]+/ | '_' | /[0-9]+/ )*;
terminal INT returns number: /[0-9]+/;
terminal STRING returns string:'"' ('\\' . |  !('\\' | '"' ))*'"'  | "'" ('\\' . |  !('\\' | "'" ))*"'";
// hidden terminal ML_COMMENT returns string:'/*'  -> '*/'  ;
// hidden terminal SL_COMMENT returns string:'//'  !('\n' | '\r' )('\r'? '\n' )?  ;
// hidden terminal WS returns string:(' ' | '\t' | '\r' | '\n' )+;

hidden terminal WS: /\s+/;
hidden terminal ML_COMMENT: /\/\*[\s\S]*?\*\//;
hidden terminal SL_COMMENT: /\/\/[^\n\r]*/;
