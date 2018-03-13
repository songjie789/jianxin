package com.yuyi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuyi.dao.CarDao;
import com.yuyi.model.Car;
import com.yuyi.service.CarService;


@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("car")
public class CarServiceImpl implements CarService{
	@Autowired()
	private CarDao car;
	
	//添加车辆之前查询车牌号是否存在
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
		// TODO Auto-generated method stub
		return  car.Select_Synthesis_Car(car1);
	}
}
