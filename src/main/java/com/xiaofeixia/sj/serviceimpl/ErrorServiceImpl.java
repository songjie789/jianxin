package com.xiaofeixia.sj.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaofeixia.sj.dao.ErrorDao;
import com.xiaofeixia.sj.model.Error;
import com.xiaofeixia.sj.service.ErrorService;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("ErrorService")
public class ErrorServiceImpl implements ErrorService {
	@Autowired
	private ErrorDao error;
	//插入错误信息
	/* (non-Javadoc)
	 * @see com.xiaofeixia.sj.service.ErrorService#InsertError(java.lang.String)
	 */
	@Override
	public int  InsertError(String error_message) {
		return error.InsertError(error_message);
	}
	
	
	
	//查询已存在的异常信息
	/* (non-Javadoc)
	 * @see com.xiaofeixia.sj.service.ErrorService#SelectError()
	 */
	@Override
	public List<Error> SelectError() {
		return error.SelectError();
	}

}
