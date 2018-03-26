package com.xiaofeixia.sj.service;

import java.util.List;

import com.xiaofeixia.sj.model.loginAdmin;

/**
 * <P>Title: AdminLoginService</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月28日下午2:14:13
 * 
 */
public interface AdminLoginService {
	/**
	 * @return List<loginAdmin>
	 */
	List<loginAdmin> SelectLoginAdmin();
	
	/**
	 * @param ip
	 * @param name
	 * @param time
	 * @return int
	 */
	int InsertLoginAdmin(String ip,String name,String time);
}
