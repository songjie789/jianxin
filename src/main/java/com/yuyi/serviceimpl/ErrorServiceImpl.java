package com.yuyi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuyi.dao.ErrorDao;
import com.yuyi.model.Error;
import com.yuyi.service.ErrorService;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("ErrorService")
public class ErrorServiceImpl implements ErrorService {
	@Autowired
	private ErrorDao error;
	//插入錯誤信息
	@Override
	public int  InsertError(String error_message) {
		return error.InsertError(error_message);
	}
	
	
	
	//查询已存在的异常信息
	@Override
	public List<Error> SelectError() {
		return error.SelectError();
	}

}
