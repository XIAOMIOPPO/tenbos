package com.yidu.tencloud.biz.transitshipment.sort.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.transitshipment.sort.Repertory;
import com.yidu.tencloud.biz.transitshipment.sort.RepertoryBiz;
import com.yidu.tencloud.dao.transitshipment.sort.RepertoryDao;

/**
 * 业务逻辑实现层
 * @author 刘艺钿
 *
 */
@Service
public class RepertoryImpl implements RepertoryBiz {

	@Autowired 
	private RepertoryDao repertorydao;
	
	public RepertoryDao getRepertorydao() {
		return repertorydao;
	}

	public void setRepertorydao(RepertoryDao repertorydao) {
		this.repertorydao = repertorydao;
	}
    /**
     * 查询分页库存信息
     */
	@Override
	public List<Repertory> findRepertoryPagenation(Map<String, Object> paremMap) {
		
		return repertorydao.findRepertoryPagenation(paremMap);
	}
    /**
     * 查询库存总条数
     */
	@Override
	public int outRepertorycount() {

		return repertorydao.outRepertorycount();
	}

	@Override
	public List<Repertory> findRepertoryPagenationWithCriteria(Map<String, Object> paremMap) {
		
		return repertorydao.findRepertoryPagenationWithCriteria(paremMap);
	}

	@Override
	public int reperTorycountWithCriteria(Map<String, Object> paremMap) {
		
		return repertorydao.reperTorycountWithCriteria(paremMap);
	}



	

}
