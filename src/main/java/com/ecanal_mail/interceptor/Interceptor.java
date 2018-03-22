package com.ecanal_mail.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ecanal_mail.interceptor.JCURL;
import com.ecanal_mail.interceptor.LYBURL;
import com.ecanal_mail.interceptor.MCURL;
import com.ecanal_mail.interceptor.OURL;
import com.ecanal_mail.interceptor.SRURL;
import com.yuyi.model.User;

public class Interceptor implements HandlerInterceptor  {

	
	private static final String[] NURL = MCURL.union(MCURL.getNURL(), LYBURL.getNURL(), SRURL.getNURL(), OURL.getNURL(),
			JCURL.getNURL());
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse resp, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		
	
		return true;

	}
}
