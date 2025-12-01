/**
 */
package robotML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.Binary#getOperands <em>Operands</em>}</li>
 *   <li>{@link robotML.Binary#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getBinary()
 * @model
 * @generated
 */
public interface Binary extends Operation {
	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link robotML.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see robotML.RobotMLPackage#getBinary_Operands()
	 * @model containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<Expression> getOperands();

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link robotML.Operators}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see robotML.Operators
	 * @see #setOperator(Operators)
	 * @see robotML.RobotMLPackage#getBinary_Operator()
	 * @model unique="false"
	 * @generated
	 */
	Operators getOperator();

	/**
	 * Sets the value of the '{@link robotML.Binary#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see robotML.Operators
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operators value);

} // Binary
