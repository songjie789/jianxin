package com.yuyi.service;

import java.util.List;

import com.yuyi.model.Car;

public interface CarService {
	//插入车辆信息
	int insertcar(String carname, String carlength, String carvin, String carnumber,String cardrivers, String unit);
	List<Car> selectCar();
}
