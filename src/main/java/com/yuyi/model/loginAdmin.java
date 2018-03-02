package com.yuyi.model;

import java.util.Date;

/**
 * <P>Title: loginAdmin</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月27日下午3:07:48
 * 
 */
public class loginAdmin {
	private int id;	//id  自增 
	private String ip;  //记录用户ip
	private String time;  //记录用户登录时间
	private String name;  //登录用户的名字
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
