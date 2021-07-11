package com.boot.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// UserBean对应tbl_user表
@TableName("tbl_user")
@Data
public class UserBean {

    @TableId(value = "id",type = IdType.AUTO) // 自增属性
    private Integer id; // int 和Integer：Integer能够接受null，int不能
    private String username;
    private String password;

}
