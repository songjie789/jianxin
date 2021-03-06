package com.xiaofeixia.sj.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaofeixia.sj.dao.CarDao;
import com.xiaofeixia.sj.model.Car;
import com.xiaofeixia.sj.model.Car_Repair;
import com.xiaofeixia.sj.model.Part;
import com.xiaofeixia.sj.model.Unit;
import com.xiaofeixia.sj.model.jiashiyuan;
import com.xiaofeixia.sj.service.CarService;


@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("car")
public class CarServiceImpl implements CarService{
	@Autowired()
	private CarDao car;
	
	//添加车辆之前查询车牌号是否存在
	/* (non-Javadoc)
	 * @see com.xiaofeixia.sj.service.CarService#electcarNumber(java.lang.String)
	 */
	@Override
	public String electcarNumber(String car_number) {
		return car.SelectCar_Number(car_number);
	}
	//添加车辆之前查询VIN是否存在
	@Override
	public String SelectVin(String vins) {
		return car.selectvin(vins);
	}
	//插入车辆信息
	/* (non-Javadoc)
	 * @see com.xiaofeixia.sj.service.CarService#insertcar(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int insertcar(String carname, String carlength, String carvin,String carnumber, String cardrivers, String unit) {
		return car.insertcat(carname,carlength,carvin,carnumber,cardrivers,unit);
	}
	
	//查询车辆信息,进行分页展示
	public List<Car> selectCar(){
		return car.selectCar();
		
	}
	
	
	//删除车辆信息
	@Override
	public int CarDelect(String car_id) {
		return car.carDelect(car_id);
	}
	
	
	//先查询修改的车辆信息,把车辆信息带到修改页面
	@Override
	public Car selectCar(String car_id) {
		return car.select_car(car_id);
	}
	//修改车辆信息 一VIN为where条件
	@Override
	public int updateCar(String car_vins, String car_numbers, String car_units, String car_drivers) {
		return car.updatecar(car_vins, car_drivers, car_numbers, car_units);
	}
	
	//条件查询
	@Override
	public List<Car> Select_Synthesis_Car(Car car1) {
		return  car.Select_Synthesis_Car(car1);
	}
	
	//车辆维修信息查询
	@Override
	public List<Car_Repair> Select_Repair() {
		return car.Select_repair();
	}
	
	//车辆维修>>添加部件
	@Override
	public int Add_Repair(String part_name) {
		return car.Add_Repair(part_name);
	}
	@Override
	public List<Part> SlectPartName() {
		return car.SlectPartName();
	}
	@Override
	public List<jiashiyuan> SelectJs() {
		return car.SelectJs();
	}
	
	//查询快递公司放在添加车辆信息页面
	@Override
	public List<Unit> SelectUnit() {
		return car.SelectUnit();
	}
	
	//添加部件
	@Override
	public int InsertPart(String part_name) {
		return car.InsertPart(part_name);
	}
	/* (Javadoc)
	 * @see com.yuyi.service.CarService#InsertRepair(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 *2018年3月25日下午9:31:02
	 *添加车辆维修记录
	 */
	@Override
	public int InsertRepair(String car_number, String repair_address, String repair_part, String unit_price) {
	    return car.InsertRepair(car_number,repair_address,repair_part,unit_price);
	}
}
