/**
 */
package robotML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.FunctionCall#getFunctiondeclaration <em>Functiondeclaration</em>}</li>
 *   <li>{@link robotML.FunctionCall#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends Statement, Expression {
	/**
	 * Returns the value of the '<em><b>Functiondeclaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functiondeclaration</em>' reference.
	 * @see #setFunctiondeclaration(FunctionDeclaration)
	 * @see robotML.RobotMLPackage#getFunctionCall_Functiondeclaration()
	 * @model required="true"
	 * @generated
	 */
	FunctionDeclaration getFunctiondeclaration();

	/**
	 * Sets the value of the '{@link robotML.FunctionCall#getFunctiondeclaration <em>Functiondeclaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functiondeclaration</em>' reference.
	 * @see #getFunctiondeclaration()
	 * @generated
	 */
	void setFunctiondeclaration(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference list.
	 * The list contents are of type {@link robotML.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference list.
	 * @see robotML.RobotMLPackage#getFunctionCall_Expression()
	 * @model
	 * @generated
	 */
	EList<Expression> getExpression();

} // FunctionCall
