package com.yuyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yuyi.model.Batch;
import com.yuyi.model.User;

/**
 * <P>Title: UserDao</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年1月30日下午1:22:49
 * 
 */
public interface UserDao {
	//登录
	@Select("select * from user where username=#{username} and password=#{password}")
	User selectBylogin(@Param("username")String name,@Param("password")String password);
	
	
	//注册>>查询用户是否存在再进行注册
		@Select("select * from user where username = #{username} and phone= #{phone}")
		String selectUser(@Param("username")String username, @Param("phone")String phone);
		
	//注册>>插入数据
	@Insert("insert into user(username,password,phone,name) values(#{username},#{password},#{phone},#{name})")
	int insertid(@Param("username")String username,@Param("password")String password,
				 @Param("phone")String phone,@Param("name")String name);
	
	@Select("select * from batch")
	List<Batch> SelectByBatch();
	
	
	//修改密码>>查询用户是否存在如果存在再进行修改信息
	@Select("select * from user where username = #{username}  and phone = #{phone}")
	String selectUpdae(@Param("username")String username,@Param("password") String password,@Param("phone")String phone);
	
	
	//修改密码>>查询出来之后进行修改
	@Update("update user set password = #{password} where username = #{username}")
	int xiugaiUser(@Param("username")String username, @Param("password")String password);
	
}
