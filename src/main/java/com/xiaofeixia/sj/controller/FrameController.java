package com.xiaofeixia.sj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecanal_mail.tools.ErrorUtil;
import com.xiaofeixia.sj.model.Car;
import com.xiaofeixia.sj.model.FirstMenu;
import com.xiaofeixia.sj.model.SecondMenu;
import com.xiaofeixia.sj.model.loginAdmin;
import com.xiaofeixia.sj.service.AdminLoginService;
import com.xiaofeixia.sj.service.CarService;
import com.xiaofeixia.sj.service.ErrorService;
import com.xiaofeixia.sj.service.FirstMenuService;
import com.xiaofeixia.sj.service.SecondService;

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
	
	@Autowired
	@Qualifier("car")
	private CarService car;
	
	//引入捕获异常转换字符串的util
	ErrorUtil errorUtil = new ErrorUtil();
	//获取存储异常的service层
	@Autowired
	@Qualifier("ErrorService")
	private ErrorService errorService;
	//主体
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("main")
	public String main(Model m ) {
		try {
		    List<loginAdmin> arg = als.SelectLoginAdmin();
			System.out.println("加载完成");
			m.addAttribute("AdminLogin", arg);
			
		} catch (Exception e) {
		    errorService.InsertError(errorUtil.getError(e));
		}
		return "/main";
		
	}

	//上层
	/**
	 * @param session
	 * @param m
	 * @return
	 */
	@RequestMapping("head")
	public String head(HttpSession session,Model m) {
		
		try {
		    String admin = (String)session.getAttribute("admin");
			System.out.println(admin);
			m.addAttribute("admin", admin);
		} catch (Exception e) {
		    errorService.InsertError(errorUtil.getError(e));
		}
		return "/head";
	}
	//左侧
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("left")
	public String left(Model m) {
		try {
		    List<FirstMenu> one=first.selectBy();
			List<SecondMenu> two=second.SelectByid();
			m.addAttribute("second",two);	
			m.addAttribute("first", one);
		} catch (Exception e) {
		    errorService.InsertError(errorUtil.getError(e));
		}
		return "/left";
	}
	//跳进一级管理
	/**
	 * @return String
	 */
	@RequestMapping("onemenu")
	public String Onemenu() {
		return "/onemenu";
		
	}
	//跳进二级菜单
	@RequestMapping("twomenu")
	public String Twomenu(Model m) {
		try {
		    List<FirstMenu> one=first.selectBy();
			m.addAttribute("first", one);
		} catch (Exception e) {
		    errorService.InsertError(errorUtil.getError(e));
		}
		return "/twomenu";
	}
	//修改密码
	@RequestMapping("changepwd")
	public String changepwd() {
		return "/changepwd";
		
	}
	//添加用户
	@RequestMapping("changepwda")
	public String changepwda() {
		
		return "/changepwda";
		
	}
}
