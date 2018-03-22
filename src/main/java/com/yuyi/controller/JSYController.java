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

import com.ecanal_mail.tools.ErrorUtil;
import com.yuyi.model.Car;
import com.yuyi.model.jiashiyuan;
import com.yuyi.service.ErrorService;
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
    //引入捕获异常转换字符串的util
	ErrorUtil errorUtil = new ErrorUtil();
	//获取存储异常的service层
	@Autowired
	@Qualifier("ErrorService")
	private ErrorService errorService;
	@Autowired
	@Qualifier("admin_jiashiyuan")
	private JiaShiYuanService jsy;
	

	
	//驾驶员信息展示页面并把车牌号传到前端页面的下拉列表中
	/**
	 * @param m
	 * @return String
	 */
	@RequestMapping("pilot")
	public String pilot(Model m) {
		try {
		    List<jiashiyuan> js=jsy.SeleceJiaShiYuan();
			m.addAttribute("js", js);
			List<Car> car_number_ok = jsy.Select_Car_Number();
			m.addAttribute("car_number_ok", car_number_ok);
		} catch (Exception e) {
    		   errorService.InsertError(errorUtil.getError(e));
		}
		return "/pilot";
		
	}
	
	//添加驾驶员信息
	/**
	 * @param driver_name
	 * @param driver_car_number
	 * @param driver_address
	 * @param driver_phone
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("add_drivers")
	public void AddDrivers(@RequestParam("driver_name")String driver_name,@RequestParam("driver_car_number")String driver_car_number,
			@RequestParam("driver_address")String driver_address,@RequestParam("driver_phone")String driver_phone,
			HttpServletResponse response){
			try {
			    System.out.println("驾驶员姓名 : "+driver_name+"------车牌号 : "+driver_car_number+"-----------住址 : "+driver_address+"-------------电话 : "+driver_phone);
				int add_ok = jsy.Add_Driver(driver_name,driver_car_number,driver_address,driver_phone);
				PrintWriter out = response.getWriter();
				System.out.println(add_ok);
				out.print(add_ok);
			} catch (Exception e) {
			    errorService.InsertError(errorUtil.getError(e));
			}
	}
	
}
