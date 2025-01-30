package com.springsecurity.securedoc.validation;

import com.springsecurity.securedoc.entity.UserEntity;
import com.springsecurity.securedoc.exception.ApiException;

//
 /// 4/3/24
//

public class UserValidation {

    public static void verifyAccountStatus(UserEntity user) {
        if(!user.isEnabled()) { throw new ApiException("Account is disabled"); }
        if(!user.isAccountNonExpired()) { throw new ApiException("Account is expired"); }
        if(!user.isAccountNonLocked()) { throw new ApiException("Account is locked"); }
    }
}