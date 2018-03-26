package com.xiaofeixia.sj.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecanal_mail.tools.ErrorUtil;
import com.xiaofeixia.sj.model.Car;
import com.xiaofeixia.sj.model.Part;
import com.xiaofeixia.sj.model.Unit;
import com.xiaofeixia.sj.model.jiashiyuan;
import com.xiaofeixia.sj.model.Car_Repair;
import com.xiaofeixia.sj.service.CarService;
import com.xiaofeixia.sj.service.ErrorService;
import com.xiaofeixia.sj.service.JiaShiYuanService;
import com.xiaofeixia.sj.service.UnitService;

import net.sf.json.JSONArray;

@Controller
public class CarController {
	@Autowired
	@Qualifier("car")
	private CarService car;
	//获取驾驶员service
	@Autowired
	@Qualifier("admin_jiashiyuan")
	private JiaShiYuanService driver;

	 //引入捕获异常转换字符串的util
	ErrorUtil errorUtil = new ErrorUtil();
	//获取存储异常的service层
	@Autowired
	@Qualifier("ErrorService")
	private ErrorService errorService;
	
	//引入单位service
	@Autowired
	@Qualifier("UnitService")
	private UnitService unitService;
	
	/**
	 * @param car_id 
	 * @param car_name
	 * @param car_number
	 * @param car_drivet
	 * @param car_unit
	 * @param response
	 * 车辆条件查询
	 */
	@RequestMapping("Comprehensive_Search")
	public String Comprehensive_Search (@RequestParam("car_id")String car_id,@RequestParam("car_name")String car_name,
			@RequestParam("car_number")String car_number,@RequestParam("car_driver")String car_drivet,
			@RequestParam("car_unit")String car_unit,Model m) {
		try {
			System.out.println("进入车辆信息多条件查询 查询内容如下");
			Car car1 = new Car();
			car1.setCar_id(car_id);
			car1.setCar_name(car_name);
			car1.setCar_number(car_number);
			car1.setCar_driver(car_drivet);
			car1.setCar_unit(car_unit);
			List<Car> select_car = car.Select_Synthesis_Car(car1);
			m.addAttribute("select_car", select_car);
		} catch (Exception e) {
		    errorService.InsertError(errorUtil.getError(e));
		}
		return "/select_car";
	}
	
/*	//条件查询的答案
	@RequestMapping("select_car")
	public String SelectCar() {
	    return "/select_car";
	}*/
	//跳转到车辆信息页面
		@RequestMapping("carcontent")
		public String catContent(Model m){
			//查询车辆信息,进行分页展示
				try {
				    	List<Car> selectCar = car.selectCar();//查询车辆
				    	List<jiashiyuan> js = driver.SeleceJiaShiYuan();  //查询驾驶员
				    	List<Unit> unit  = unitService.SelectUnit();
				    	m.addAttribute("js",js);
				    	m.addAttribute("unit",unit);
					m.addAttribute("selectCar",selectCar);
				} catch (Exception e) {
				    errorService.InsertError(errorUtil.getError(e));
				}
				return "/carcontent";
		}
	
	/**
	 * 
	 * @param m
	 * @return String
	 */
	//跳转添加车辆页面
	@RequestMapping("addcarcontent")
	public String AddcarContent(Model m){
		List<jiashiyuan> js = car.SelectJs();
		List<Unit> car_unit = car.SelectUnit();
		m.addAttribute("js", js);
		m.addAttribute("car_unit", car_unit);
		return "/addcarcontent";
	}
	
	/**
	 * 
	 * @param car_number
	 * @param response
	 * @throws IOException
	 */
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
	/**
	 * @param vins
	 * @param response
	 * @throws Exception
	 */
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
		/**
		 * @param carname
		 * @param carlength
		 * @param carvin
		 * @param carnumber
		 * @param cardrivers
		 * @param unit
		 * @param session
		 * @param response
		 */
		@RequestMapping("addcar")
		public void addcar(@RequestParam("carname")String carname,
				@RequestParam("carlength")String carlength,@RequestParam("carvin")String carvin,
				@RequestParam("carnumber")String carnumber,@RequestParam("cardrivers") String cardrivers,@RequestParam("unit")String unit,
			HttpSession session,HttpServletResponse response) {
			try {
				System.out.println("进入caradd的controller类");
				PrintWriter out = response.getWriter();
				int a  = car.insertcar(carname,carlength,carvin,carnumber,cardrivers,unit);
				System.out.println("添加车辆是否成功 :"+a);
				out.print(a);
			} catch (Exception e) {
			    errorService.InsertError(errorUtil.getError(e));
			}
		}
		
		
		
		//删除车辆信息
		/**
		 * @param car_id
		 * @param response
		 * @throws IOException
		 */
		@RequestMapping("car_delectxinxi")
		public void car_delect (@RequestParam("car_iddel") String car_id,HttpServletResponse response){
			try {
			    int delect_ok = car.CarDelect(car_id);
				System.out.println("进入了删除车辆信息controller");
				PrintWriter out = response.getWriter();
				out.print(delect_ok);
			} catch (Exception e) {
			    errorService.InsertError(errorUtil.getError(e));
			}
		}
		
		
		
