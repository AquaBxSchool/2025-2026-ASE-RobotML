/**
 */
package robotML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.Operation#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getOperation()
 * @model abstract="true"
 * @generated
 */
public interface Operation extends Expression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link robotML.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see robotML.RobotMLPackage#getOperation_Expression()
	 * @model containment="true" required="true" upper="2"
	 * @generated
	 */
	EList<Expression> getExpression();

} // Operation
