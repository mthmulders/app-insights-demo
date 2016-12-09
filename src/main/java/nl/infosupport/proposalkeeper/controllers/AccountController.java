package nl.infosupport.proposalkeeper.controllers;

import com.google.common.collect.ImmutableMap;
import nl.infosupport.proposalkeeper.forms.LoginData;
import nl.infosupport.proposalkeeper.forms.RegistrationData;
import nl.infosupport.proposalkeeper.validators.RegistrationDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Provides access to account related pages
 */
@Controller
public class AccountController {
    private RegistrationDataValidator registrationDataValidator;

    /**
     * Initializes a new instance of {@link AccountController}
     *
     * @param registrationDataValidator Registration data validator to use
     */
    @Autowired
    public AccountController(RegistrationDataValidator registrationDataValidator) {
        this.registrationDataValidator = registrationDataValidator;
    }

    /**
     * Renders the login page for the user
     *
     * @return Returns the view for the login page
     */
    @RequestMapping(path = "/account/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("/account/login", ImmutableMap.of("loginData", new LoginData()));
    }

    /**
     * Completes the login operation
     *
     * @param loginData     Data used to authenticate the user
     * @param bindingResult The binding result for the login data
     * @return Returns the model and view for the login operation
     */
    @RequestMapping(path = "/account/login", method = RequestMethod.POST)
    public ModelAndView completeLogin(@Valid @ModelAttribute("loginData") final LoginData loginData, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/account/login", ImmutableMap.of("loginData", loginData));
        }

        //TODO: Perform actual login

        return new ModelAndView("redirect:/");
    }

    /**
     * Renders the registration page
     *
     * @return Returns the model and view for the registration page
     */
    @RequestMapping(path = "/account/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("/account/register",
            ImmutableMap.of("registrationData", new RegistrationData()));
    }

    /**
     * Completes the registration process
     *
     * @param registrationData Registration data entered by the user
     * @param bindingResult    Binding result for the registration data
     * @return Returns the model and view to render after the action is completed
     */
    @RequestMapping(path = "/account/register", method = RequestMethod.POST)
    public ModelAndView completeRegistration(@Valid @ModelAttribute("registrationData") final RegistrationData registrationData, BindingResult bindingResult) {
        registrationDataValidator.validate(registrationData, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/account/register",
                ImmutableMap.of("registrationData", registrationData));
        }

        //TODO: Perform the actual registration

        return new ModelAndView("redirect:/account/login");
    }
}
