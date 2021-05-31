package com.dubbotest.service_provider.dao;

import com.dubbotest.service_provider.entity.TuserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<TuserEntity,Integer> {

}
