package com.xiaofeixia.sj.controller;

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
import com.xiaofeixia.sj.model.Unit;
import com.xiaofeixia.sj.service.ErrorService;
import com.xiaofeixia.sj.service.UnitService;

/**
 ** 
 *  @Organization：小飞侠
 *  @time  2018年3月23日下午9:15:13  
 *  @author   SongJie
 *  相关说明 : 
 *user/ addcar
 * car/addcar
 */
@Controller
public class UnitController {
    
    //引用unitservice
    @Autowired
    @Qualifier("UnitService")
    private UnitService unitService;
    
    //获取异常信息util
    ErrorUtil errorUtil = new ErrorUtil();

    //获取ErrorServic做插入异常信息
    @Autowired
    @Qualifier("ErrorService")
    private ErrorService errorService;
    
    
    //跳转
    @RequestMapping("addunit")
    public String AddUnit() {
	return "/addunit";
    }
    
    //插入公司
    @RequestMapping("addunits")
    public void AddUnits(@RequestParam("unit_name")String unit_name,
	    @RequestParam("unit_address")String unit_address,@RequestParam("unit_contact")String unit_contact,
	    @RequestParam("unit_phone")String unit_phone,HttpServletResponse response) throws Exception {
	try {
	    	System.out.println("addunit界面"+unit_name+unit_address);
	    	int Insert_ok = unitService.InsertUnit(unit_name,unit_address,unit_contact,unit_phone);
	    	PrintWriter out= response.getWriter();
	    	out.print(Insert_ok);
	} catch (Exception e) {
	    errorService.InsertError(errorUtil.getError(e));
	}
    }
    
    //查询单位信息
    @RequestMapping("SelectUnit")
    public String SelectUnit(Model m) {
	try {
	    	List<Unit> unit = unitService.SelectUnit();
	    	m.addAttribute("unit", unit);
	} catch (Exception e) {
	   errorService.InsertError(errorUtil.getError(e));
	}
	return "/unit";
    }
    
    

}
