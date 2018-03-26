package com.xiaofeixia.sj.model;


//车辆维修
public class Car_Repair {
	private int id;   //   车辆维修ID 自增
	private String car_number;  //车牌号
	private String repair_address; //维修地点
	private String repair_part; //维修部件
	private String unit_price; //部件单价
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRepair_car_number() {
		return car_number;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public String getRepair_address() {
		return repair_address;
	}
	public void setRepair_address(String repair_address) {
		this.repair_address = repair_address;
	}
	public String getRepair_part() {
		return repair_part;
	}
	public void setRepair_part(String repair_part) {
		this.repair_part = repair_part;
	}
	public String getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}
}
