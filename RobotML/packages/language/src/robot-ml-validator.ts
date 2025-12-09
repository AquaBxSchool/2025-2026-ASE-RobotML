import type { ValidationChecks } from 'langium';
import type { RobotMlAstType } from './generated/ast.js';
import type { RobotMlServices } from './robot-ml-module.js';

/**
 * Register custom validation checks.
 */
export function registerValidationChecks(services: RobotMlServices) {
    const registry = services.validation.ValidationRegistry;
    const validator = services.validation.RobotMlValidator;
    const checks: ValidationChecks<RobotMlAstType> = {
        // TODO: Declare validators for your properties
        // See doc : https://langium.org/docs/learn/workflow/create_validations/
        /*
        Element: validator.checkElement
        */
    };
    registry.register(checks, validator);
}

/**
 * Implementation of custom validations.
 */
export class RobotMlValidator {

    // TODO: Add logic here for validation checks of properties
    // See doc : https://langium.org/docs/learn/workflow/create_validations/
    /*
    checkElement(element: Element, accept: ValidationAcceptor): void {
        // Always accepts
    }
    */
}
