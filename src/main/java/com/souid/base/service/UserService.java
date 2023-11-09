package com.souid.base.service;
import com.souid.base.dto.UserDTO;
import com.souid.base.exception.UserNotFoundException;
import com.souid.base.mapper.UserMapper;
import com.souid.base.model.User;
import com.souid.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::entityToDto).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(""));

        return userMapper.entityToDto(user);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return userMapper.entityToDto(userRepository.save(userMapper.dtoToEntity(user)));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {
        //User user = userRepository.getUserById(id);
        return userMapper.entityToDto(userRepository.save(userMapper.dtoToEntity(user)));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
