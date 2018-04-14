package com.yidu.tencloud.biz.taketosend.delegateDetailedbiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.delegateDetailed.DelegateDetailed;
import com.yidu.tencloud.biz.taketosend.delegateDetailedbiz.DelegateDetailedBiz;
import com.yidu.tencloud.dao.taketosend.delegateDetailed.DelegateDetailedMapper;
@Service
/**
 * 业务逻辑层实现类
 * @author 袁棋凡
 * @since 2017/12/25
 */
public class DelegateDetailedBizImpl implements DelegateDetailedBiz{
	//对受派明细mapper接口进行注入
	@Autowired
	private DelegateDetailedMapper delegateDetailedMapper;
	
	/**
	 * 设置受派明细mapper接口
	 * @param delegateDetailedMapper mapper接口
	 */
	public void setDelegateDetailedMapper(DelegateDetailedMapper delegateDetailedMapper) {
		this.delegateDetailedMapper = delegateDetailedMapper;
	}

	 /**
	  * 查询所有受派明细单
	  * @param paramMap map接口
	  * @return 受派明细单集合
	  */
	@Override
	public List<DelegateDetailed> findDelegateDetailedQuery(Map<String, Object> paramMap) {
		return delegateDetailedMapper.findDelegateDetailedQuery(paramMap);
	}

	/**
	  * 打印受派明细单
	  * @param workSheetNo 工作单编号
	  * @return 是否打印成功
	  */
	@Override
	public DelegateDetailed PrintDelegateDetailed(String workSheetNo) {
		return delegateDetailedMapper.PrintDelegateDetailed(workSheetNo);
	}
	/**
	  * 记录受派明细单的总数
	  * @return 总数
	  */
	@Override
	public int countDelegateDetailed() {
		return delegateDetailedMapper.countDelegateDetailed();
	}
	/**
	  * 记录受派明细单的总数带条件
	  * @return 总数
	  */
	@Override
	public int countDelegateDetailedWithCriteria(Map<String, Object> paramMap) {
		return delegateDetailedMapper.countDelegateDetailedWithCriteria(paramMap);
	}
	/**
	 * 查询所有的受派明细单带条件查询
	 * @param paramMap map接口
	 * @return 受派明细单集合
	 */
	@Override
	public List<DelegateDetailed> findDelegateDetailedQueryWithCriteria(Map<String, Object> paramMap) {
		List<DelegateDetailed> deles =delegateDetailedMapper.findDelegateDetailedQueryWithCriteria(paramMap);
		DelegateDetailed dele = new DelegateDetailed();
		for(int i=0;i<deles.size();i++) {
			deles.get(i).setVotes(delegateDetailedMapper.countVotes());
		}
		return deles;
	}


}
