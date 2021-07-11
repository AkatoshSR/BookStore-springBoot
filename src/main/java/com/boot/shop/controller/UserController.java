package com.boot.shop.controller;

import com.boot.shop.bean.UserBean;
import com.boot.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    /*
        重定向：redirect:/地址.html
            1.浏览器地址栏地址变化
            2.可以访问到static文件夹页面
            3.不可以访问到templates
        转发 /地址
            1.浏览器地址栏不变
            2.可以访问templates文件夹页面
            3.布恩那个访问static

     */

    // Controller层调用mapper
    @Autowired
    private UserMapper userMapper;

    //
    @RequestMapping("/login")
    public String login(String username,String password){
        UserBean user = userMapper.getUser(username, password);
        if (user != null){
            System.out.println("登录成功");
            return "/main";
        }else{

            return "redirect:/index.html"; // 重定向
        }
    }

    @RequestMapping("/main")
    public String main(){
        return "/main";
    }


}
