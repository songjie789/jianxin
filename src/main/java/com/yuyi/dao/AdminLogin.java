package com.yuyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yuyi.model.loginAdmin;

/**
 * <P>Title: AdminLogin</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月27日下午3:05:31
 * 
 */
public interface AdminLogin {
	@Select("select * from admin_login_table order by id desc")
	List<loginAdmin> SelectLoginAdmin();
	
	@Insert("insert into admin_login_table(ip,name,time) values(#{ip},#{name},#{time})")
	int InsertLoginAdmin(@Param("ip")String ip,@Param("name")String name,@Param("time")String time);
}
