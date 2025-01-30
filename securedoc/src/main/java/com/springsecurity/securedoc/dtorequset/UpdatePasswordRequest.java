package com.springsecurity.securedoc.dtorequset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

//
 /// 4/4/24
//

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePasswordRequest {
    @NotEmpty(message = "Password cannot be empty or null")
    private String password;
    @NotEmpty(message = "New password cannot be empty or null")
    private String newPassword;
    @NotEmpty(message = "Confirm new password cannot be empty or null")
    private String confirmNewPassword;
}