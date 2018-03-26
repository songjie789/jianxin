package com.xiaofeixia.sj.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaofeixia.sj.dao.JiaShiYuanDao;
import com.xiaofeixia.sj.model.Car;
import com.xiaofeixia.sj.model.jiashiyuan;
import com.xiaofeixia.sj.service.JiaShiYuanService;


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
	
	/* (non-Javadoc)
	 * @see com.xiaofeixia.sj.service.JiaShiYuanService#InsertJiaShiYuan()
	 */
	@Override
	public int InsertJiaShiYuan() {
		// TODO Auto-generated method stub
		return jsy.InsertJiaShiYuan();
	}

	/* (non-Javadoc)
	 * @see com.xiaofeixia.sj.service.JiaShiYuanService#SeleceJiaShiYuan()
	 */
	@Override
	public List<jiashiyuan> SeleceJiaShiYuan() {
		// TODO Auto-generated method stub
		return jsy.SeleceJiaShiYuan();
	}

	
	//加载车牌号下拉框的值
	@Override
	public List<Car> Select_Car_Number() {
		// TODO Auto-generated method stub
		return jsy.Select_Car_Number();
	}
	
	
	//添加驾驶员信息
	@Override
	public int Add_Driver(String driver_name, String driver_car_number, String driver_address, String driver_phone) {
		return jsy.Add_Driver(driver_name,driver_car_number,driver_address,driver_phone);
	}

}
