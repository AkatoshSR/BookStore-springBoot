package com.boot.shop.controller;

import com.boot.shop.bean.WxResp;
import com.boot.shop.mapper.CategoryMapper;
import com.boot.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/wx")
public class WxController extends BaseController {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;

    // localhost:8080/wx/index, 这个地址浏览器可以访问，小程序可以访问
    @GetMapping("/index")
    public void index(Integer cid, HttpServletResponse resp){
        WxResp r = new WxResp(); // 自定义的普通对象
        r.category = categoryMapper.selectList(null);
        if (!r.category.isEmpty()){
            r.product = cid != null ? productMapper.getProduct(cid) : productMapper.getProduct(r.category.get(0).getId());
        }
        r.hot = productMapper.getHot();
        outRespJson(r, resp); // 可以把对象转换成Json字符串输出到浏览器或小程序中
    }

}