		/**
		 * @param m
		 * @param car_id
		 * @param response
		 * @param session
		 * @throws IOException
		 */
		//先查询修改的车辆信息,把车辆信息带到修改页面
		@RequestMapping("select_car")
		public void select_car(Model m,@RequestParam("car_id")String car_id,HttpServletResponse response,HttpSession session){
			try {
			  //往后台传输json数据时格式为utf-8
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				List<Car> list = new ArrayList<Car>();
				Car carmodel = car.selectCar(car_id);
				list.add(carmodel);
				JSONArray jsonArray = JSONArray.fromObject( list );
				System.out.println("把修改车辆信息的车辆信息带到修改页面"+jsonArray);
				String json = jsonArray.toString();
				List<jiashiyuan> js = car.SelectJs();
				List<Unit> car_unit = car.SelectUnit();
				m.addAttribute("js", js);
				m.addAttribute("car_unit", car_unit);
				m.addAttribute("js", js);
			 	m.addAttribute("car_unit", car_unit);
				out.print(json);
			} catch (Exception e) {
			    errorService.InsertError(errorUtil.getError(e));
			}
		}
		
		/**
		 * @param car_vins
		 * @param car_numbers
		 * @param car_units
		 * @param car_drivers
		 * @param response
		 * @throws Exception
		 */
		//车辆信息修改点击提交
		@RequestMapping("modify")
		public void car_modify(@RequestParam("car_vins")String car_vins,@RequestParam("car_numbers")String car_numbers,
				@RequestParam("car_units")String car_units,@RequestParam("car_drivers")String car_drivers
				,HttpServletResponse response){
		    try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			int updata_ok = car.updateCar(car_vins,car_numbers,car_units,car_drivers);
			System.out.println("车架号 : "+car_vins+"--------车牌号 : "+car_numbers+"--------所属驾驶员 : "+car_drivers+"--------所属公司 : "+car_units);
			System.out.println("修改车辆信息页面"+updata_ok);
			out.print(updata_ok);
		    } catch (Exception e) {
			 errorService.InsertError(errorUtil.getError(e));
		    }
				
			
		}
		
/*
 * 车辆维修菜单
 * 2018.3.9
 * */
		//进入车辆维修页面
		/**
		 * @return String
		 */
		@RequestMapping("user")
		public String Autorepair(){
			return "/user";
		}
		
		
		
		
		//跳转车辆维修信息并且把车辆信息查询出来
		/**
		 * @param m
		 * @return String
		 * @throws IOException
		 */
		@RequestMapping("car_repair")
		public String Car_Repair(Model m) {
			try {
			    List<Car_Repair> Car_Repair = car.Select_Repair();
			    List<Part> bj = car.SlectPartName();
			   List<Car> car_number  = car.selectCar();
			    m.addAttribute("wx", Car_Repair);
			    m.addAttribute("bj", bj);
			    m.addAttribute("car", car_number);
				
				
			} catch (Exception e) {
			    errorService.InsertError(errorUtil.getError(e));
			}
		return "/carrepair";
		}
		
		//添加部件
		@RequestMapping("addpart")
		public String AddPart(){
			return "/addpart";
		}
		//添加部件ajax
		/**
		 * @param part_name
		 * @param response
		 */
		@RequestMapping("addadd")
		public void addadd(@RequestParam("part_name")String part_name,HttpServletResponse response) {
			try {
				PrintWriter out = response.getWriter();
				int ok = car.InsertPart(part_name);
				out.print(ok);
			} catch (Exception e) { //如果有异常就把异常信息插入到异常表中
			    errorService.InsertError(errorUtil.getError(e));
			}
		}
		
		//跳转车辆维修记录页面
		@RequestMapping("addcarrepair")
		public String AddCarRepair(Model m) {
		    System.out.println("跳转车辆维修记录页面");
		    List<Car> car_number = car.selectCar();
		    List<Part> part = car.SlectPartName();
		    m.addAttribute("car", car_number);
		    m.addAttribute("part", part);
		    return "/addcarrepair";
		}
		
		
		//添加车辆维修记录页面
		@RequestMapping("addrepair")
		public void AddRepair(@RequestParam("car_number")String car_number,@RequestParam("repair_address")String repair_address,
			@RequestParam("repair_part")String repair_part,@RequestParam("unit_price")String unit_price,HttpServletResponse response) throws IOException {
			System.out.println("正在添加车辆维修记录");
			int Insert_ok = car.InsertRepair(car_number,repair_address,repair_part,unit_price);
			System.out.println("添加车辆维修记录是否成功 :  - - >"+Insert_ok);
			PrintWriter out = response.getWriter();
			out.print(Insert_ok);
		}
		
		//添加驾驶员信息页面
		/**
		 * @param m
		 * @return
		 */
		@RequestMapping("adddriver")
		public String AddDriver(Model m) {
			try {
			  //查询车牌号
				List<Car> js = driver.Select_Car_Number();
				m.addAttribute("js", js);
			} catch (Exception e) {
			    errorService.InsertError(errorUtil.getError(e));
			}
			return "/adddriver";
		}
		
}
