/**
 */
package robotML.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import robotML.Block;
import robotML.FunctionDeclaration;
import robotML.Parameter;
import robotML.RobotMLPackage;
import robotML.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link robotML.impl.FunctionDeclarationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link robotML.impl.FunctionDeclarationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link robotML.impl.FunctionDeclarationImpl#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionDeclarationImpl extends StatementImpl implements FunctionDeclaration {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected Type returnType;

	/**
	 * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlock()
	 * @generated
	 * @ordered
	 */
	protected Block block;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.FUNCTION_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this,
					RobotMLPackage.FUNCTION_DECLARATION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(Type newReturnType, NotificationChain msgs) {
		Type oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReturnType(Type newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject) returnType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject) newReturnType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE,
					newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block getBlock() {
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
		Block oldBlock = block;
		block = newBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RobotMLPackage.FUNCTION_DECLARATION__BLOCK, oldBlock, newBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlock(Block newBlock) {
		if (newBlock != block) {
			NotificationChain msgs = null;
			if (block != null)
				msgs = ((InternalEObject) block).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RobotMLPackage.FUNCTION_DECLARATION__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject) newBlock).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RobotMLPackage.FUNCTION_DECLARATION__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.FUNCTION_DECLARATION__BLOCK, newBlock,
					newBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RobotMLPackage.FUNCTION_DECLARATION__PARAMETERS:
			return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
		case RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE:
			return basicSetReturnType(null, msgs);
		case RobotMLPackage.FUNCTION_DECLARATION__BLOCK:
			return basicSetBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RobotMLPackage.FUNCTION_DECLARATION__PARAMETERS:
			return getParameters();
		case RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE:
			return getReturnType();
		case RobotMLPackage.FUNCTION_DECLARATION__BLOCK:
			return getBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RobotMLPackage.FUNCTION_DECLARATION__PARAMETERS:
			getParameters().clear();
			getParameters().addAll((Collection<? extends Parameter>) newValue);
			return;
		case RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE:
			setReturnType((Type) newValue);
			return;
		case RobotMLPackage.FUNCTION_DECLARATION__BLOCK:
			setBlock((Block) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RobotMLPackage.FUNCTION_DECLARATION__PARAMETERS:
			getParameters().clear();
			return;
		case RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE:
			setReturnType((Type) null);
			return;
		case RobotMLPackage.FUNCTION_DECLARATION__BLOCK:
			setBlock((Block) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RobotMLPackage.FUNCTION_DECLARATION__PARAMETERS:
			return parameters != null && !parameters.isEmpty();
		case RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE:
			return returnType != null;
		case RobotMLPackage.FUNCTION_DECLARATION__BLOCK:
			return block != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionDeclarationImpl
