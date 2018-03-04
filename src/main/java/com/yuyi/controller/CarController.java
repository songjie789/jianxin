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

import com.yuyi.model.Car;
import com.yuyi.service.CarService;

@Controller
public class CarController {
	@Autowired
	@Qualifier("car")
	private CarService car;
	//添加车辆信息
		@RequestMapping("addcar")
		public void addcar(@RequestParam("carname")String carname,
				@RequestParam("carlength")String carlength,@RequestParam("carvin")String carvin,
				@RequestParam("carnumber")String carnumber,@RequestParam("cardrivers") String cardrivers,@RequestParam("unit")String unit,
			HttpSession session,HttpServletResponse response) throws IOException{
			System.out.println("进入caradd的controller类");
			PrintWriter out = response.getWriter();
			int a  = car.insertcar(carname,carlength,carvin,carnumber,cardrivers,unit);
			out.print(a);
		}
		
		
}
