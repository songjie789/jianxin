package com.xiaofeixia.sj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiaofeixia.sj.model.Error;

public interface ErrorDao {
	//插入異常信息
	@Insert("insert into error_table (error_message) values(#{error_message})")
	int InsertError(@RequestParam("error_message")String error_message);
	
	
	//查询异常信息给jsp页面展示
	@Select("select * from error_table")
	List<Error> SelectError();
}
