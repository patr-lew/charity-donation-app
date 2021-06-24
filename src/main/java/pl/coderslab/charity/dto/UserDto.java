package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.validation.PasswordMatches;
import pl.coderslab.charity.validation.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordMatches
public class UserDto {

    @ValidEmail(message = "{validation.user.email.wrong-email}")
    @NotNull(message = "{validation.user.email.not-null}")
    private String email;

    @NotNull(message = "{validation.user.first-name}")
    @NotEmpty(message = "{validation.user.first-name}")
    private String firstName;

    @NotNull(message = "{validation.user.last-name}")
    @NotEmpty(message = "{validation.user.last-name}")
    private String lastName;

    @NotNull(message = "{validation.user.password}")
    @NotEmpty(message = "{validation.user.password}")
    private String password;
    private String matchingPassword;
}
