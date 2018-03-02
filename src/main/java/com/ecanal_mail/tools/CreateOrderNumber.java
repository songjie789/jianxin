package com.ecanal_mail.tools;

import java.util.Random;

public class CreateOrderNumber {
	/*
	 * 生成订单编号
	 * lyb
	 */
	
	@SuppressWarnings("static-access")
	public static String doCreateOrderNumber(){

		//生成订单编号， 防止出现重复
		String number;//订单编号
		Object m=new Object();
		synchronized (m) { 
			
			Random ran=new Random();
			Integer a=0;
			while(a<10)a=ran.nextInt(100);
			Long b=System.currentTimeMillis();//毫秒数
			number=a.toString()+b.toString() ;//订单编号=两位随机数+毫秒数 
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return number;
	}
	
	
}
