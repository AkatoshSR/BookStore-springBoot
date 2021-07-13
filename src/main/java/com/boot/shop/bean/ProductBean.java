package com.boot.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.shop.utils.NotNull;
import lombok.Data;

@TableName("tbl_product")
@Data
public class ProductBean {

    // 关联查询的时候起作用，增删改查不起作用
    @TableField(exist = false)  // 数据表没有该字段，自定义字段
    private String category;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotNull
    private String product;
    @NotNull
    private Integer price;
    @NotNull
    private Integer num;
    @NotNull
    private String logo;
    private Integer hot;
    private Integer cid;

}
