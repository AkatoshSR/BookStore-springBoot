package com.boot.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tbl_category")
@Data
public class CategoryBean {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String category;

}
