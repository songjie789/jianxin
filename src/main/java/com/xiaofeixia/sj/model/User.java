package com.xiaofeixia.sj.model;

/**
 * <P>Title: User</p>
 * <p>Description:user</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年1月30日下午12:54:13
 * 
 */
public class User {

	private int id;
	private String username;
	private String password;
	private String phone;
	private String name;
	private String supera;
	/**
	 * @return the supera
	 */
	public String getSupera() {
	    return supera;
	}
	/**
	 * @param supera the supera to set
	 */
	public void setSupera(String supera) {
	    this.supera = supera;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", name="
				+ name + "]";
	}
	
}
