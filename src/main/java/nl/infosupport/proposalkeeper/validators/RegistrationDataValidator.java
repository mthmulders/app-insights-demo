package nl.infosupport.proposalkeeper.validators;

import nl.infosupport.proposalkeeper.forms.RegistrationData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validates registration data
 */
@Component
public class RegistrationDataValidator implements Validator {
    /**
     * Checks if the input data can be validated using this validate
     *
     * @param aClass Type of data to validate
     * @return Returns true when the input data is of type {@link RegistrationData}
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationData.class.isAssignableFrom(aClass);
    }

    /**
     * Validates the registration data
     *
     * @param o      Object to validate
     * @param errors Errors to register
     */
    @Override
    public void validate(Object o, Errors errors) {
        RegistrationData registrationData = (RegistrationData) o;

        if (!registrationData.getPassword().equals(registrationData.getPasswordConfirmation())) {
            errors.rejectValue("passwordConfirmation", "Passwords do not match");
        }
    }
}
