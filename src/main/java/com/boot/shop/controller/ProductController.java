package com.boot.shop.controller;

import com.boot.shop.bean.ProductBean;
import com.boot.shop.mapper.ProductMapper;
import com.boot.shop.utils.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/list")
    public String list(Integer cid, HttpServletRequest req){
        req.setAttribute("retList", (cid != null? productMapper.getProduct(cid) : productMapper.selectList(null)));
        req.setAttribute("cid", cid);
        return "/product/list";
    }

    @GetMapping("/add")
    public String add(Integer id, int cid, HttpServletRequest req){
        req.setAttribute("cid", cid);
        req.setAttribute("bean", id != null ? productMapper.selectById(id) : null);
        return "/product/add";
    }

    @PostMapping("/add")
    public String add(ProductBean bean,HttpServletResponse resp){
        // 每个属性值不能为空
        if (NotNullUtil.isBlank(bean)){
            //@NotNull注解的属性，为空则为true
            System.out.println("/product/add?cid=" + bean.getCid() +
                                                (bean.getId()!=null?"&id="+bean.getId():""));
            return jsAlert("请完善商品信息!",
                            "/product/add?cid=" + bean.getCid() +
                                    (bean.getId()!=null?"&id="+bean.getId():""),
                                    resp);
        }

        // 整形数据取正
        bean.setPrice(Math.abs(bean.getPrice()));
        bean.setNum(Math.abs(bean.getNum()));

        if (bean.getId() != null){
            productMapper.updateById(bean);
        }else {
            productMapper.insert(bean);
        }
        return "redirect:/product/list?cid=" + bean.getCid();
    }

    @GetMapping("/del")
    public String del(int id, int cid){
        productMapper.deleteById(id);
        return "redirect:/product/list?cid=" + cid;
    }

    // localhost:8080/product/logo
    @RequestMapping("/logo")
    public void logo(MultipartFile file, HttpServletResponse resp){
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File("E:/a_resources/a_resources/create/shop/file/" + fileName));
        } catch (IOException e) {
            System.out.println("路径错误");
        }
        /* 自定义函数：输出图片路径给页面
        *
        *
        * */

        outRespJson("/shop/file/" + fileName, resp);
    }


}
