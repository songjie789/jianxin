package com.yuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//
	@RequestMapping("pilot")
	public String pilot(Model m) {
		List<jiashiyuan> js=jsy.SeleceJiaShiYuan();
		m.addAttribute("js", js);
		
		return "/pilot";
		
	}
	
	
}
