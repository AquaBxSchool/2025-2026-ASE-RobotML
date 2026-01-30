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
		return this.list.pop()!;
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
		// Iterate backwards from the top of the stack to the bottom
		for (let i = this.scopes.list.length - 1; i >= 0; i--) {
			const scope = this.scopes.list[i];
			if (scope.has(symbol)) {
				return scope.get(symbol)?.[0];
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
