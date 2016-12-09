package nl.infosupport.proposalkeeper.controllers;

import nl.infosupport.proposalkeeper.forms.LoginData;
import nl.infosupport.proposalkeeper.forms.RegistrationData;
import nl.infosupport.proposalkeeper.validators.RegistrationDataValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.*;

public class AccountControllerTests {
    private AccountController accountController;

    @Before
    public void setUp() {
        accountController = new AccountController(new RegistrationDataValidator());
    }

    @Test
    public void registerWithValidDataRedirectToLoginPage() {
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        RegistrationData registrationData = new RegistrationData(
            "test@domain.org", "test", "test");

        ModelAndView result = accountController.completeRegistration(registrationData, bindingResult);

        assertThat(result.getViewName(), equalTo("redirect:/account/login"));
    }

    @Test
    public void registerWithInvalidDataRendersRegistrationPage() {
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);

        RegistrationData registrationData = new RegistrationData(
            "", "", "1234");

        ModelAndView result = accountController.completeRegistration(registrationData, bindingResult);

        assertThat(result.getViewName(), equalTo("/account/register"));
    }
}
