package com.souid.base.service;

import com.souid.base.dto.UserDTO;
import com.souid.base.exception.UserNotFoundException;

import java.util.List;

public interface UserInterface {
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(Long id) throws UserNotFoundException;
    public UserDTO createUser(UserDTO user);
    public UserDTO updateUser(Long id, UserDTO user);
    public void deleteUser(Long id);
}
