package com.springsecurity.securedoc.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//
 /// 2/28/24
//

@Builder
@Getter
@Setter
public class Token {
    private String access;
    private String refresh;
}