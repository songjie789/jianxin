package com.yuyi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuyi.model.User;
import com.yuyi.service.PowerService;

@Controller
public class PowerController {
	
	@Autowired
	@Qualifier("admin_power")
	private PowerService ps;
	
	//跳转管理员页面
	@RequestMapping("power")
	public String Power(Model m) {
		List<User> use= ps.ByUser();
		m.addAttribute("user", use);
		return "/power";
		
	}
	
	//修改密码
	@RequestMapping("mima")
	public void mima(HttpServletResponse response,@RequestParam("id")Integer id) throws IOException {
		int ok = -1;
		int number = -1;
		number = ps.UpdateMima("4297F44B13955235245B2497399D7A93", id);
		
		if(number>0){
			ok=1;
		}else{
			ok=0;
		}
		PrintWriter out = response.getWriter();	
		System.out.println(ok);
		out.print(ok);
	}
	//修改管理员状态
	@RequestMapping("UpdateZhuangTai")
	public void UpdateZhuangTai(HttpServletResponse response
			,@RequestParam("id")Integer id) throws IOException {
		int ok = -1;
		int number = -1;
		User u = ps.SelectZhuang(id);
		if (u.getSupera().equals("正常")) {
			number = ps.UpdateZhuang("禁用", id);
		}else {
			number = ps.UpdateZhuang("正常", id);
		}		
		if(number>0){
			ok=1;
		}else{
			ok=0;
		}
		PrintWriter out = response.getWriter();	
		System.out.println(ok);
		out.print(ok);
	}
	//退出
	@RequestMapping("adminout")
	public String tuichu(HttpSession session) {
		session.removeAttribute("admin");
		String u=(String)session.getAttribute("admin");
		System.out.println("退出+"+u);
		return "/login";
		
	}
	
}
