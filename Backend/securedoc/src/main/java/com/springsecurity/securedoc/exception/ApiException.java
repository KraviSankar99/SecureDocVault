package com.springsecurity.securedoc.exception;

//
 /// 1/25/24
//

public class ApiException extends RuntimeException {
    public ApiException(String message) { super(message); }
    public ApiException() { super("An error occurred"); }
}