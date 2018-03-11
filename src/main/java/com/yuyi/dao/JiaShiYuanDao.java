package com.yuyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
	String Select_Car_Number();
}
