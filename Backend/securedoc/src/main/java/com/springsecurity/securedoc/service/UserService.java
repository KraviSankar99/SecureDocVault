package com.springsecurity.securedoc.service;

import com.springsecurity.securedoc.dto.User;
import com.springsecurity.securedoc.entity.CredentialEntity;
import com.springsecurity.securedoc.entity.RoleEntity;
import com.springsecurity.securedoc.enumeration.LoginType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//
 /// 1/29/24
//

public interface UserService {
    void createUser(String firstName, String lastName, String email, String password);
    RoleEntity getRoleName(String name);
    void verifyAccountKey(String key);
    void updateLoginAttempt(String email, LoginType loginType);
    User getUserByUserId(String userId);
    User getUserByEmail(String email);
    CredentialEntity getUserCredentialById(Long id);
    User setUpMfa(Long id);
    User cancelMfa(Long id);
    User verifyQrCode(String userId, String qrCode);
    void resetPassword(String email);
    User verifyPasswordKey(String key);
    void updatePassword(String userId, String newPassword, String confirmNewPassword);
    void updatePassword(String userId, String currentPassword, String newPassword, String confirmNewPassword);
    User updateUser(String userId, String firstName, String lastName, String email, String phone, String bio);
    void updateRole(String userId, String role);
    void toggleAccountExpired(String userId);
    void toggleAccountLocked(String userId);
    void toggleAccountEnabled(String userId);
    void toggleCredentialsExpired(String userId);
    List<User> getUsers();
    String uploadPhoto(String userId, MultipartFile file);
    User getUserById(Long id);
}