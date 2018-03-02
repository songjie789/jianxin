package com.ecanal_mail.tools;

import org.junit.Test;

//生成随机6位数验证码
public class CreateRandNum {
	public static String getRandNum() {
		int min=1;
		int max=9;
		String code = "";
	    int randNum = min + (int)(Math.random() * ((max - min) + 1));
	    for(int i=0;i<6;i++){
	    	code = code+(min + (int)(Math.random() * ((max - min) + 1)));
	    }
	    return code;
	}
	@Test
	public void rand(){
	    System.out.println(getRandNum());
	}
}
