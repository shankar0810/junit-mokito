package com.example.junit_mokito.service;

import com.example.junit_mokito.model.User;
import com.example.junit_mokito.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private userService UserService;

    @Test
    public void testGetAllUsers() {
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("john@example.com");

        User user2 = new User();
        user2.setName("Jane");
        user2.setEmail("jane@example.com");

        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = UserService.getAllUsers();
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = UserService.getUserById(1L);
        assertEquals("John", result.getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");

        when(userRepository.save(user)).thenReturn(user);

        User result = UserService.saveUser(user);
        assertEquals("John", result.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);
        UserService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}
