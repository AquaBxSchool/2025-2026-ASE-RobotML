type BinaryOp = BinaryOp_AND | BinaryOp_OR | BinaryOp_NOT | BinaryOp_EQUAL | BinaryOp_NOTEQUAL | BinaryOp_LESSOREQUAL | BinaryOp_GREATEROREQUAL | BinaryOp_LESS | BinaryOp_GREATER | BinaryOp_PLUS | BinaryOp_MINUS | BinaryOp_TIMES | BinaryOp_DIVIDE | BinaryOp_MODULO;
type BinaryOp_AND = '&&';
type BinaryOp_OR = '||';
type BinaryOp_NOT = '!';
type BinaryOp_EQUAL = '==';
type BinaryOp_NOTEQUAL = '!=';
type BinaryOp_LESSOREQUAL = '<=';
type BinaryOp_GREATEROREQUAL = '>=';
type BinaryOp_LESS = '<';
type BinaryOp_GREATER = '>';
type BinaryOp_PLUS = '+';
type BinaryOp_MINUS = '-';
type BinaryOp_TIMES = '*';
type BinaryOp_DIVIDE = '/';
type BinaryOp_MODULO = '%';

type UnaryOp = UnaryOp_NOT | UnaryOp_MINUS;
type UnaryOp_NOT = '!';
type UnaryOp_MINUS = '-';

type Sensor = Sensor_Distance | Sensor_Color;
type Sensor_Distance = 'Distance';
type Sensor_Color = 'Color';

interface Assignation extends Statement {
	variableDecl: VariableDeclaration
	expression: Expression
}

interface Statement {
}

interface VariableDeclaration extends Statement {
	^type?: Type
	name: string
}

interface Type {
}

interface Expression {
}

interface String0 extends Type {
}

interface Boolean extends Type {
}

interface Integer extends Type {
}

interface Float extends Type {
}

interface Void extends Type {
}

interface FunctionCall extends Statement, Expression {
	functiondeclaration: @FunctionDeclaration
	parameters: @Expression[]
}

interface FunctionDeclaration extends Statement {
	returnType: Type
	name: string
	block: Block
	parameters: VariableDeclaration[]
}

interface Block extends Statement {
	statements: Statement[]
}

interface Binary extends Operation {
	operands: Expression[]
	Operator?: BinaryOp
}

interface Operation extends Expression {
	expression: Expression[]
}

interface Unary extends Operation {
	operand: Expression
	Operator?: UnaryOp
}

interface VariableRef extends Expression {
	ref: @VariableDeclaration
}

interface GetSpeed extends Expression {
}

interface GetClock extends Expression {
}

interface GetSensor extends Expression {
	sensor?: Sensor
}

interface Condition extends Statement {
	block: Block[]
	conditions: Expression[]
}

interface setSpeed extends Statement {
	expression: Expression
}

interface SetClock extends Statement {
	expression: Expression
}

interface Rotate extends Statement {
	expression: Expression
}

interface Forward extends Mouvement {
}

interface Mouvement extends Statement {
	expression: Expression
}

interface Backward extends Mouvement {
}

interface Leftward extends Mouvement {
}

interface Rightward extends Mouvement {
}

