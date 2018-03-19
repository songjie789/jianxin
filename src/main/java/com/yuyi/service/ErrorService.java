package com.yuyi.service;

import java.util.List;

import com.yuyi.model.Error;

public interface ErrorService {
	
	//插入異常信息
	int InsertError(String error_message);

	List<Error> SelectError();
}
