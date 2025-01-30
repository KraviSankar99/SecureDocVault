package com.springsecurity.securedoc.enumeration;

import static com.springsecurity.securedoc.constant.Constants.*;

//
 /// 1/25/24
//

public enum Authority {
    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES);

    private final String value;

    Authority(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}