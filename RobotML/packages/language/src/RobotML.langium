grammar RobotML
import 'Terminals'
import 'robotML-types'

entry Assignation returns Assignation:
    'Assignation' '{' 'variableDecl' variableDecl=VariableDeclaration  'expression' expression=Expression  '}'  
;

Expression returns Expression:
    FunctionCall | Binary | Unary | VariableRef | GetSpeed | GetClock | GetSensor 
;

Type returns Type:
    String0 | Boolean | Integer | Float | Void 
;

Statement returns Statement:
    FunctionDeclaration | Block | Assignation | VariableDeclaration | FunctionCall | Condition | setSpeed | SetClock | Rotate | Forward | Backward | Leftward | Rightward 
;

VariableDeclaration returns VariableDeclaration:
    {VariableDeclaration} 'VariableDeclaration' name=EString  '{' ('type' ^type=Type  )? '}'  
;

EString returns string:
    STRING | ID 
;

String0 returns String:
    {String} 'String'  
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

FunctionCall returns FunctionCall:
    'FunctionCall' '{' 'functiondeclaration' functiondeclaration=[FunctionDeclaration:EString ] ('parameters' '(' parameters+=[Expression:EString ] ("," parameters+=[Expression:EString ] )* ')' )? 'expresion' expresion=VariableDeclaration  '}'  
;

Binary returns Binary:
    'Binary' '{' ('Operator' Operator=BinaryOp  )? 'expresion' expresion=VariableDeclaration  'expression' '{' expression+=Expression  ("," expression+=Expression  )* '}' 'operands' '{' operands+=Expression  ("," operands+=Expression  )* '}' '}'  
;

Unary returns Unary:
    'Unary' '{' ('Operator' Operator=UnaryOp  )? 'expresion' expresion=VariableDeclaration  'expression' '{' expression+=Expression  ("," expression+=Expression  )* '}' 'operand' operand=Expression  '}'  
;

VariableRef returns VariableRef:
    'VariableRef' '{' 'ref' ref=[VariableDeclaration:EString ] 'expresion' expresion=VariableDeclaration  '}'  
;

GetSpeed returns GetSpeed:
    'GetSpeed' '{' 'expresion' expresion=VariableDeclaration  '}'  
;

GetClock returns GetClock:
    'GetClock' '{' 'expresion' expresion=VariableDeclaration  '}'  
;

GetSensor returns GetSensor:
    'GetSensor' '{' ('sensor' sensor=Sensor  )? 'expresion' expresion=VariableDeclaration  '}'  
;

FunctionDeclaration returns FunctionDeclaration:
    'FunctionDeclaration' '{' 'returnType' returnType=Type  'block' block=Block  ('parameters' '{' parameters+=VariableDeclaration  ("," parameters+=VariableDeclaration  )* '}' )? '}'  
;

Block returns Block:
    {Block} 'Block' '{' ('statements' '{' statements+=Statement  ("," statements+=Statement  )* '}' )? '}'  
;

Condition returns Condition:
    'Condition' '{' 'block' '{' block+=Block  ("," block+=Block  )* '}' 'conditions' '{' conditions+=Expression  ("," conditions+=Expression  )* '}' '}'  
;

setSpeed returns setSpeed:
    'setSpeed' '{' 'expression' expression=Expression  '}'  
;

SetClock returns SetClock:
    'SetClock' '{' 'expression' expression=Expression  '}'  
;

Rotate returns Rotate:
    'Rotate' '{' 'expression' expression=Expression  '}'  
;

Forward returns Forward:
    'Forward' '{' 'expression' expression=Expression  '}'  
;

Backward returns Backward:
    'Backward' '{' 'expression' expression=Expression  '}'  
;

Leftward returns Leftward:
    'Leftward' '{' 'expression' expression=Expression  '}'  
;

Rightward returns Rightward:
    'Rightward' '{' 'expression' expression=Expression  '}'  
;

BinaryOp returns BinaryOp:
    BinaryOp_AND | BinaryOp_OR | BinaryOp_NOT | BinaryOp_EQUAL | BinaryOp_LESSOREQUAL | BinaryOp_GREATEROREQUAL | BinaryOp_LESS | BinaryOp_GREATER | BinaryOp_PLUS | BinaryOp_MINUS | BinaryOp_TIMES | BinaryOp_DIVIDE | BinaryOp_MODULO
;
BinaryOp_AND returns BinaryOp_AND: 'AND' ;
BinaryOp_OR returns BinaryOp_OR: 'OR' ;
BinaryOp_NOT returns BinaryOp_NOT: 'NOT' ;
BinaryOp_EQUAL returns BinaryOp_EQUAL: 'EQUAL' ;
BinaryOp_LESSOREQUAL returns BinaryOp_LESSOREQUAL: 'LESSOREQUAL' ;
BinaryOp_GREATEROREQUAL returns BinaryOp_GREATEROREQUAL: 'GREATEROREQUAL' ;
BinaryOp_LESS returns BinaryOp_LESS: 'LESS' ;
BinaryOp_GREATER returns BinaryOp_GREATER: 'GREATER' ;
BinaryOp_PLUS returns BinaryOp_PLUS: 'PLUS' ;
BinaryOp_MINUS returns BinaryOp_MINUS: 'MINUS' ;
BinaryOp_TIMES returns BinaryOp_TIMES: 'TIMES' ;
BinaryOp_DIVIDE returns BinaryOp_DIVIDE: 'DIVIDE' ;
BinaryOp_MODULO returns BinaryOp_MODULO: 'MODULO' ;

UnaryOp returns UnaryOp:
    UnaryOp_NOTEQUAL | UnaryOp_NEGATE
;
UnaryOp_NOTEQUAL returns UnaryOp_NOTEQUAL: 'NOTEQUAL' ;
UnaryOp_NEGATE returns UnaryOp_NEGATE: 'NEGATE' ;

Sensor returns Sensor:
    Sensor_Distance | Sensor_Color
;
Sensor_Distance returns Sensor_Distance: 'Distance' ;
Sensor_Color returns Sensor_Color: 'Color' ;

