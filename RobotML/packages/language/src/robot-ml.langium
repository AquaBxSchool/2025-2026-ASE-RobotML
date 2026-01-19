grammar RobotMl
import 'Terminals'
import 'robotML-types'

entry RobotML:
    ( functions+=FunctionDeclaration )*;


Assignation returns Assignation:
    'let' variableDecl=VariableDeclaration '=' expression=Expression
;

ExpressionType:
    (FunctionCall | VariableRef | GetSpeed | GetClock | GetSensor);

Expression returns Expression:
    PrimaryExpression | Binary | '(' Expression ')'
;

// // Level 1: Logical OR
// LogicalOrExpression returns Binary:
//     operand+=LogicalAndExpression | operand+=LogicalOrExpression Operator=BinaryOp_OR operand+=LogicalAndExpression
// ;

// // Level 2: Logical AND
// LogicalAndExpression returns Binary:
//     operand+=EqualityExpression | operand+=LogicalAndExpression Operator=BinaryOp_AND operand+=EqualityExpression
// ;

// // Level 3: Equality
// EqualityExpression returns Binary:
//     operand+=RelationalExpression | 
//     operand+=EqualityExpression Operator=BinaryOp_EQUAL operand+=RelationalExpression |
//     operand+=EqualityExpression Operator=BinaryOp_NOTEQUAL operand+=RelationalExpression 
// ;

// // Level 4: Relational
// RelationalExpression returns Binary:
//     operand+=AdditiveExpression | 
//     operand+=RelationalExpression Operator=BinaryOp_LESS operand+=AdditiveExpression |
//     operand+=RelationalExpression Operator=BinaryOp_LESSOREQUAL operand+=AdditiveExpression |
//     operand+=RelationalExpression Operator=BinaryOp_GREATER operand+=AdditiveExpression |
//     operand+=RelationalExpression Operator=BinaryOp_GREATEROREQUAL operand+=AdditiveExpression 
// ;

// // Level 5: Additive
// AdditiveExpression returns Binary:
//     operand+=MultiplicativeExpression | 
//     operand+=AdditiveExpression Operator=BinaryOp_PLUS operand+=MultiplicativeExpression |
//     operand+=AdditiveExpression Operator=BinaryOp_MINUS operand+=MultiplicativeExpression
// ;

// // Level 6: Multiplicative
// MultiplicativeExpression returns Binary:
//     operand+=UnaryExpression | 
//     operand+=MultiplicativeExpression Operator=BinaryOp_DIVIDE operand+=UnaryExpression |
//     operand+=MultiplicativeExpression Operator=BinaryOp_TIMES operand+=UnaryExpression
// ;

// // Level 7: Cast (Left-associative usually)
// // CastExpression returns Expression:
// //     UnaryExpression | 
// //     CastExpression 'as' Type
// // ;

// // Level 8: Unary (Right-associative is OK in Langium!)
// UnaryExpression returns Unary:
//     operand=PostfixExpression |
//     Operator=UnaryOp_MINUS operand=UnaryExpression |
//     Operator=UnaryOp_NOT operand=UnaryExpression;

// // Level 9: Postfix (Function calls, Array access)
// PostfixExpression returns Expression:
//     PrimaryExpression |
//     // PostfixExpression '(' argument_expression_list ')'
// ;

// // Level 10: Primary (The bottom of the chain)
PrimaryExpression returns Expression:
    VariableRef | INT | FunctionCall | GetSpeed | GetClock | GetSensor
;


Type returns Type:
    String0 | Boolean | Integer | Float | Void
;

Statement returns Statement:
    FunctionDeclaration | Block | Assignation | FunctionCall | Condition | SetSpeed | SetClock | Rotate | Forward | Backward | Leftward | Rightward
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

Binary returns Binary:
    operands+=PrimaryExpression Operator=BinaryOp operands+=Expression
;

Unary returns Unary:
    Operator=UnaryOp operand=Expression
;

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

