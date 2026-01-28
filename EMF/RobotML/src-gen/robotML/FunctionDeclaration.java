/**
 */
package robotML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.FunctionDeclaration#getParameters <em>Parameters</em>}</li>
 *   <li>{@link robotML.FunctionDeclaration#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link robotML.FunctionDeclaration#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getFunctionDeclaration()
 * @model
 * @generated
 */
public interface FunctionDeclaration extends Statement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link robotML.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see robotML.RobotMLPackage#getFunctionDeclaration_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(Type)
	 * @see robotML.RobotMLPackage#getFunctionDeclaration_ReturnType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getReturnType();

	/**
	 * Sets the value of the '{@link robotML.FunctionDeclaration#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(Type value);

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(Block)
	 * @see robotML.RobotMLPackage#getFunctionDeclaration_Block()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link robotML.FunctionDeclaration#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

} // FunctionDeclaration
