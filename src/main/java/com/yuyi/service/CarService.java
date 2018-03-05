package com.yuyi.service;

import java.util.List;

import com.yuyi.model.Car;

public interface CarService {
	//插入车辆信息
	int insertcar(String carname, String carlength, String carvin, String carnumber,String cardrivers, String unit);
	List<Car> selectCar();
	
	//删除车辆信息
	int CarDelect(String car_id);
	
	//先查询修改的车辆信息,把车辆信息带到修改页面
	Car selectCar(String car_id);
}
