package com.xiaofeixia.sj.model;

/**
 * <P>Title: Batch</p>
 * <p>Description:test</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年1月31日下午2:04:31
 * 
 */
public class Batch {
	private int id;
	private String shanchu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShanchu() {
		return shanchu;
	}
	public void setShanchu(String shanchu) {
		this.shanchu = shanchu;
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", shanchu=" + shanchu + "]";
	}
}
