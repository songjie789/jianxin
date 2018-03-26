package com.xiaofeixia.sj.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaofeixia.sj.dao.UnitDao;
import com.xiaofeixia.sj.model.Unit;
import com.xiaofeixia.sj.service.UnitService;

/**
 ** 
 *  @Organization：小飞侠
 *  @time  2018年3月23日下午9:36:22  
 *  @author   SongJie
 *  相关说明 : 
 * 
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("UnitService")
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitDao unitDao;
    /* (Javadoc)
     * @see com.xiaofeixia.sj.service.UnitService#InsertUnit(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     *2018年3月24日下午12:06:05
     */
    @Override
    public int InsertUnit(String unit_name, String unit_address, String unit_contact, String unit_phone) {
	return unitDao.InsertUInit(unit_name,unit_address,unit_contact,unit_phone);
    }
    /* (Javadoc)
     * @see com.xiaofeixia.sj.service.UnitService#SelectUnit()
     *2018年3月24日下午1:06:51
     */
    
    //查询公司信息
    @Override
    public List<Unit> SelectUnit() {
	return unitDao.SelectUnit();
    }

}
