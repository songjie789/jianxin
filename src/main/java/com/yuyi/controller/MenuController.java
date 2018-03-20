package com.yuyi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuyi.service.FirstMenuService;
import com.yuyi.service.SecondService;

/**
 * <P>Title: MenuController</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月1日下午2:29:23
 * 
 */
@Controller
public class MenuController {
	@Autowired
	@Qualifier("admin_onemenu")
	private FirstMenuService first;
	
	@Autowired
	@Qualifier("admin_second")
	private SecondService second;
	
	//增加一级菜单
	/**
	 * @param name
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("addonefirst")
	public void AddOneFirst(@RequestParam("name")String name,
				HttpServletResponse response) throws IOException {
		int ok = -1;
		int number = -1;
		number = first.insertFirst(name, "img/coin10.png");
		if(number>0){
			ok=1;
		}else{
			ok=0;
		}
		PrintWriter out = response.getWriter();
		out.print(ok);
	}
	
	//增加二级菜单
	/**
	 * @param name
	 * @param address
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("addtwomenu")
	public void AddTwoMenu(@RequestParam("name")String name,
			@RequestParam("address")String address,@RequestParam("id")int id,
			HttpServletResponse response) throws IOException {
		int ok = -1;
		int number = -1;
		number = second.InsertFirset(id, name, address);
		if(number>0){
			ok=1;
		}else{
			ok=0;
		}
		PrintWriter out = response.getWriter();
		out.print(ok);
	}
	
}
