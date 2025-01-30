package com.springsecurity.securedoc.dtorequset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

//
 /// 4/3/24
//

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResetPasswordRequest {
    @NotEmpty(message = "User ID cannot be empty or null")
    private String userId;
    @NotEmpty(message = "Password cannot be empty or null")
    private String newPassword;
    @NotEmpty(message = "Confirm password cannot be empty or null")
    private String confirmNewPassword;
}