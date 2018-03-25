package com.yuyi.service;

import java.util.List;

import com.yuyi.model.User;

public interface PowerService {
	//查询所有管理员
	List<User> ByUser();

	//重置管理员密码
	int UpdateMima(String password ,Integer id);
	
	//查询管理员状态
	User SelectZhuang(Integer id);
	
	//修改管理员状态
	int UpdateZhuang(String supera,Integer id);
}
