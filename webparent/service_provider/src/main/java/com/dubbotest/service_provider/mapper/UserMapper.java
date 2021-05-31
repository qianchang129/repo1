package com.dubbotest.service_provider.mapper;


import com.dubbotest.interfacetest.dto.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Mapper
public interface UserMapper {
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "password",column = "password"),
            @Result(property = "email",column = "email"),
            @Result(property = "mobile",column = "mobile")
    })
    @Select("SELECT * FROM tuser")
    List<User> allUsers();
}
