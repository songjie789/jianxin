package com.yuyi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuyi.dao.AdminLogin;
import com.yuyi.model.loginAdmin;
import com.yuyi.service.AdminLoginService;

/**
 * <P>Title: AdminLoginServiceimpl</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月28日下午2:13:54
 * 
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("admin_logina")
public class AdminLoginServiceimpl implements AdminLoginService {
	
	@Autowired
	private AdminLogin al;
	
	public List<loginAdmin> SelectLoginAdmin() {
		// TODO Auto-generated method stub
		return al.SelectLoginAdmin();
	}

	public int InsertLoginAdmin(String ip, String name, String time) {
		// TODO Auto-generated method stub
		return al.InsertLoginAdmin(ip, name, time);
	}

}
