import type { AstNode, DiagnosticInfo } from "langium";
import type { Type } from "./semantics.ts";

class Stack<T> {
	list: Array<T>;
	constructor() {
		this.list = [];
	}
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
	scopes: Stack<Map<string, [Type, DiagnosticInfo<AstNode>]>>;
	constructor() {
		this.scopes = new Stack<Map<string, [Type, DiagnosticInfo<AstNode>]>>();
	}
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
	put(symbol: string, type: Type, info: DiagnosticInfo<AstNode>) {
		this.scopes.at(-1)?.set(symbol, [type, info]);
	}

	inScope(symbol: string): boolean {
		console.error(this.scopes.list);
		for (const scope of this.scopes.list) {
			for (const s of scope.keys()) {
				if (s === symbol) {
					return true;
				}
			}
		}
		return false;
	}

	type(symbol: string): Type | undefined {
		for (const scope of this.scopes.list) {
			for (const [s, [type, _]] of scope.entries()) {
				if (s === symbol) {
					return type;
				}
			}
		}
		return undefined;
	}

	toString(): string {
		let retString = "";
		for (var scope of this.scopes.list) {
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
