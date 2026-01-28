class Stack<T> {
	list: Array<T> = [];
	push(el: T) {
		this.list.push(el);
	}
	pop(): T {
		return this.list.splice(0, 1)[0];
	}
	at(i: number): T | undefined {
		return this.list.at(i);
	}
}

export class SymbolTable {
	scopes = new Stack<Map<String, SymbolInfo>>();

	beginScope() {
		this.scopes.push(new Map());
	}

	/**
	 * Remove top scope from the looking table
	 *
	 * @throws EmptyStackException if the scope stack is empty
	 */
	endScope() {
		this.scopes.pop();
	}

	/**
	 * Add element to the local scope
	 *
	 * @throws EmptyStackException if the scopes stack is empty.
	 */
	put(symbol: String, symbol_info: SymbolInfo) {
		this.scopes.at(-1)?.set(symbol, symbol_info);
	}

	inScope(symbol: string): boolean {
		for (let scope of this.scopes.list) {
			if (Object.keys(scope).includes(symbol)) {
				return true;
			}
		}
		return false;
	}

	toString(): String {
		let retString = "";
		for (let scope of this.scopes.list) {
			retString += `${Object.values(scope).join("\n")}\n`;
		}
		return retString;
	}
}

export class SymbolInfo {
	private line: number;
	private column: number;
	private content: string;

	constructor(l: number, col: number, con: string) {
		this.line = l;
		this.column = col;
		this.content = con;
	}

	public getLine(): number {
		return this.line;
	}

	public setLine(l: number) {
		this.line = l;
	}

	public getColumn(): number {
		return this.column;
	}

	public setColumn(c: number) {
		this.column = c;
	}

	public getContent(): string {
		return this.content;
	}

	public setContent(c: string) {
		this.content = c;
	}

	public toString(): string {
		return `${this.content} (${this.line}, ${this.column})`;
	}
}
