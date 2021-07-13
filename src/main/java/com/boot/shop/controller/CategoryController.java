package com.boot.shop.controller;

import com.boot.shop.bean.CategoryBean;
import com.boot.shop.mapper.CategoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/category") // 该控制器的父路径 localhost:8080/category
public class CategoryController extends BaseController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/list") // localhost:8080/category/list
    public String list(String category, HttpServletRequest req) {
        req.setAttribute("retList", categoryMapper.selectList(null));
        if (StringUtils.isBlank(category)){
            req.setAttribute("retList",categoryMapper.selectList(null));
        }else{
            req.setAttribute("retList",categoryMapper.getLike("%"+category+"%"));
        }
        return "/category/list"; // 转发
    }

    /*
        <a>超链接，可以打开一个页面
            还可以执行一段js代码
            因为可以打开页面，所以是get请求
            超链接会改变浏览器地址，是重定向操作
        <form>表单提交是post请求
        @RequestMapping = @GetMapping + @PostMapping
     */

    @GetMapping("/add") // 打开页面
    public String add(Integer id, HttpServletRequest req) {
        req.setAttribute("bean", id != null ? categoryMapper.selectById(id) : null);
        return "/category/add";
    }

    @PostMapping("/add") //表单提交
    public String add(CategoryBean bean, HttpServletResponse resp) {
        // trim() 去掉字符串首尾空格
        // common.lang3包中的StringUtils.isBlank()函数：判断是否为空
        if (StringUtils.isBlank(bean.getCategory())){
            return jsAlert("请输入类别名称！", ("/category/add" + (bean.getId()!=null ? "?id=" + bean.getId(): "")), resp);
        }
        try {
            if (bean.getId() != null) {      // 修改操作
                categoryMapper.updateById(bean);
            } else {    //添加操作
                categoryMapper.insert(bean);
            }
        }catch (Exception e){
            return jsAlert(bean.getCategory() + "已经存在了！",
                    ("/category/add" + (bean.getId()!=null ? "?id=" + bean.getId(): "")),
                    resp); // resp=response响应，响应给页面
        }

        return "redirect:/category/list";
    }

    @RequestMapping("/del")
    public String del(int id) {
        categoryMapper.deleteById(id);
        return "redirect:/category/list"; // 重新查询列表数据
    }


}
