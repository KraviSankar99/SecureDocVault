package com.springsecurity.securedoc.dtorequset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

//
 /// 4/3/24
//

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailRequest {
    @NotEmpty(message = "Email cannot be empty or null")
    @Email(message = "Invalid email address")
    private String email;
}