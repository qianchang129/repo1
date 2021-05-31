package com.dubbotest.interfacetest.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String mobile;
}
