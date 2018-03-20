package com.yuyi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuyi.dao.SecondDao;
import com.yuyi.model.SecondMenu;
import com.yuyi.service.SecondService;

/**
 * <P>Title: SecondServiceimpl</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月5日下午1:57:27
 * 
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("admin_second")
public class SecondServiceimpl implements SecondService {
	
	@Autowired
	private SecondDao second;

	/* (non-Javadoc)
	 * @see com.yuyi.service.SecondService#SelectByid()
	 */
	public List<SecondMenu> SelectByid() {
		// TODO Auto-generated method stub
		return second.SelectByid();
	}

	/* (non-Javadoc)
	 * @see com.yuyi.service.SecondService#InsertFirset(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	public int InsertFirset(Integer id, String name, String address) {
		// TODO Auto-generated method stub
		return second.InsertFirset(id, name, address);
	}
		
}
