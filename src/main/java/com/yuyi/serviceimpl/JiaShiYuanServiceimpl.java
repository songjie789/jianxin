package com.yuyi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuyi.dao.JiaShiYuanDao;
import com.yuyi.model.jiashiyuan;
import com.yuyi.service.JiaShiYuanService;


/**
 * <P>Title: JiaShiYuanServiceimpl</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年3月5日下午2:58:50
 * 
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("admin_jiashiyuan")
public class JiaShiYuanServiceimpl implements JiaShiYuanService {

	@Autowired
	private JiaShiYuanDao jsy;
	
	@Override
	public int InsertJiaShiYuan() {
		// TODO Auto-generated method stub
		return jsy.InsertJiaShiYuan();
	}

	@Override
	public List<jiashiyuan> SeleceJiaShiYuan() {
		// TODO Auto-generated method stub
		return jsy.SeleceJiaShiYuan();
	}

	
	//加载车牌号下拉框的值
	@Override
	public String Select_Car_Number() {
		// TODO Auto-generated method stub
		return jsy.Select_Car_Number();
	}

}
