package com.yuyi.service;

import java.util.List;


import com.yuyi.model.SecondMenu;

public interface SecondService {
	
	List<SecondMenu> SelectByid();
	
	int InsertFirset(Integer id,String name,String address);
}
