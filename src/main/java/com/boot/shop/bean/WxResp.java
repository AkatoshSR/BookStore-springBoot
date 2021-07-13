package com.boot.shop.bean;

import java.util.List;

// 给小程序
public class WxResp {
    // 状态码 1：成功，0：失败，默认1
    public int code = 1;

    //错误提示信息
    public String msg = "";

    // 发生错误的函数
    public void fail(String msg){
        this.code = 0; // 失败
        this.msg = msg; // 错误提示
    }

    public List<CategoryBean> category; // 类别数组
    public List<ProductBean> product;   // 商品数组
    public List<ProductBean> hot;       // 热卖数组


}
