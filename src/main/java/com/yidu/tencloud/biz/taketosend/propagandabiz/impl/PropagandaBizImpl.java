package com.yidu.tencloud.biz.taketosend.propagandabiz.impl;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.propaganda.Propaganda;
import com.yidu.tencloud.biz.taketosend.propagandabiz.PropagandaBiz;
import com.yidu.tencloud.dao.taketosend.propaganda.PropagandaMapper;
/**
 * 业务逻辑层实现类
 * @author 袁棋凡
 * @since 2017/12/25
 */
@Service
public class PropagandaBizImpl implements PropagandaBiz{
	//对宣传任务mapper接口进行注入
	@Autowired
    private PropagandaMapper propagandaMapper;
    
	/**
	 * 设置宣传任务mapper接口
	 * @param propagandaMapper mapper接口
	 */
	public void setPropagandaMapper(PropagandaMapper propagandaMapper) {
		this.propagandaMapper = propagandaMapper;
	}

	 /**
	  * 查询所有宣传任务
	  * @param paramMap map接口
	  * @return 宣传任务集合
	  */
	@Override
	public List<Propaganda> findPropagandaQuery(Map<String, Object> paramMap) {
		return propagandaMapper.propagandaPageQuery(paramMap);
	}

	 /**
	  * 添加宣传任务
	  * @param propaganda 宣传任务对象
	  * @return 宣传任务集合
	  */
	@Override
	public boolean addPropaganda(Propaganda propaganda) {
        if(propagandaMapper.addPropaganda(propaganda)==1) {
        	return true;
        }
		return false;
	}

	 /**
	  * 删除宣传任务
	  * @param propagandaId 宣传任务Id
	  * @return 是否删除成功
	  */
	@Override
	public boolean deletePropaganda(String propagandaId) {
        if(propagandaMapper.deletePropaganda(propagandaId)==1) {
        	return true;
        }
		return false;
	}

	 /**
	  * 修改宣传任务
	  * @param paramMap map接口
	  * @return 是否修改成功
	  */
	@Override
	public boolean updatePropaganda(Map<String,Object> paramMap) {
        if(propagandaMapper.updatePropaganda(paramMap)==1) {
        	
        	return true;
        }
		return false;
	}

	 /**
	  * 记录宣传任务的总数
	  * @return 总数
	  */
	@Override
	public int countPropaganda() {
		return propagandaMapper.countPropaganda();
	}

	 /**
	  * 记录宣传任务的总数带条件
	  * @param paramMap map接口
	  * @return 总数
	  */
	@Override
	public int countPropagandaWithCriteria(Map<String, Object> paramMap) {
        return propagandaMapper.countPropagandaWithCriteria(paramMap);
	}

	 /**
	  * 查询所有宣传任务带条件
	  * @param paramMap map接口
	  * @return 宣传任务集合
	  */
	@Override
	public List<Propaganda> findPropagandaQueryWithCriteria(Map<String, Object> paramMap) {
		return propagandaMapper.propagandaPageQueryWithCriteria(paramMap);
	}
    
	/**
	 * 查询一周之内的宣传任务
	 */
	@Override
	public int findWeekPropaganda() {
		return propagandaMapper.findWeekPropaganda();
	}

}
