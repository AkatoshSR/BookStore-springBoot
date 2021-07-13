package com.boot.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.shop.bean.CategoryBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryBean> {

    // 增删改查
    @Select("select * from tbl_category where category like #{category}")
    List<CategoryBean> getLike(@Param("category") String category);

}
