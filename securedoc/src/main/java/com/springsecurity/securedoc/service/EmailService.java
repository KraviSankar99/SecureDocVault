package com.springsecurity.securedoc.service;

//
 /// 1/25/24
//

public interface EmailService {
    void sendNewAccountEmail(String name, String email, String token);
    void sendPasswordResetEmail(String name, String email, String token);
}