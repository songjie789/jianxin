package com.yuyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yuyi.model.Car;

public interface CarDao {
	//插入车辆信息
	@Insert("insert into car_table (car_name,car_length,car_vin,car_number,car_driver,car_unit) values(#{carname},#{carlength},#{carvin},#{carnumber},#{cardrivers},#{unit})")
	int insertcat(@Param("carname")String carname, @Param("carlength")String carlength,@Param("carvin") String carvin,@Param("carnumber")String carnumber,@Param("cardrivers") String cardrivers, @Param("unit")String unit);
	
	
	//查询车辆信息进行分页展示
	@Select("select * from car_table order by car_id desc")
	List<Car> selectCar();
}
