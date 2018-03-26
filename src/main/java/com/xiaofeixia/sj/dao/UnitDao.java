package com.xiaofeixia.sj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.xiaofeixia.sj.model.Unit;

/**
 ** 
 *  @Organization：小飞侠
 *  @time  2018年3月23日下午9:44:55  
 *  @author   SongJie
 *  相关说明 : 
 * 
 */
public interface UnitDao {

    /**
     * @param unit_name
     * @param unit_address
     * @param unit_phone 
     * @param unit_contact 
     * @return
     */
    //插入公司
    @Insert("insert into unit_table (unit_name,unit_address,unit_contact,unit_phone) values(#{unit_name},#{unit_address},#{unit_contact},#{unit_phone})")
    int InsertUInit(@Param("unit_name")String unit_name, @Param("unit_address")String unit_address, @Param("unit_contact")String unit_contact, @Param("unit_phone")String unit_phone);

    /**
     * @return
     */
    @Select("select * from unit_table")
    List<Unit> SelectUnit();
    
}
