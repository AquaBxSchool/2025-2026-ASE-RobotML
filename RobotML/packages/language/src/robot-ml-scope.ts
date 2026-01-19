import { DefaultScopeProvider, ReferenceInfo, Scope, MapScope, AstNodeDescription } from 'langium';
import { isAssignationDec, isBlock, isVariableRef } from './generated/ast.js';

export class MyLanguageScopeProvider extends DefaultScopeProvider {

    override getScope(context: ReferenceInfo): Scope {
        // 1. Target: We only want custom scoping for VariableRef
        // (The node that has the `ref` property, e.g., 'a' in 'let x = a')
        if (isVariableRef(context.container)) {
            const scope = this.getLocalScope(context);
            if (scope) {
                return scope;
            }
        }
        return super.getScope(context);
    }

    /**
     * Custom logic to handle "definition-before-use" within blocks
     */
    private getLocalScope(context: ReferenceInfo): Scope | undefined {
        let currentNode = context.container;
        
        // 2. Hierarchy Traversal: Walk up until we find the enclosing Block
        // We track 'childNode' to know our position within that block
        let childNode = currentNode;
        let container = currentNode.$container;

        while (container) {
            if (isBlock(container)) {
                const precomputed: AstNodeDescription[] = [];
                
                // Iterate over statements in the block
                for (const statement of container.statements) {
                    // STOP if we hit the statement that contains our reference
                    // (This enforces "definition before use")
                    if (statement === childNode) {
                        break;
                    }
                    
                    // 3. Declaration Access: Unwrap the VariableDeclaration
                    // The statement is an 'Assignation', we need the 'variableDecl' inside it
                    if (isAssignationDec(statement) && statement.variableDecl) {
                         const desc = this.descriptions.createDescription(
                             statement.variableDecl, 
                             statement.variableDecl.name
                         );
                         precomputed.push(desc);
                    }
                }
                
                // Return this block's scope chained to the outer scope (handled by super)
                return new MapScope(precomputed, super.getScope(context));
            }

            // Move up one level
            childNode = container;
            container = container.$container;
        }
        
        return undefined;
    }
}