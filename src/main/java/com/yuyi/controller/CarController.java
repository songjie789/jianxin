package com.yuyi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.SQL;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.log.SysoCounter;
import com.yuyi.model.Car;
import com.yuyi.service.CarService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

@Controller
public class CarController {
	@Autowired
	@Qualifier("car")
	private CarService car;
	
	
	//车辆条件查询
	@RequestMapping("search")
	public void search (@RequestParam("car_id")String car_id,@RequestParam("car_name")String car_name,
			@RequestParam("car_number")String car_number,@RequestParam("car_driver")String car_drivet,
			@RequestParam("car_unit")String car_unit,HttpServletResponse response) throws IOException{
		PrintWriter out= response.getWriter();
		Car car1 = new Car();
		car1.setCar_id(car_id);
		car1.setCar_name(car_name);
		car1.setCar_number(car_number);
		car1.setCar_driver(car_drivet);
		car1.setCar_unit(car_unit);
		
		List<Car> select_car = car.Select_Synthesis_Car(car1);
		if(select_car!=null) 
			System.out.println("条件查询"+select_car);
		if(select_car==null)
			System.out.println("条件查询"+select_car);
		out.print(select_car);
	}
	
	
	//添加车辆先先查询车牌号是否存在
		@RequestMapping("select_carnumber")
		public void select_carnumber (@RequestParam("car_number")String car_number,HttpServletResponse response) throws IOException{
			PrintWriter out= response.getWriter();
			String select_ok = car.electcarNumber(car_number);
			int ok = 0;
			if(select_ok!=null){
				ok = 1;
			}
			out.print(ok);
		}
	
	//添加车辆先先查询VIN是否存在
	@RequestMapping("select_vin")
	public void select_vin(@RequestParam("vins")String vins,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		Object select_ok = car.SelectVin(vins);
		System.out.println("进入判断vin是否存在controller" +select_ok);
		int ok = 0;
		if(select_ok!=null){
			ok = 1;
		}
		out.print(ok);
	}
	//添加车辆信息
		@RequestMapping("addcar")
		public void addcar(@RequestParam("carname")String carname,
				@RequestParam("carlength")String carlength,@RequestParam("carvin")String carvin,
				@RequestParam("carnumber")String carnumber,@RequestParam("cardrivers") String cardrivers,@RequestParam("unit")String unit,
			HttpSession session,HttpServletResponse response) throws IOException{
			System.out.println("进入caradd的controller类");
			PrintWriter out = response.getWriter();
			int a  = car.insertcar(carname,carlength,carvin,carnumber,cardrivers,unit);
			System.out.println("添加车辆是否成功 :"+a);
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
		public void select_car(Model m,@RequestParam("car_id")String car_id,HttpServletResponse response,HttpSession session) throws IOException{
			//往后台传输json数据时格式为utf-8
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			List<Car> list = new ArrayList<Car>();
			Car carmodel = car.selectCar(car_id);
			list.add(carmodel);
			JSONArray jsonArray = JSONArray.fromObject( list );
			System.out.println("把修改车辆信息的车辆信息带到修改页面"+jsonArray);
			String json = jsonArray.toString();
			out.print(json);
		}
		
		//车辆信息修改点击提交
		@RequestMapping("modify")
		public void car_modify(@RequestParam("car_vins")String car_vins,@RequestParam("car_numbers")String car_numbers,
				@RequestParam("car_units")String car_units,@RequestParam("car_drivers")String car_drivers
				,HttpServletResponse response) throws Exception{
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				int updata_ok = car.updateCar(car_vins,car_numbers,car_units,car_drivers);
				System.out.println("车架号 : "+car_vins+"--------车牌号 : "+car_numbers+"--------所属驾驶员 : "+car_drivers+"--------所属公司 : "+car_units);
				System.out.println("修改车辆信息页面"+updata_ok);
				out.print(updata_ok);
			
		}
		
/*
 * 车辆维修菜单
 * 2018.3.9
 * */
		//进入车辆维修页面
		@RequestMapping("user")
		public String Autorepair(){
			return "/user";
		}
		
		//输入车辆编号进行添加
		
		
}
