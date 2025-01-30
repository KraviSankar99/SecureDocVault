package com.springsecurity.securedoc.enumeration;

//
 /// 2/28/24
//
public enum TokenType {
    ACCESS("access-token"), REFRESH("refresh-token");

    private final String value;

    TokenType(String value) { this.value = value; }

    public String getValue() { return this.value; }
}