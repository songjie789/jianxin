package com.xiaofeixia.sj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xiaofeixia.sj.model.FirstMenu;

/**
 * <P>Title: FirstMenuDao</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月1日下午2:18:07
 * 
 */
public interface FirstMenuDao {
	//查询一级菜单
	@Select("select * from first_menu_table")	
	List<FirstMenu> selectBy();		
	
	//插入一级菜单
	@Insert("insert into first_menu_table(name,classname) values(#{name},#{classname})")	
	int insertFirst(@Param("name")String name,@Param("classname")String classname);    
}
