// import { DefaultScopeProvider, ReferenceInfo, Scope, MapScope, AstNodeDescription } from 'langium';
// import { isAssignationDec, isBlock, isVariableRef } from './generated/ast.js';

// export class MyLanguageScopeProvider extends DefaultScopeProvider {

//     override getScope(context: ReferenceInfo): Scope {
//         if (isVariableRef(context.container)) {
//             const scope = this.getLocalScope(context);
//             if (scope) {
//                 return scope;
//             }
//         }
//         return super.getScope(context);
//     }

//     private getLocalScope(context: ReferenceInfo): Scope | undefined {
//         let currentNode = context.container;
//         let childNode = currentNode;
//         let container = currentNode.$container;

//         while (container) {
//             if (isBlock(container)) {
//                 const precomputed: AstNodeDescription[] = [];

//                 for (const statement of container.statements) {
//                     if (statement === childNode) {
//                         break;
//                     }

//                     if (isAssignationDec(statement) && statement.variableDecl) {
//                          const desc = this.descriptions.createDescription(
//                              statement.variableDecl,
//                              statement.variableDecl.name
//                          );
//                          precomputed.push(desc);
//                     }
//                 }

//                 return new MapScope(precomputed, super.getScope(context));
//             }

//             childNode = container;
//             container = container.$container;
//         }

//         return undefined;
//     }
// }
