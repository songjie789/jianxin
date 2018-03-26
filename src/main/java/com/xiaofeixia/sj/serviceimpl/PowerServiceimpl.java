package com.xiaofeixia.sj.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaofeixia.sj.dao.PowerDao;
import com.xiaofeixia.sj.model.User;
import com.xiaofeixia.sj.service.PowerService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("admin_power")

public class PowerServiceimpl implements PowerService{

	@Autowired
	private PowerDao Pd;
	
	@Override
	public List<User> ByUser() {
		// TODO Auto-generated method stub
		return Pd.ByUser();
	}

	@Override
	public int UpdateMima(String password, Integer id) {
		// TODO Auto-generated method stub
		return Pd.UpdateMima(password, id);
	}

	@Override
	public User SelectZhuang(Integer id) {
		// TODO Auto-generated method stub
		return Pd.SelectZhuang(id);
	}

	@Override
	public int UpdateZhuang(String supera, Integer id) {
		// TODO Auto-generated method stub
		return Pd.UpdateZhuang(supera, id);
	}

}
