package com.springsecurity.securedoc.service;

import com.springsecurity.securedoc.domain.Token;
import com.springsecurity.securedoc.domain.TokenData;
import com.springsecurity.securedoc.dto.User;
import com.springsecurity.securedoc.enumeration.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;
import java.util.function.Function;

//
 /// 2/28/24
//

public interface JwtService {
    String createToken(User user, Function<Token, String> tokenFunction);
    Optional<String> extractToken(HttpServletRequest request, String tokenType);
    void addCookie(HttpServletResponse response, User user, TokenType type);
    <T> T getTokenData(String token, Function<TokenData, T> tokenFunction);
    void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName);
}