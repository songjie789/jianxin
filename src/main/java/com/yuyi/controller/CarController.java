package com.yuyi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.log.SysoCounter;
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
		
		
		
		//删除车辆信息
		@RequestMapping("car_delectxinxi")
		public void car_delect (@RequestParam("car_iddel") String car_id,HttpServletResponse response) throws IOException{
			int delect_ok = car.CarDelect(car_id);
			System.out.println("进入了删除车辆信息controller");
			PrintWriter out = response.getWriter();
			out.print(delect_ok);
		}
		
		
		//先查询修改的车辆信息,把车辆信息带到修改页面
		@RequestMapping("select_car")
		public void select_car(Model m,@RequestParam("car_id")String car_id,HttpServletResponse response) throws IOException{
			PrintWriter out = response.getWriter();
			Car carmodel = car.selectCar(car_id);
			System.out.println("修改车辆信息"+carmodel);
			out.print(carmodel);
		}
		
}
