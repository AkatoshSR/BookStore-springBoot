package com.boot.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.shop.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

// 继承BaseMapper可以实现简单的增删改查
// 复杂的增删改查，只能写SQL语句
@Mapper
public interface UserMapper extends BaseMapper<UserBean> {

    /*
    通过用户名和密码去tbl_user找这一行数据
        找到：登录成功
        否则失败

        Mybatis的sql注解
        @Select，@Insert，@Delete，@Update

     */

    // 调用getUser相当于调用了sql语句
    // @Param 绑定参数，方法形参绑定到占位符?上
    // #{}取参数
    @Select("select * from tbl_user where username = #{username} and password = #{password}")
    UserBean getUser(@Param("username") String username, @Param("password") String password);

}
