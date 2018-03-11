package com.yuyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yuyi.model.Car;
import com.yuyi.model.jiashiyuan;



public interface JiaShiYuanDao {
	//新增驾驶员信息
	@Insert("insert into jiashiyuan_table(name,age,shenfezheng_id,jiashiyuan_name,zhuzhi,phone,car_number,card) values(#{name},#{age},#{shenfezheng_id},#{jiashiyuan_name},#{zhuzhi},#{phone},#{car_number},#{card})")
	int InsertJiaShiYuan();
	//查询驾驶员信息
	@Select("select * from driver_table")
	List<jiashiyuan> SeleceJiaShiYuan();
	
	//调取所有车辆的车牌号做驾驶员所属车辆下拉框的值
	@Select("select car_number from car_table")
	List<Car> Select_Car_Number();
	
	//添加驾驶员信息
	@Insert("INSERT INTO driver_table (driver_name,driver_car_number,driver_address,driver_phone) VALUES (#{driver_name},#{driver_car_number},#{driver_address},#{driver_phone})")
	int Add_Driver(@Param("driver_name")String driver_name,@Param("driver_car_number")String driver_car_number, @Param("driver_address")String driver_address, @Param("driver_phone")String driver_phone);
}
