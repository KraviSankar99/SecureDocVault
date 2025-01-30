package com.springsecurity.securedoc.dtorequset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

//
 /// 4/12/24
//

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateDocRequest {
    @NotEmpty(message = "Document ID cannot be empty or null")
    private String documentId;
    @NotEmpty(message = "Name cannot be empty or null")
    private String name;
    @NotEmpty(message = "Description cannot be empty or null")
    private String description;
}