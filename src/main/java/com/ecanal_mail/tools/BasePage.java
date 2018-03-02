package com.ecanal_mail.tools;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


public class BasePage {
	public static String getBasePage(HttpServletRequest request) throws IOException{
//		String basepath = request.getServletContext().getRealPath("");	//获取系统运行路径
//		basepath = basepath.replaceAll("\\\\", "/");					//字符转换
//		basepath = basepath.replace("/e_canal/", "");	
		 String url = request.getScheme()+"://" + request.getServerName()+":" +request.getServerPort();
		return url;
	}
	
}
