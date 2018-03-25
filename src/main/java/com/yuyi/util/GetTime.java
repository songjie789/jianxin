package com.yuyi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
	/**
	 * @return String
	 */
	public String time (){
       Date dt=new Date();//获取日期类
       DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
       String Time="";
       Time= df.format(dt);//获取当前系统时间
		return Time;
	}
}
