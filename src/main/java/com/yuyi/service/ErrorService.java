package com.yuyi.service;

import java.util.List;

import com.yuyi.model.Error;

public interface ErrorService {
	
	//插入异常信息
	int InsertError(String error_message);
	//查询异常信息
	List<Error> SelectError();
}
