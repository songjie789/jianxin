package com.xiaofeixia.sj.service;

import java.util.List;


import com.xiaofeixia.sj.model.Car;
import com.xiaofeixia.sj.model.Car_Repair;
import com.xiaofeixia.sj.model.Part;
import com.xiaofeixia.sj.model.Unit;
import com.xiaofeixia.sj.model.jiashiyuan;

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
	//车辆维修添加部件
	int Add_Repair(String part_name);
	//查询部件名称
	List<Part> SlectPartName();
	//查询驾驶员信息放在添加车辆信息页面
	List<jiashiyuan> SelectJs();
	//查询快递公司放在添加车辆信息页面
	List<Unit> SelectUnit();
	//添加部件
	int InsertPart(String part_name);
	/**
	 * @param car_number
	 * @param repair_address
	 * @param repair_part
	 * @param unit_price
	 * @return
	 * 添加车辆维修记录
	 */
	int InsertRepair(String car_number, String repair_address, String repair_part, String unit_price);
}
