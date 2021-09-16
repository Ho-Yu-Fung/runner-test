package com.example.runnertest.service;

import com.example.runnertest.entity.User;
import com.example.runnertest.mapper.UserMapper;
import com.example.runnertest.utils.Md5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void save(User user){
        String salt = Md5Utils.getRamdomSalt();
        user.setPwd(Md5Utils.getMd5SaltHex(user.getPwd(),salt));
        user.setSalt(salt);
        userMapper.save(user);
    }

    public void login(User user) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPwd());
        try{
            subject.login(token);
        }catch(Exception e){
            throw e;
        }
    }

    public User findUserByName(String name){
       return userMapper.findUserByName(name);
    }

}
