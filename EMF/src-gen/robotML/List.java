/**
 */
package robotML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.List#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getList()
 * @model
 * @generated
 */
public interface List extends Type {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link robotML.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see robotML.RobotMLPackage#getList_Expression()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpression();

} // List
