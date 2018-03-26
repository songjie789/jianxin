package com.xiaofeixia.sj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecanal_mail.tools.ErrorUtil;
import com.ecanal_mail.tools.GetServletIp;
import com.xiaofeixia.sj.model.Batch;
import com.xiaofeixia.sj.model.User;
import com.xiaofeixia.sj.service.AdminLoginService;
import com.xiaofeixia.sj.service.ErrorService;
import com.xiaofeixia.sj.service.UserService;
import com.xiaofeixia.sj.util.GetTime;
import com.xiaofeixia.sj.util.MD5;

@Controller
public class DeptController {
 
	  //获取MD5加密工具类
	@Qualifier("MD5")
	private MD5 md5;
	
	@Autowired
	@Qualifier("admin_login")
	private UserService user;	
	
	@Autowired
	@Qualifier("admin_logina")
	private AdminLoginService als;
	
	//引入捕获异常转换字符串的util
	ErrorUtil errorUtil = new ErrorUtil();
	//获取存储异常的service层
	@Autowired
	@Qualifier("ErrorService")
	private ErrorService errorService;
	
	//跳转登陆页面
	@RequestMapping("login")
	public String findAll() throws Exception{	
		return "/login";
	}
	
	@RequestMapping("registration")
	public String registration(Model m) {
		try {
		    List<Batch> b=user.SelectByBatch();
			m.addAttribute("Batch", b);
		} catch (Exception e) {
		    errorService.InsertError(errorUtil.getError(e));
		}
		return "/registration";
		
	}
	/**
	 * @param username
	 * @param password
	 * @param session
	 * @param request
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("index")
	public String index(@RequestParam("username")String username,
			@RequestParam(required=false,defaultValue="password")String password,
			HttpSession session,HttpServletRequest request,Model m) throws Exception {
		String statan="1";
		String md5password = md5.MD5(password);
		User a=user.selectBylogin(username, md5password);
		String ipp = GetServletIp.getIpAddr(request);
		//正确进入
		if(a!=null&&a.getSupera().equals("正常")) {	
			System.out.println(username);
			session.setAttribute("admin", username);   //存放登陆标记
			GetTime getTime = new GetTime();
			String time = getTime.time();
			String ip = GetServletIp.getIpAddr(request);
			String admin = (String) session.getAttribute("admin");
			als.InsertLoginAdmin(ip, admin, time);
			return "redirect:tiaozhuan";
		}
		//判断管理员是否被禁用
		else if(a!=null) {
			if(a.getSupera().equals("禁用")){
				statan = "你的账号被禁用，请联系超级管理员";				
			}			
			m.addAttribute("zhuan", statan);
			return "/login";
		}
		statan = "你输入的账号密码不正确";
		m.addAttribute("zhuan", statan);
		return "/login";
		
	}
	
	//退出登陆
	@RequestMapping("DroPout")
	public String DroPout(HttpSession session) {
	    session.invalidate();  //清楚登陆标记
	    return "redirect:login";
	    
	}
	
	
	

	//登陆之后转向主页面 向数据库添加 登陆的IP登陆的用户名登陆的时间
	/**
	 * @return String
	 * @throws Exception
	 */
	//登陆之后转向主页面 向数据库添加 登陆的IP登陆的用户名登陆的时间
		@RequestMapping("tiaozhuan")
		public String logina() throws Exception {
				return "/index";
		}
	
	//修改密码
	/**
	 * @param username
	 * @param password
	 * @param phone
	 * @param aa
	 * @param session
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("registrationAdmin")
	public void registrationAdmin(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("phone")String phone,Model aa,HttpSession session,
			HttpServletResponse response) {	
			try {
			    int ok = 0;
				int number = 0;
				PrintWriter out = response.getWriter();
				//修改密码>>查询用户是否存在再进行修改密码
				String md5password = md5.MD5(password);
				String selectUpdate = user.selectupdate(username,md5password,phone);
				//查询出来的用户信息如果不为空就可以修改用户
				if(selectUpdate!=null){
					number = user.xiugaiUser(username,md5password);
					if(number>0){
						ok=1;
					}else{
						ok=0;
					}
				}else{
					ok=2;
				}
				out.print(ok);
			} catch (Exception e) {
			    errorService.InsertError(errorUtil.getError(e));
			}
	}
	
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping("/del")  
	public void batchDeletes(HttpServletRequest request, HttpServletResponse response) {  
	    String items = request.getParameter("delitems");
	    String[] strs = items.split(",");  
	  
	    for (int i = 0; i < strs.length; i++) {  
	        try {  
	            System.out.println(strs[i]);
	        } catch (Exception e) {  
	            errorService.InsertError(errorUtil.getError(e));
	        }  
	    }  
	}
	
	
	
	//先查询用户是否存在,不存在再注册用户
	/**
	 * @param username
	 * @param password
	 * @param phone
	 * @param name
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("AddUsers")
	public void AddUsers(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("phone")String phone,@RequestParam("name")String name,
			HttpSession session,HttpServletResponse response){
	    try {
		String md5password = md5.MD5(password);
		int ok = 0;
		int number=0;
		PrintWriter out = response.getWriter();
		String selectuser = user.selectUser(username,phone);
		if(selectuser==null){
			number = user.insertid(username, md5password, phone, name);
			if(number>0){
				ok=1;   //添加用户成功
			}else{
				ok=0;	 //添加用户失败
			}
		}else{
			ok=2;	//用户已存在
		}
		out.print(ok);
	    } catch (Exception e) {
		 errorService.InsertError(errorUtil.getError(e));
	    }
	}
}
