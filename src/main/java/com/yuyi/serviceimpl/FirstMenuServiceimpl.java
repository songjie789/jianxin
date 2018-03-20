package com.yuyi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuyi.dao.FirstMenuDao;
import com.yuyi.model.*;
import com.yuyi.service.FirstMenuService;

/**
 * <P>Title: FirstMenuServiceimpl</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月1日下午2:23:57
 * 
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("admin_onemenu")
public class FirstMenuServiceimpl implements FirstMenuService {
	
	@Autowired
	private FirstMenuDao first;

	/* (non-Javadoc)
	 * @see com.yuyi.service.FirstMenuService#selectBy()
	 */
	public List<FirstMenu> selectBy() {
		return first.selectBy();
	}

	/* (non-Javadoc)
	 * @see com.yuyi.service.FirstMenuService#insertFirst(java.lang.String, java.lang.String)
	 */
	public int insertFirst(String name, String classname) {
		return first.insertFirst(name, classname);
	}
	
}
