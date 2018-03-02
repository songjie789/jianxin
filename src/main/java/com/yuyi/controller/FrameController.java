package com.yuyi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuyi.model.FirstMenu;
import com.yuyi.model.SecondMenu;
import com.yuyi.model.loginAdmin;
import com.yuyi.service.AdminLoginService;
import com.yuyi.service.FirstMenuService;
import com.yuyi.service.SecondService;
import com.yuyi.util.GetTime;
import com.yuyi.util.getIP;

/**
 * <P>Title: FrameController</p>
 * <p>Description:框架层</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年1月31日下午4:24:00
 * 
 */

@Controller
public class FrameController {
	@Autowired
	@Qualifier("admin_onemenu")
	private FirstMenuService first;
	
	@Autowired
	@Qualifier("admin_second")
	private SecondService second;
	
	@Autowired
	@Qualifier("admin_logina")
	private AdminLoginService als;
	
	//主体
	@RequestMapping("main")
	public String main(Model m ) {
		List<loginAdmin> arg = als.SelectLoginAdmin();
		System.out.println("加载完成");
		m.addAttribute("AdminLogin", arg);
		return "/main";
		
		
	}

	//上层
	@RequestMapping("head")
	public String head(HttpSession session,Model m) {
		String admin = (String)session.getAttribute("admin");
		m.addAttribute("admin", admin);
		return "/head";
		
	}
	//左侧
	@RequestMapping("left")
	public String left(Model m) {
		List<FirstMenu> one=first.selectBy();
		List<SecondMenu> two=second.SelectByid();
		m.addAttribute("second",two);	
		m.addAttribute("first", one);
		return "/left";
		
	}
	//跳进一级管理
	@RequestMapping("onemenu")
	public String Onemenu() {
		return "/onemenu";
		
	}
	//跳进二级菜单
	@RequestMapping("twomenu")
	public String Twomenu(Model m) {
		List<FirstMenu> one=first.selectBy();
		m.addAttribute("first", one);
		return "/twomenu";
		
	}
	//修改密码
	@RequestMapping("changepwd")
	public String changepwd() {
		return "/changepwd";
		
	}
	//测试
	@RequestMapping("test")
	public String Test(Model m) {
		List<SecondMenu> two=second.SelectByid();
		m.addAttribute("second",two);
		return "/registration";
		
	}
	//添加用户
	@RequestMapping("changepwda")
	public String changepwda() {
		
		return "/changepwda";
		
	}
	
}
