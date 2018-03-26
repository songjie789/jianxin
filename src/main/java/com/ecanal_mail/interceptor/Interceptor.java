package com.ecanal_mail.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaofeixia.sj.model.User;


public class Interceptor implements HandlerInterceptor  {

	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse resp, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url=request.getRequestURI();
		HttpSession session=request.getSession();
		String u=(String)session.getAttribute("admin");
		
		/*if(u!=null ||url.indexOf("/maven_ssm/login")==0||url.indexOf("/maven_ssm/index")==0 ){
			System.out.println("zzzzzzzz"+url.indexOf("/maven_ssm/login"));
			System.out.println("zzzzzzzz++"+url.indexOf("/maven_ssm/index"));
			if( u==null ) {
				request.setAttribute("zhuang", "请先进行登录!!");
				request.getRequestDispatcher("login").forward(request, response);
				return false;
			}else {
				return true; 
			}
			
		}else {
			System.out.println("拦截器2+"+u);
			request.setAttribute("zhuang", "请先进行登录!!");
			request.getRequestDispatcher("login").forward(request, response);
			return false;
		}*/
		return true;
	}
}
