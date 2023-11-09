package com.souid.base.service;

import com.souid.base.dto.UserDTO;
import com.souid.base.exception.UserNotFoundException;
import com.souid.base.mapper.UserMapper;
import com.souid.base.model.User;
import com.souid.base.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1L);
        user.setName("testuser");
        user.setEmail("testuser@example.com");

        userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("testuser");
        userDTO.setEmail("testuser@example.com");
    }

    @Test
    public void getUserByIdTest() throws UserNotFoundException {
        // Given
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userMapper.entityToDto(user)).thenReturn(userDTO);

        // When
        UserDTO actualOutput = userService.getUserById(1L);

        // Then
        assertEquals(userDTO, actualOutput);
    }
}
