package com.yuyi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuyi.model.Batch;
import com.yuyi.model.User;

/**
 * <P>Title: UserService</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年1月30日下午1:23:18
 * 
 */
public interface UserService {
	
	//登录
	User selectBylogin(String name,String password);
	
	//查询用户是否存在再进行注册
	String selectUser(String username, String phone);
	
	//注册
	int insertid(String username,String password,String phone,String name);
	
	//删除
	List<Batch> SelectByBatch();
	
	//修改密码>>查询用户是否存在之后再进行修改密码
	String selectupdate(String username, String password, String phone);
	
	//修改密码>>查询出来之后进行修改
	int xiugaiUser(String username, String password);
	

	
}
