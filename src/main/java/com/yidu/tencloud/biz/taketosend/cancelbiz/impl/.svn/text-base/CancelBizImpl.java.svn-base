package com.yidu.tencloud.biz.taketosend.cancelbiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.cancel.Cancel;
import com.yidu.tencloud.biz.taketosend.cancelbiz.CancelBiz;
import com.yidu.tencloud.dao.taketosend.cancel.CancelMapper;

/**
 * 原单核销实现类
 * @author 邓哲敏
 * @since 2017/11/2
 */
@Service
public class CancelBizImpl implements CancelBiz {
	/**
	 * 依赖注入原单核销的mapper接口
	 */
	@Autowired
	private CancelMapper cancelMapper;
	
	/**
	 * 设置原单核销的mapper接口
	 * @param logMapper 
	 */
	public void setCancelMapper(CancelMapper cancelMapper) {
		this.cancelMapper = cancelMapper;
	}

	/**
	 * 原单核销的分页并查询
	 */
	@Override
	public List<Cancel> cancelPageQuery(Map<String, Object> paramMap) {
		return cancelMapper.cancelPageQuery(paramMap);
	}
		
	/**
	 * 原单核销的添加方法
	 */
    @Override
	public boolean addCancel(Cancel cancel) {
		if (cancelMapper.addCancel(cancel)==true) {
			return true;
		}
		return false;
	}

    /**
	 * 原单核销的删除方法
	 */
	@Override
	public boolean deleteCancelByWorkId(String workId) {
		if(cancelMapper.deleteCancelByWorkId(workId)==true) {
			return true;
		}
		return false;
	}
	
	/**
	 * 计算原单核销的总记录数
	 */
	@Override
	public int cancelCountPageQuery(Map<String, Object> paramMap) {
		return cancelMapper.cancelCountPageQuery(paramMap);
	}	
}