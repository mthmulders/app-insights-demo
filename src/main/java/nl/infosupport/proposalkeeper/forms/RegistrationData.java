package nl.infosupport.proposalkeeper.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains data for the registration process
 */
@NoArgsConstructor
@AllArgsConstructor
public @Data class RegistrationData {
    @NotEmpty(message = "Please enter your e-mail address")
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotEmpty(message = "Please specify a password")
    private String password;

    @NotEmpty(message = "Please confirm your password choice")
    private String passwordConfirmation;
}
