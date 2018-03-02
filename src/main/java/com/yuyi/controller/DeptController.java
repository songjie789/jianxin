package com.yuyi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyunhe.rsatools.RSAUtils;
import com.yuyi.model.Batch;
import com.yuyi.model.User;
import com.yuyi.service.AdminLoginService;
import com.yuyi.service.UserService;
import com.yuyi.util.GetTime;
import com.yuyi.util.MD5;
import com.yuyi.util.getIP;

import javassist.expr.NewArray;


@Controller
public class DeptController {
	@Autowired
	@Qualifier("admin_login")
	private UserService user;	
	
	@Autowired
	@Qualifier("admin_logina")
	private AdminLoginService als;
	
	//跳转登陆页面
	@RequestMapping("login")
	public String findAll() throws Exception{	
		return "/login";
	}
	
	@RequestMapping("registration")
	public String registration(Model m) {
		List<Batch> b=user.SelectByBatch();
		m.addAttribute("Batch", b);
		return "/registration";
		
	}
	
	//获取MD5加密工具类
	MD5 md5 = new MD5();

	//登陆之后转向主页面 向数据库添加 登陆的IP登陆的用户名登陆的时间
	@RequestMapping("indexa")
	public String logina(@RequestParam("username")String username,@RequestParam("password")String password,
			HttpSession session) throws Exception {
		String md5password = md5.MD5(password);
		User denglu=user.selectBylogin(username, md5password);
			session.setAttribute("admin", username);   //存放登陆标记
			getIP getIP = new getIP();
			GetTime getTime = new GetTime();
			String time = getTime.time();
			String ip = getIP.IP();
			String admin = (String) session.getAttribute("admin");
			int a = als.InsertLoginAdmin(ip, admin, time);
		return "/index";
	}
	
	//修改密码
	@RequestMapping("registrationAdmin")
	public void registrationAdmin(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("phone")String phone,Model aa,HttpSession session,
			HttpServletResponse response) throws Exception {	
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
	}
	
	
	@RequestMapping("/del")  
	public void batchDeletes(HttpServletRequest request, HttpServletResponse response) {  
	    String items = request.getParameter("delitems");
	    String[] strs = items.split(",");  
	  
	    for (int i = 0; i < strs.length; i++) {  
	        try {  
	            System.out.println(strs[i]);
	        } catch (Exception e) {  
	        	
	        }  
	    }  
	}
	
	
	
	//先查询用户是否存在,不存在再注册用户
	@RequestMapping("AddUsers")
	public void AddUsers(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("phone")String phone,@RequestParam("name")String name,
			HttpSession session,HttpServletResponse response) throws IOException {
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
	}
	
	
}
