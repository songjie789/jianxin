package com.xiaofeixia.sj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.xiaofeixia.sj.model.SecondMenu;

/**
 * <P>Title: SecondDao</p>
 * <p>Description:</p>
 * <p>Company:山东宇易信息科技股份有限公司</p>
 * @author lcc
 * @data :2018年2月5日下午1:49:47
 * 
 */
public interface SecondDao {
	//查询二级菜单
	@Select("select * from second_menu_table")
	List<SecondMenu> SelectByid();
	
	//新增二级菜单
	@Insert("insert into second_menu_table(firset_menu_id,name,address) values(#{firset_menu_id},#{name},#{address})")
	int InsertFirset(@Param("firset_menu_id")Integer id,@Param("name")String name,@Param("address")String address);
	
}
