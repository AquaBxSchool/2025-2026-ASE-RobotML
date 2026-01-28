/**
 */
package robotML;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreach</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.Foreach#getVariable <em>Variable</em>}</li>
 *   <li>{@link robotML.Foreach#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getForeach()
 * @model
 * @generated
 */
public interface Foreach extends Loop {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Variable)
	 * @see robotML.RobotMLPackage#getForeach_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link robotML.Foreach#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see robotML.RobotMLPackage#getForeach_Expression()
	 * @model required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link robotML.Foreach#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // Foreach
