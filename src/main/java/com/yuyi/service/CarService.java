package com.yuyi.service;

import java.util.List;


import com.yuyi.model.Car;
import com.yuyi.model.Car_Repair;
import com.yuyi.model.jiashiyuan;

public interface CarService {
	//添加车辆之前查询车牌号是否存在
	String electcarNumber(String car_number);
	//添加车辆之前查询VIN码是否存在
	String SelectVin(String vins);
	//插入车辆信息
	int insertcar(String carname, String carlength, String carvin, String carnumber,String cardrivers, String unit);
	List<Car> selectCar();
	
	//删除车辆信息
	int CarDelect(String car_id);
	
	//先查询修改的车辆信息,把车辆信息带到修改页面
	Car selectCar(String car_id);
	
	//修改车辆信息
	int updateCar(String car_vins, String car_numbers, String car_units, String car_drivers);
	
	//条件查询
	List<Car> Select_Synthesis_Car(Car car1);
	
	//查询车辆维修信息
	List<Car_Repair> Select_Repair();
	//查询驾驶员信息(名字) 放在车辆维修列表中的下拉列表中
	List<jiashiyuan> Select_Driver();
	//车辆维修添加部件
	int Add_Repair(String part_name);
}
