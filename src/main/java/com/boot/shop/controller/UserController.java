package com.boot.shop.controller;

import com.boot.shop.bean.UserBean;
import com.boot.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController extends BaseController{

    /*
        重定向：redirect:/地址.html
            1.浏览器地址栏地址变化
            2.可以访问到static文件夹页面
            3.不可以访问到templates
            4.可以找到static文件和controller里面的地址
            5.重定向传参，xxx?a=value1&b=value2

        转发 /地址
            1.浏览器地址栏不变
            2.可以访问templates文件夹页面
            3.不能访问static
            4.转发传参：req.setAttribute('a', value)

     */

    // Controller层调用mapper
    @Autowired
    private UserMapper userMapper;

    //
    @RequestMapping("/login")
    public String login(String username,String password){
        UserBean user = userMapper.getUser(username, password);

        return user != null ? ("redirect:/main?uid=" + user.getId()) :
                ("redirect:/index.html?msg=" + getUTF8Param("用户名或密码错误"));
    }

    @RequestMapping("/main")
    public String main(int uid, HttpServletRequest request){
        // selectById是BaseMapper封装的函数，根据id查询
        request.setAttribute("bean", userMapper.selectById(uid));
        return "/main";
    }


}
