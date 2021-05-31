package com.dubbotest.service_provider.service.impl;



import com.dubbotest.interfacetest.dto.User;
import com.dubbotest.interfacetest.dto.UserDto;
import com.dubbotest.service_provider.dao.UserDao;
import com.dubbotest.service_provider.entity.TuserEntity;
import com.dubbotest.service_provider.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;
import javax.transaction.Transactional;
import com.dubbotest.interfacetest.service.UserServiceI;
import java.util.ArrayList;
import java.util.List;


import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",interfaceClass = UserServiceI.class)
@org.springframework.stereotype.Service
@Transactional
public class UserServiceImpl implements UserServiceI {
    @Autowired
    UserDao userDao;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> allUsers(){
        return userMapper.allUsers();
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<TuserEntity> tusers=userDao.findAll();
        return e2d(tusers);
    }
    @Override
    public UserDto getUser(Integer id) {
        return e2d(userDao.getOne(id));
    }
    @Override
    public UserDto addUser(UserDto user) {
        TuserEntity tuser=d2e(user);
        userDao.saveAndFlush(tuser);
        return e2d(tuser);
    }
    private List<UserDto> e2d(List<TuserEntity> tusers) {
        List<UserDto> users=new ArrayList<>();
        if(tusers!=null&& tusers.size()>0){
            for(TuserEntity tuser : tusers){
                users.add(e2d(tuser));
            }
        }
        return users;
    }
    private UserDto e2d(TuserEntity tuser) {
        if(tuser==null)
            return null;
        UserDto user=new UserDto();
        BeanUtils.copyProperties(tuser,user);
        return user;
    }
    private TuserEntity d2e(UserDto user) {
        if(user==null)
            return null;
        TuserEntity tuser=new TuserEntity();
        BeanUtils.copyProperties(user,tuser);
        return tuser;
    }
}
