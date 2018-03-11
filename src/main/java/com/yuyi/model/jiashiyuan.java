package com.yuyi.model;

/**
 * <P>Title: jiashiyuan</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年3月5日下午2:13:48
 * 
 */
public class jiashiyuan {
	private int id;	//驾驶员id (自动编号)
	private String driver_name;//驾驶员姓名
	private String driver_car_number;//驾驶员所属车辆车牌号
	private String driver_address;//驾驶员住址
	private String driver_phone;//驾驶员联系方式
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public String getDriver_car_number() {
		return driver_car_number;
	}
	public void setDriver_car_number(String driver_car_number) {
		this.driver_car_number = driver_car_number;
	}
	public String getDriver_address() {
		return driver_address;
	}
	public void setDriver_address(String driver_address) {
		this.driver_address = driver_address;
	}
	public String getDriver_phone() {
		return driver_phone;
	}
	public void setDriver_phone(String driver_phone) {
		this.driver_phone = driver_phone;
	}
}
