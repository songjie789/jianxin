package com.yuyi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuyi.dao.UserDao;
import com.yuyi.model.Batch;
import com.yuyi.model.User;
import com.yuyi.service.UserService;


/**
 * <P>Title: UserServiceimpl</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年1月30日下午1:24:41
 * 
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("admin_login")
public class UserServiceimpl implements UserService {
	@Autowired
	private UserDao user;
	
	public User selectBylogin(String name, String password) {
		return user.selectBylogin(name, password);
	}

	public List<Batch> SelectByBatch() {
		return user.SelectByBatch();
	}

	//注册账户
	public int insertid(String username, String password, String phone, String name) {
		return user.insertid(username, password, phone, name);
	}
		//修改密码>>查询用户信息是否存在在进行修改
	public String selectupdate(String username, String password, String phone) {
		return user.selectUpdae(username, password, phone);
	}
	//修改密码>>查询出来之后进行修改
	public int xiugaiUser(String username, String password) {
		return user.xiugaiUser(username,password);
	}
	
	
	//查询用户是否存在,再进行注册
	@Override
	public String selectUser(String username, String phone) {
		return user.selectUser(username,phone);
	}


}
