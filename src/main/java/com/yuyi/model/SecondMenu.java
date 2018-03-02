package com.yuyi.model;

/**
 * <P>Title: SecondMenu</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月6日下午1:27:15
 * 
 */
public class SecondMenu {
	private int id;	//id
	private int firset_menu_id;	//一级菜单id
	private FirstMenu firstmenu;	//一级菜单
	private String name;	//二级菜单名称
	public int getFirset_menu_id() {
		return firset_menu_id;
	}
	public void setFirset_menu_id(int firset_menu_id) {
		this.firset_menu_id = firset_menu_id;
	}
	private String address;	//链接地址
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FirstMenu getFirstmenu() {
		return firstmenu;
	}
	public void setFirstmenu(FirstMenu firstmenu) {
		this.firstmenu = firstmenu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SecondMenu [id=" + id + ", firstmenu=" + firstmenu + ", name=" + name + ", address=" + address + "]";
	}
	
}
