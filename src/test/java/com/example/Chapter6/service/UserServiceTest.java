package com.example.Chapter6.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Chapter6.model.User;
import com.example.Chapter6.repository.UserRepository;
import com.example.Chapter6.service.UserService;
import com.example.Chapter6.service.implementasi.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void addUser_shouldReturnSavedUser() {
        // Given
        User user = User.builder()
                .username("bar")
                .email("bar@example.com")
                .password("123456")
                .build();

        when(userRepository.save(user)).thenReturn(user);

        // When
        User savedUser = userService.addUser(user);

        // Then
        assertThat(savedUser).isEqualTo(user);
    }

    @Test
    public void updateUser_shouldReturnUpdatedUser() {
        // Given
        User existingUser = User.builder()
                .userId(1L)
                .username("existingUsername")
                .email("existingEmail")
                .password("existingPassword")
                .build();
        User updatedUser = User.builder()
                .userId(1L)
                .username("newUsername")
                .email("newEmail")
                .password("newPassword")
                .build();

        when(userRepository.findById(existingUser.getUserId())).thenReturn(java.util.Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(updatedUser);

        // When
        User result = userService.updateUser(updatedUser);

        // Then
        assertThat(result).isEqualTo(updatedUser);
    }

    @Test
    public void deleteUser_shouldCallRepositoryDelete() {
        // Given
        User user = User.builder()
                .userId(1L)
                .username("username")
                .email("email")
                .password("password")
                .build();

        // When
        userService.deleteUser(user);

        // Then
        verify(userRepository).deleteById(user.getUserId());
    }
}
