package com.example.runnertest.controller;

import com.example.runnertest.entity.User;
import com.example.runnertest.service.UserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody public void saveUser(User user){
        userService.save(user);
    }
    @RequestMapping("/find")
    public String findUser(User user){
        System.out.println("findC");
        try{
            userService.login(user);
            return "role";
        }catch (UnknownAccountException e){
            System.out.println("账号未注册....");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误哦...");
        }catch (Exception e){
            System.out.println(e);
        }
        return "index";
    }
    @RequestMapping("/testm")
    public String  test(){
        return "test";
    }
}
