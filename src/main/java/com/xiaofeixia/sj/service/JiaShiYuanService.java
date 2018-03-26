package com.xiaofeixia.sj.service;

import java.util.List;

import com.xiaofeixia.sj.model.Car;
import com.xiaofeixia.sj.model.jiashiyuan;

public interface JiaShiYuanService {
	int InsertJiaShiYuan();
	//查询驾驶员信息
	List<jiashiyuan> SeleceJiaShiYuan();
	//查询车牌号出来给驾驶员添加页面
	List<Car> Select_Car_Number();
	//添加驾驶员信息
	int Add_Driver(String driver_name, String driver_car_number, String driver_address, String driver_phone);
}
