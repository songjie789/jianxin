package com.xiaofeixia.sj.service;

import java.util.List;


import com.xiaofeixia.sj.model.SecondMenu;

public interface SecondService {
	
	List<SecondMenu> SelectByid();
	
	int InsertFirset(Integer id,String name,String address);
}
