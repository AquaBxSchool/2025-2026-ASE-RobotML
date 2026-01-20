grammar RobotMl
import 'Terminals'
import 'robotML-types'

entry RobotML:
    ( functions+=FunctionDeclaration )*;


AssignationDec returns AssignationDec:
    'let' variableDecl=VariableDeclaration '=' expression=Expression
;

// Assignation returns Assignation:
//     variableRef=VariableRef '=' expression=Expression
// ;



Type returns Type:
    String0 | Boolean | Integer | Float | Void
;

Statement returns Statement:
    FunctionDeclaration | Block | AssignationDec | FunctionCall | Condition | SetSpeed | SetClock | Rotate | Forward | Backward | Leftward | Rightward
;

Block returns Block:
    {Block} '{' ( statements+=Statement  )* '}'
;

Condition returns Condition:
    'if' '(' conditions+=Expression ')' block+=Block ('elif' '(' conditions+=Expression ')' block+=Block )*  ('else'  block+=Block )?
;

FunctionDeclaration returns FunctionDeclaration:
    returnType=Type name=ID '(' ( parameters+=VariableDeclaration  ("," parameters+=VariableDeclaration  )* )? ')'  block=Block
;

FunctionCall returns FunctionCall:
    functiondeclaration=[FunctionDeclaration:ID] '(' ( parameters+=[Expression:EString] ("," parameters+=[Expression:EString] )*  )? ')'
;

VariableDeclaration returns VariableDeclaration:
    name=ID (':' ^type=Type  )?
;

VariableRef returns VariableRef:
    ref=[VariableDeclaration:ID]
;

EString returns string:
    STRING | ID
;

String0 returns String0:
    {String0} 'String'
;

Boolean returns Boolean:
    {Boolean} 'Boolean'
;

Integer returns Integer:
    {Integer} 'Integer'
;

Float returns Float:
    {Float} 'Float'
;

Void returns Void:
    {Void} 'Void'
;

infix BinaryExpr on Expr:
    right assoc '^'
    > '*' | '/' 
    > '+' | '-' 
    > "==" | ">="  | "<=" | ">"  | "<"
    > "&&"
    > "||"
    ;

Expression returns Expression:
BinaryExpr;

PrimaryExpression returns Expression:
    VariableRef | INT | FunctionCall | GetSpeed | GetClock | GetSensor
;

Expr: '(' expr=Expression ')' | '-' value=Expr | value=PrimaryExpression;

GetSpeed returns GetSpeed:
    {GetSpeed} 'GetSpeed()'
;

GetClock returns GetClock:
    {GetClock} 'GetClock()'
;

GetSensor returns GetSensor:
    'GetSensor' '(' ('sensor' sensor=Sensor  )? ')'
;

SetSpeed returns SetSpeed:
    'setSpeed(' expression=Expression ')'
;

SetClock returns SetClock:
    'SetClock(' expression=Expression ')'
;

Rotate returns Rotate:
    'Rotate(' expression=Expression  ')'
;

Forward returns Forward:
    'Forward(' expression=Expression  ')'
;

Backward returns Backward:
    'Backward(' expression=Expression  ')'
;

Leftward returns Leftward:
    'Leftward(' expression=Expression  ')'
;

Rightward returns Rightward:
    'Rightward(' expression=Expression  ')'
;

BinaryOp returns BinaryOp:
    BinaryOp_AND | BinaryOp_OR | BinaryOp_NOT | BinaryOp_NOTEQUAL | BinaryOp_EQUAL | BinaryOp_LESSOREQUAL | BinaryOp_GREATEROREQUAL | BinaryOp_LESS | BinaryOp_GREATER | BinaryOp_PLUS | BinaryOp_MINUS | BinaryOp_TIMES | BinaryOp_DIVIDE | BinaryOp_MODULO
;
BinaryOp_AND returns BinaryOp_AND:
    '&&';
BinaryOp_OR returns BinaryOp_OR:
    '||';
BinaryOp_NOT returns BinaryOp_NOT:
    '!';
BinaryOp_EQUAL returns BinaryOp_EQUAL:
    '==';
BinaryOp_NOTEQUAL returns BinaryOp_NOTEQUAL:
    '!=';
BinaryOp_LESSOREQUAL returns BinaryOp_LESSOREQUAL:
    '<=';
BinaryOp_GREATEROREQUAL returns BinaryOp_GREATEROREQUAL:
    '>=';
BinaryOp_LESS returns BinaryOp_LESS:
    '<';
BinaryOp_GREATER returns BinaryOp_GREATER:
    '>';
BinaryOp_PLUS returns BinaryOp_PLUS:
    '+';
BinaryOp_MINUS returns BinaryOp_MINUS:
    '-';
BinaryOp_TIMES returns BinaryOp_TIMES:
    '*';
BinaryOp_DIVIDE returns BinaryOp_DIVIDE:
    '/';
BinaryOp_MODULO returns BinaryOp_MODULO:
    '%';

UnaryOp returns UnaryOp:
    UnaryOp_NOT | UnaryOp_MINUS
;
UnaryOp_NOT returns UnaryOp_NOT:
    '!';
UnaryOp_MINUS returns UnaryOp_MINUS:
    '-';

Sensor returns Sensor:
    Sensor_Distance | Sensor_Color
;
Sensor_Distance returns Sensor_Distance:
    'Distance';
Sensor_Color returns Sensor_Color:
    'Color';

