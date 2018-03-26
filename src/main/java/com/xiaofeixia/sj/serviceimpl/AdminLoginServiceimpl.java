package com.xiaofeixia.sj.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaofeixia.sj.dao.AdminLogin;
import com.xiaofeixia.sj.model.loginAdmin;
import com.xiaofeixia.sj.service.AdminLoginService;



@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("admin_logina")
public class AdminLoginServiceimpl implements AdminLoginService {
	
	@Autowired
	private AdminLogin al;
	
	/* (non-Javadoc)
	 * @see com.yuyi.service.AdminLoginService#SelectLoginAdmin()
	 */
	public List<loginAdmin> SelectLoginAdmin() {
		return al.SelectLoginAdmin();
	}

	/* (non-Javadoc)
	 * @see com.yuyi.service.AdminLoginService#InsertLoginAdmin(java.lang.String, java.lang.String, java.lang.String)
	 */
	public int InsertLoginAdmin(String ip, String name, String time) {
		System.out.println("service"+ip+name+time);
		return al.InsertLoginAdmin(ip, name, time);
	}

}
