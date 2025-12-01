/**
 */
package robotML.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import robotML.FunctionDeclaration;
import robotML.RobotMLFactory;
import robotML.RobotMLPackage;

/**
 * This is the item provider adapter for a {@link robotML.FunctionDeclaration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionDeclarationItemProvider extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclarationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(RobotMLPackage.Literals.FUNCTION_DECLARATION__PARAMETERS);
			childrenFeatures.add(RobotMLPackage.Literals.FUNCTION_DECLARATION__RETURN_TYPE);
			childrenFeatures.add(RobotMLPackage.Literals.FUNCTION_DECLARATION__BLOCK);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns FunctionDeclaration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FunctionDeclaration"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_FunctionDeclaration_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(FunctionDeclaration.class)) {
		case RobotMLPackage.FUNCTION_DECLARATION__PARAMETERS:
		case RobotMLPackage.FUNCTION_DECLARATION__RETURN_TYPE:
		case RobotMLPackage.FUNCTION_DECLARATION__BLOCK:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__PARAMETERS,
				RobotMLFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__RETURN_TYPE,
				RobotMLFactory.eINSTANCE.createString()));

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__RETURN_TYPE,
				RobotMLFactory.eINSTANCE.createBoolean()));

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__RETURN_TYPE,
				RobotMLFactory.eINSTANCE.createInteger()));

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__RETURN_TYPE,
				RobotMLFactory.eINSTANCE.createFloat()));

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__RETURN_TYPE,
				RobotMLFactory.eINSTANCE.createVoid()));

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__RETURN_TYPE,
				RobotMLFactory.eINSTANCE.createList()));

		newChildDescriptors.add(createChildParameter(RobotMLPackage.Literals.FUNCTION_DECLARATION__BLOCK,
				RobotMLFactory.eINSTANCE.createBlock()));
	}

}
