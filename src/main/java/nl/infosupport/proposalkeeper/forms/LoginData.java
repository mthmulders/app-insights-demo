package nl.infosupport.proposalkeeper.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains data needed to sign a user into the application
 */
@NoArgsConstructor
@AllArgsConstructor
public @Data class LoginData {
    @NotEmpty(message = "Please enter your e-mail address")
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotEmpty(message = "Please enter your password")
    private String password;
}
