package com.boot.shop.controller;

import com.boot.shop.bean.CategoryBean;
import com.boot.shop.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/category") // 该控制器的父路径 localhost:8080/category
public class CategoryController extends BaseController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/list") // localhost:8080/category/list
    public String list(HttpServletRequest req) {
        List<CategoryBean> categoryList = categoryMapper.selectList(null);
        req.setAttribute("retList", categoryMapper.selectList(null));
        return "/category/list"; // 转发
    }

    @RequestMapping("/add")
    public String add() {
        System.out.println("添加操作");


        return null;
    }

    @RequestMapping("/del")
    public String del() {
        System.out.println("删除操作");
        return null;
    }


}
