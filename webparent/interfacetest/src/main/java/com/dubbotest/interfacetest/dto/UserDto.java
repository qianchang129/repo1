package com.dubbotest.interfacetest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("系统用户")
public class UserDto {
    @ApiModelProperty("用户ID")
    private Integer id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("用户手机")
    private String mobile;
}
