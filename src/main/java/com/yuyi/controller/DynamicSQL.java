package com.yuyi.controller;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuyi.model.Car;
public class DynamicSQL {
	/**
	 * @param car
	 * @return String
	 */
	public String Select_Synthesis_Car(Car car) {
		return new SQL() {
			{
				SELECT ("*");
				FROM("car_table");
				if(car.getCar_id()!=null && car.getCar_id().equals(""))
					WHERE("car_id=#{car_id}");
				if(car.getCar_name()!=null && car.getCar_name().equals(""))
					WHERE("car_name=#{car_name}");
				if(car.getCar_name()!=null && car.getCar_name().equals(""))
					WHERE("car_number=#{car_number}");
				if(car.getCar_number()!=null && car.getCar_number().equals(""))
					WHERE("car_driver=#{car_driver}");
				if(car.getCar_driver()!=null && car.getCar_driver().equals(""))
					WHERE("car_unit=#{car_unit}");
				if(car.getCar_unit()!=null && car.getCar_unit().equals(""))
					WHERE("car_unit=#{car_unit}");
			}
		}.toString();	
		
	}
}
