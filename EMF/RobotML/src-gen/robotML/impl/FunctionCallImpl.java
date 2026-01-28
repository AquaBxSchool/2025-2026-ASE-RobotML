/**
 */
package robotML.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import robotML.Expression;
import robotML.FunctionCall;
import robotML.FunctionDeclaration;
import robotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link robotML.impl.FunctionCallImpl#getFunctiondeclaration <em>Functiondeclaration</em>}</li>
 *   <li>{@link robotML.impl.FunctionCallImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionCallImpl extends StatementImpl implements FunctionCall {
	/**
	 * The cached value of the '{@link #getFunctiondeclaration() <em>Functiondeclaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctiondeclaration()
	 * @generated
	 * @ordered
	 */
	protected FunctionDeclaration functiondeclaration;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.FUNCTION_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionDeclaration getFunctiondeclaration() {
		if (functiondeclaration != null && functiondeclaration.eIsProxy()) {
			InternalEObject oldFunctiondeclaration = (InternalEObject) functiondeclaration;
			functiondeclaration = (FunctionDeclaration) eResolveProxy(oldFunctiondeclaration);
			if (functiondeclaration != oldFunctiondeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RobotMLPackage.FUNCTION_CALL__FUNCTIONDECLARATION, oldFunctiondeclaration,
							functiondeclaration));
			}
		}
		return functiondeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration basicGetFunctiondeclaration() {
		return functiondeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunctiondeclaration(FunctionDeclaration newFunctiondeclaration) {
		FunctionDeclaration oldFunctiondeclaration = functiondeclaration;
		functiondeclaration = newFunctiondeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.FUNCTION_CALL__FUNCTIONDECLARATION,
					oldFunctiondeclaration, functiondeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getExpression() {
		if (expression == null) {
			expression = new EObjectResolvingEList<Expression>(Expression.class, this,
					RobotMLPackage.FUNCTION_CALL__EXPRESSION);
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RobotMLPackage.FUNCTION_CALL__FUNCTIONDECLARATION:
			if (resolve)
				return getFunctiondeclaration();
			return basicGetFunctiondeclaration();
		case RobotMLPackage.FUNCTION_CALL__EXPRESSION:
			return getExpression();
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
		case RobotMLPackage.FUNCTION_CALL__FUNCTIONDECLARATION:
			setFunctiondeclaration((FunctionDeclaration) newValue);
			return;
		case RobotMLPackage.FUNCTION_CALL__EXPRESSION:
			getExpression().clear();
			getExpression().addAll((Collection<? extends Expression>) newValue);
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
		case RobotMLPackage.FUNCTION_CALL__FUNCTIONDECLARATION:
			setFunctiondeclaration((FunctionDeclaration) null);
			return;
		case RobotMLPackage.FUNCTION_CALL__EXPRESSION:
			getExpression().clear();
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
		case RobotMLPackage.FUNCTION_CALL__FUNCTIONDECLARATION:
			return functiondeclaration != null;
		case RobotMLPackage.FUNCTION_CALL__EXPRESSION:
			return expression != null && !expression.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionCallImpl
