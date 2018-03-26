package com.xiaofeixia.sj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaofeixia.sj.model.User;

public interface PowerDao {
	//查询所有管理员
	@Select("select * from user")
	List<User> ByUser();
	
	//修改管理员密码
	@Update("update user set password = #{password} where id=#{id}")
	int UpdateMima(@Param("password")String password ,@Param("id") Integer id);
	
	//查询管理员状态
	@Select("select supera from user where id=#{id}")
	User SelectZhuang(@Param("id") Integer id);
	
	//查询完后进行修改
	@Update("update user set supera=#{supera} where id=#{id}")
	int UpdateZhuang(@Param("supera")String supera,@Param("id") Integer id);
	
	
}
