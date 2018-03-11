package com.yuyi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yuyi.model.Car;
import com.yuyi.model.jiashiyuan;
import com.yuyi.service.JiaShiYuanService;

/**
 * <P>Title: JSYController</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年3月5日下午3:02:25
 * 
 */
@Controller
public class JSYController {
	
	
	@Autowired
	@Qualifier("admin_jiashiyuan")
	private JiaShiYuanService jsy;
	
	
	//驾驶员信息展示页面
	@RequestMapping("pilot")
	public String pilot(Model m) {
		List<jiashiyuan> js=jsy.SeleceJiaShiYuan();
		m.addAttribute("js", js);
		List<Car> car_number_ok = jsy.Select_Car_Number();
		m.addAttribute("car_number_ok", car_number_ok);
		return "/pilot";
		
	}
	
	/*//添加驾驶员信息 加载车牌号列表
	@RequestMapping("pilot")
	public String select_Car_Number(Model m,HttpServletResponse response) throws IOException{
		PrintWriter out= response.getWriter();
		String car_number_ok = jsy.Select_Car_Number();
		
		return "/pilot";
	}*/
	
	
}
