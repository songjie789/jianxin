package com.yuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuyi.model.Error;
import com.yuyi.service.ErrorService;

@Controller
public class ErrorController {
	@Autowired
	@Qualifier("ErrorService")
	private ErrorService errorservice;
	
	//跳转error异常页面
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("adderror")
	public String adderror(Model m){
		List<Error> error_ok = errorservice.SelectError();
		m.addAttribute("error", error_ok);
		return "/adderror";
	}
}
