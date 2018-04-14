package com.yidu.tencloud.biz.transitshipment.sort.impl;

import java.util.ArrayList;
import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.transitshipment.sort.Outwarehouse;
import com.yidu.tencloud.biz.transitshipment.sort.OutwarehouseBiz;
import com.yidu.tencloud.dao.transitshipment.sort.OutwarehouseDao;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 数据业务逻辑层
 * @author 刘艺钿
 *  @since 2018-01-03
 */
@Service
public class OutwarehouseImpl implements OutwarehouseBiz {
	@Autowired 
	private OutwarehouseDao outwarehousedao;
	
	
	public OutwarehouseDao getOutwarehousedao() {
		return outwarehousedao;
	}


	public void setOutwarehousedao(OutwarehouseDao outwarehousedao) {
		this.outwarehousedao = outwarehousedao;
	}

    
	/**
	 * 查询分页出入库
	 */
	@Override
	public List<Outwarehouse> findOutWareHousePagenation(Map<String, Object> paremMap) {
	
		User user = ShiroUtil.getUser();
	   Outwarehouse outwarehouse = new Outwarehouse();
	   outwarehouse.setOperationUnit(outwarehousedao.findOrgNameById(user.getOrgId()));
		return outwarehousedao.findOutWareHousePagenation(paremMap);
		
		
	}

    
	/**
	 * 查询出入库总条数
	 */
	@Override
	public int outwarehousecount() {
		
		return outwarehousedao.outwarehousecount();
	}

    /**
     * 按条件分页查询出入库信息
     */
	@Override
	public List<Outwarehouse> findOutWareHousePagenationWithCriteria(Map<String, Object> paremMap) {
		
		return outwarehousedao.findOutWareHousePagenationWithCriteria(paremMap);
	}

    /**
     * 查询出满足条件的出入库总条数
     */
	@Override
	public int outwareousecountWithCriteria(Map<String, Object> paremMap) {
		
		return outwarehousedao.outwareousecountWithCriteria(paremMap);
	}


	@Override
	public Outwarehouse findoutPrint(String outwarehouseId) {
		
		return outwarehousedao.findoutPrint(outwarehouseId);
	}


	@Override
	public List<Outwarehouse> findOutwareHouseId(String[] outwarehouseId) {
		List<Outwarehouse> out = new ArrayList<>();
		for (String string : outwarehouseId) {
          out.add(outwarehousedao.findoutPrint(string));
		}
		return out;
	}


	

}
