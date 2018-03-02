package com.yuyi.service;

import java.util.List;

import com.yuyi.model.loginAdmin;

/**
 * <P>Title: AdminLoginService</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月28日下午2:14:13
 * 
 */
public interface AdminLoginService {
	List<loginAdmin> SelectLoginAdmin();
	int InsertLoginAdmin(String ip,String name,String time);
}
