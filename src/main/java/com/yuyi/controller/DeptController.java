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

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyunhe.rsatools.RSAUtils;
import com.yuyi.model.Batch;
import com.yuyi.model.User;
import com.yuyi.model.loginAdmin;
import com.yuyi.service.AdminLoginService;
import com.yuyi.service.UserService;

@Controller
public class DeptController {
	@Autowired
	@Qualifier("admin_login")
	private UserService user;	
	
	@Autowired
	@Qualifier("admin_logina")
	private AdminLoginService als;
	
	//登录
	@RequestMapping("login")
	public String findAll(Model m, HttpSession session,User u) throws Exception{	
		RSAUtils rsa = new RSAUtils();
		// 生成公钥和密钥
		Map<String, Object> keyMap = rsa.createKey();
		RSAPublicKey publicKey = (RSAPublicKey) keyMap.get("publicKey");
		RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get("privateKey");
		// js通过模和公钥指数获取公钥对字符串进行加密，注意必须转为16进制
		// 模
		String Modulus = publicKey.getModulus().toString();
		// 公钥指数
		String public_exponent = publicKey.getPublicExponent().toString(16);
		// 私钥指数
		String private_exponent = privateKey.getPrivateExponent().toString();
		RSAPrivateKey prkey = RSAUtils.getPrivateKey(Modulus, private_exponent);
		m.addAttribute("Modulus", publicKey.getModulus().toString(16));
		m.addAttribute("public_exponent", public_exponent);
		session.setAttribute("prkey", prkey);
		return "/login";
	}
	
	@RequestMapping("registration")
	public String registration(Model m) {
		List<Batch> b=user.SelectByBatch();
		m.addAttribute("Batch", b);
		return "/registration";
		
	}
	
	@RequestMapping("index")
	public String login(User u,Model aa,HttpSession session) throws Exception {

		User a=user.selectBylogin(u.getName(), u.getPassword());
		session.setAttribute("admin", u.getName());
		InetAddress ia=null;
		ia=ia.getLocalHost();
		String ip=ia.getHostAddress();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		java.util.Date date=new java.util.Date();
		String time=sdf.format(date);
		if(a==null) {
			aa.addAttribute("failure", "账号或密码不正确");
			return "/login";
		}else {
			als.InsertLoginAdmin(ip, u.getName(), time);
			return "redirect:indexa";
		}
	}
	//主页面
	@RequestMapping("indexa")
	public String logina(HttpSession session) {
		String admin = (String) session.getAttribute("admin");
		
		String password = (String) session.getAttribute("password");
		System.out.println("登录账号:"+admin);
			return "/index";
	}
	
	//注册加密
	@RequestMapping("registrationAdmin")
	public void registrationAdmin(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("phone")String phone,Model aa,HttpSession session,@RequestParam("name")String name,
			HttpServletResponse response) throws Exception {	
			RSAUtils rsa = new RSAUtils();
			RSAPrivateKey prkey = (RSAPrivateKey) session.getAttribute("prkey");
			String pwd = rsa.decrypttoStr(prkey, password);
			String pd = new StringBuffer(pwd).reverse().toString();
			// MD5加密
			String md5pwd = MD5tool.EncoderByMd5(pd);
			System.out.println(md5pwd);
			int ok = -1;
			int number = -1;
			number = user.insertid(username, md5pwd, phone, name);
			if(number>0){
				ok=1;
			}else{
				ok=0;
			}
			PrintWriter out = response.getWriter();
			out.print(ok);
	}
	
	
	@RequestMapping("/del")  
	public void batchDeletes(HttpServletRequest request, HttpServletResponse response) {  
	    String items = request.getParameter("delitems");// System.out.println(items);  
	    String[] strs = items.split(",");  
	  
	    for (int i = 0; i < strs.length; i++) {  
	        try {  
	            System.out.println(strs[i]);
	        } catch (Exception e) {  
	        	
	        }  
	    }  
	}
	
	
	//注册用户
	@RequestMapping("AddUsers")
	public void AddUsers(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("phone")String phone,@RequestParam("name")String name,
			HttpSession session,HttpServletResponse response) throws IOException {
		int ok = -1;
		int number = -1;
		number = user.insertid(username, password, phone, name);
		if(number>0){
			ok=1;
		}else{
			ok=0;
		}
		PrintWriter out = response.getWriter();
		out.print(ok);
	}
}
