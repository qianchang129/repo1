package com.dubbotest.interfacetest.service;

import com.dubbotest.interfacetest.dto.User;
import com.dubbotest.interfacetest.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserServiceI {
    public List<UserDto> getAllUsers();
    public UserDto getUser(Integer id);
    public UserDto addUser(UserDto user);

    public List<User> allUsers();
}
