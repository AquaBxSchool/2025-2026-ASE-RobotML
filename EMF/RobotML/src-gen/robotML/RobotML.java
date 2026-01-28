/**
 */
package robotML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robot ML</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link robotML.RobotML#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see robotML.RobotMLPackage#getRobotML()
 * @model
 * @generated
 */
public interface RobotML extends EObject {
	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference list.
	 * The list contents are of type {@link robotML.Statement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference list.
	 * @see robotML.RobotMLPackage#getRobotML_Statement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Statement> getStatement();

} // RobotML
