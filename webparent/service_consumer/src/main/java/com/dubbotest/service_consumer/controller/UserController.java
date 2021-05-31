package com.dubbotest.service_consumer.controller;

import com.dubbotest.interfacetest.dto.User;
import com.dubbotest.interfacetest.dto.UserDto;

import com.dubbotest.interfacetest.service.UserServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="用户管理模块接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Reference(version = "1.0.0")
    UserServiceI userService;

    @ApiOperation(value = "单个用户", notes="根据ID获取用户信息")
    @GetMapping("/{id}")
    public UserDto getUser(@ApiParam("用户ID") @PathVariable int id){
        return userService.getUser(id);
    }
    @PostMapping("")
    @ApiOperation("新增用户")
    public UserDto addUser(@ApiParam("新增用户的信息") @RequestBody UserDto user){
        return userService.addUser(user);
    }
    @GetMapping("list")
    @ApiOperation(value = "所有用户", notes="获取所有用户信息")
    public List<UserDto> allUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("all")
    @ApiOperation(value = "所有用户", notes="获取所有用户信息")
    public List<User> allUsersMy(){
        return userService.allUsers();
    }
}
