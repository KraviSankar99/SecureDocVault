package com.springsecurity.securedoc.service;

import com.springsecurity.securedoc.entity.CredentialEntity;
import com.springsecurity.securedoc.entity.RoleEntity;
import com.springsecurity.securedoc.entity.UserEntity;
import com.springsecurity.securedoc.enumeration.Authority;
import com.springsecurity.securedoc.repository.CredentialRepository;
import com.springsecurity.securedoc.repository.UserRepository;
import com.springsecurity.securedoc.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Junior RT
 * @version 1.0
 * @license Get Arrays, LLC (<a href="https://www.getarrays.io">Get Arrays, LLC</a>)
 * @email getarrayz@gmail.com
 * @since 3/11/24
 */

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private CredentialRepository credentialRepository;
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("Test find user by ID")
    public void getUserByUserIdTest() {
        // Arrange - Given
        var userEntity = new UserEntity();
        userEntity.setFirstName("Junior");
        userEntity.setId(1L);
        userEntity.setUserId("1");
        userEntity.setCreatedAt(LocalDateTime.of(1990, 11, 1, 1, 11, 11));
        userEntity.setUpdatedAt(LocalDateTime.of(1990, 11, 1, 1, 11, 11));
        userEntity.setLastLogin(LocalDateTime.of(1990, 11, 1, 1, 11, 11));

        var roleEntity = new RoleEntity("USER", Authority.USER);
        userEntity.setRole(roleEntity);

        var credentialEntity = new CredentialEntity();
        credentialEntity.setUpdatedAt(LocalDateTime.of(1990, 11, 1, 1, 11, 11));
        credentialEntity.setPassword("password");
        credentialEntity.setUserEntity(userEntity);

        when(userRepository.findUserByUserId("1")).thenReturn(Optional.of(userEntity));
        when(credentialRepository.getCredentialByUserEntityId(1L)).thenReturn(Optional.of(credentialEntity));

        // Act - When
        var userByUserId = userServiceImpl.getUserByUserId("1");

        // Assert - Then
        assertThat(userByUserId.getFirstName()).isEqualTo(userEntity.getFirstName());
        assertThat(userByUserId.getUserId()).isEqualTo("1");
    }
}