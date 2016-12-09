package nl.infosupport.proposalkeeper.validators;

import nl.infosupport.proposalkeeper.forms.RegistrationData;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.Errors;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class RegistrationDataValidatorTests {
    private RegistrationDataValidator validator;

    @Before
    public void setUp() {
        validator = new RegistrationDataValidator();
    }

    @Test
    public void supportsWithValidObjectTypeReturnsTrue() {
        assertThat(validator.supports(RegistrationData.class), equalTo(true));
    }

    @Test
    public void supportsWithInvalidObjectTypeReturnsFalse() {
        assertThat(validator.supports(Object.class), equalTo(false));
    }

    @Test
    public void validateRejectsUnconfirmedPassword() {
        Errors errors = mock(Errors.class);

        RegistrationData inputData = new RegistrationData(
            "test@domain.org", "test", "test123");

        validator.validate(inputData, errors);

        verify(errors).rejectValue(eq("passwordConfirmation"), any());
    }

    @Test
    public void validateAcceptsValidPasswordConfirmation() {
        Errors errors = mock(Errors.class);

        RegistrationData inputData = new RegistrationData(
            "test@domain.org", "test", "test");

        validator.validate(inputData, errors);

        verify(errors, times(0)).rejectValue(any(), any());
    }
}
