package com.ecanal_mail.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//获取时间
public class TimeDate {

	//
	public static String getDate(){
		String date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.format(new Date());
		return date;
	}
	//
	public static String getDateTime(){
		String date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = df.format(new Date());
		return date;
	}
	//获取加时后的时间
	public static String getFutureTime(String time,int m) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now =df.parse(time);
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(now);
//		System.out.println("改变前的时间："+time);
		nowTime.add(Calendar.MINUTE,m);
//		System.out.println("180分钟后的时间:"+df.format(nowTime.getTime()));
		return df.format(nowTime.getTime());
	}
	//与当前时间比较大小
	public static int dateCSize(String time) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time1 = df.parse(df.format(new Date()));
		Date time2 = df.parse(time);
		//System.out.println("当前时间："+df.format(new Date()));
		//System.out.println("比较的时间："+time);
		if(time2.getTime()>time1.getTime()){
			return 1;
		}else{
			return 0;
		}
	}
	//时间转时间戳
	public static Long dataToLongData(String time) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date time2 = df.parse(time);
		Long t = time2.getTime();
		return t;
	}
	//时间戳转时间
	public static String LongDatatoData(Long time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(time);
	}
	public static void main(String[] args) throws ParseException {
		String time = "2017-09-12 13:21:32";
		System.out.println(TimeDate.getFutureTime(time, 30));
	}

}
