package com.yuyi.service;

import java.util.List;

import com.yuyi.model.FirstMenu;

/**
 * <P>Title: FirstMenuService</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月1日下午2:21:56
 * 
 */
public interface FirstMenuService {
	List<FirstMenu> selectBy();
	int insertFirst(String name,String classname);
}
