package com.yuyi.model;

//车辆部件
public class Part {
	private Integer id; //部件ID  自增 1001开始
	private String part_name; //部件名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	
	
}
