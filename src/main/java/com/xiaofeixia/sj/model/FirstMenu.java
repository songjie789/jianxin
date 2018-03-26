package com.xiaofeixia.sj.model;

/**
 * <P>Title: FirstMenu</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年3月1日下午1:48:26
 * 
 */
public class FirstMenu {
	private int id;	//id
	private String name;	//菜单类型
	private String classname;	//图片类型	
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
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "FirstMenu [id=" + id + ", name=" + name + ", classname=" + classname + "]";
	}
	
}
