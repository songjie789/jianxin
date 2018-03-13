package com.yuyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.yuyi.controller.DynamicSQL;
import com.yuyi.model.Car;


public interface CarDao {
	//	添加车辆之前查询车牌号是否以存在
	@Select("select car_number from car_table where car_number = #{car_number}")
	String SelectCar_Number(String car_number);
	//添加车辆之前查询VIN是否以存在
	@Select("select car_vin from car_table where car_vin = #{vins} ")
		String selectvin(String vins);
		
	//插入车辆信息
	@Insert("insert into car_table (car_name,car_length,car_vin,car_number,car_driver,car_unit) values(#{carname},#{carlength},#{carvin},#{carnumber},#{cardrivers},#{unit})")
	int insertcat(@Param("carname")String carname, @Param("carlength")String carlength,@Param("carvin") String carvin,@Param("carnumber")String carnumber,@Param("cardrivers") String cardrivers, @Param("unit")String unit);
	
	
	//查询车辆信息进行分页展示
	@Select("select * from car_table order by car_id desc")
	List<Car> selectCar();
	
	
	//删除车辆信息
	@Delete("delete from car_table where car_id=#{car_id}")
	int carDelect(String car_id);
	
	
	//查询修改车辆信息
	@Select("select * from car_table where car_id = #{car_id}")
	Car select_car(String car_id);
	
	
	//修改车辆信息
	@Update("update car_table set car_number = #{car_numbers},car_driver =#{car_drivers},car_unit=#{car_units} where car_vin = #{car_vins}")
	int updatecar(@Param("car_vins")String car_vins,@Param("car_drivers")String car_drivers,@Param("car_numbers")String car_numbers,  @Param("car_units")String car_units );
	
	
	@SelectProvider(type=DynamicSQL.class,method="Select_Synthesis_Car")
	List<Car> Select_Synthesis_Car(Car car1);
}
