package com.ecanal_mail.tools;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 ** 
 *  @Organization：小飞侠
 *  @time  2018年3月23日上午12:05:05  
 *  @author   SongJie
 *  相关说明 :  截取异常信息的方法名 类名 和出现错误的行数 以及出现异常事件
 * 
 */

@Component("ErrorUtil")
public class ErrorUtil {
    public String getError(Exception e) {
	 StackTraceElement[] st = e.getStackTrace();
	 String exclass = null;
	 String method = null;
		for (StackTraceElement stackTraceElement : st) {
		 exclass = stackTraceElement.getClassName();  //获取异常信息类名
		method = stackTraceElement.getMethodName();   //获取异常信息方法名

		 return new Date() + ":" + "[类:" + exclass + "]调用"
		+ method + "时在第" + stackTraceElement.getLineNumber()
		+ "行代码处发生异常!异常类型:" + e.getClass().getName();
   }
		return null;
}
}
