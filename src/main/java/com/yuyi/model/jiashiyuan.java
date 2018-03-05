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
	private int id;	//id
	private String name;	//姓名
	private int age;	//年龄
	private int shenfezheng_id;	//车辆id
	private int jiashiyuan_name;	//驾驶证id；
	private String zhuzi;	//住址
	private String phone;	//手机
	private String car_number;	//使用车辆编号
	private String card;	//身份证号
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getShenfezheng_id() {
		return shenfezheng_id;
	}

	public void setShenfezheng_id(int shenfezheng_id) {
		this.shenfezheng_id = shenfezheng_id;
	}

	public int getJiashiyuan_name() {
		return jiashiyuan_name;
	}

	public void setJiashiyuan_name(int jiashiyuan_name) {
		this.jiashiyuan_name = jiashiyuan_name;
	}

	public String getZhuzi() {
		return zhuzi;
	}

	public void setZhuzi(String zhuzi) {
		this.zhuzi = zhuzi;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "jiashiyuan [age=" + age + ", car_number=" + car_number + ", card=" + card + ", id=" + id
				+ ", jiashiyuan_name=" + jiashiyuan_name + ", name=" + name + ", phone=" + phone + ", shenfezheng_id="
				+ shenfezheng_id + ", zhuzi=" + zhuzi + "]";
	}
	
}
