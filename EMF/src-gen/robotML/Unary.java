/**
 */
package robotML;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.Unary#getOperands <em>Operands</em>}</li>
 *   <li>{@link robotML.Unary#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getUnary()
 * @model
 * @generated
 */
public interface Unary extends Operation {
	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference.
	 * @see #setOperands(Expression)
	 * @see robotML.RobotMLPackage#getUnary_Operands()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOperands();

	/**
	 * Sets the value of the '{@link robotML.Unary#getOperands <em>Operands</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operands</em>' containment reference.
	 * @see #getOperands()
	 * @generated
	 */
	void setOperands(Expression value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link robotML.Operators}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see robotML.Operators
	 * @see #setOperator(Operators)
	 * @see robotML.RobotMLPackage#getUnary_Operator()
	 * @model unique="false"
	 * @generated
	 */
	Operators getOperator();

	/**
	 * Sets the value of the '{@link robotML.Unary#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see robotML.Operators
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operators value);

} // Unary
