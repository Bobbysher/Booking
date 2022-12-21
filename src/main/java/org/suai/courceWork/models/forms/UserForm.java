package org.suai.courceWork.models.forms;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

    @Size(min=5, message = "Too short.  Minimum of 5 characters")
    @NotBlank(message = "Enter your username!")
    private String name;

    @Size(min=5, message = "Too short.  Minimum of 5 characters")
    @NotBlank(message = "Enter the password!")
    private String password;

    @NotBlank(message = "Confirm your password!")
    private String passwordConfirm;

    private String newPassword;

    @Email(message = "Invalid email address!")
    @NotBlank(message = "Enter your email!")
    private String email;

}
