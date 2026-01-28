/**
 */
package robotML;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.Assignation#getVariable <em>Variable</em>}</li>
 *   <li>{@link robotML.Assignation#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getAssignation()
 * @model
 * @generated
 */
public interface Assignation extends Statement {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Variable)
	 * @see robotML.RobotMLPackage#getAssignation_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link robotML.Assignation#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see robotML.RobotMLPackage#getAssignation_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link robotML.Assignation#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // Assignation
