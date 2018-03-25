package com.yuyi.service;

import java.util.List;

import com.yuyi.model.Unit;

/**
 ** 
 *  @Organization：小飞侠
 *  @time  2018年3月23日下午9:35:25  
 *  @author   SongJie
 *  相关说明 : 
 * 
 */
public interface UnitService {

    /**
     * @param unit_name
     * @param unit_address
     * @param unit_phone 
     * @param unit_contact 
     * @return
     */
    int InsertUnit(String unit_name, String unit_address, String unit_contact, String unit_phone);

    /**
     * @return
     */
    List<Unit> SelectUnit();
}
