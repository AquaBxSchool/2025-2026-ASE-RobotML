/**
 */
package robotML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.Block#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends Statement {
	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference list.
	 * The list contents are of type {@link robotML.Statement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference list.
	 * @see robotML.RobotMLPackage#getBlock_Statement()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getStatement();

} // Block
