package com.dubbotest.service_provider.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tuser", schema = "test", catalog = "")
public class TuserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String mobile;

    }
