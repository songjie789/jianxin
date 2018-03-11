package com.yuyi.service;

import java.util.List;

import com.yuyi.model.Car;
import com.yuyi.model.jiashiyuan;

public interface JiaShiYuanService {
	int InsertJiaShiYuan();
	
	List<jiashiyuan> SeleceJiaShiYuan();

	List<Car> Select_Car_Number();
}
