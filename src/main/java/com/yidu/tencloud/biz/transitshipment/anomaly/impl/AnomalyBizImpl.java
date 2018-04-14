package com.yidu.tencloud.biz.transitshipment.anomaly.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.transitshipment.anomaly.Anomaly;
import com.yidu.tencloud.biz.transitshipment.anomaly.AnomalyBiz;
import com.yidu.tencloud.dao.transitshipment.anomaly.AnomalyMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 异常处理业务逻辑层实现类
 * @author 张建勇
 * @date 2018.01.03
 */
@Service
public class AnomalyBizImpl implements AnomalyBiz{
	
	/**
	 * 保留对异常信息数据访问层的引用
	 */
	@Autowired
	private AnomalyMapper anomalyMapper;

	public AnomalyMapper getAnomalyMapper() {
		return anomalyMapper;
	}

	public void setAnomalyMapper(AnomalyMapper anomalyMapper) {
		this.anomalyMapper = anomalyMapper;
	}

	@Override
	public boolean addAnomaly(Anomaly anomaly) {
		anomaly.setExceptionId(IDGenderatorUtil.generateId());
		int result = anomalyMapper.addAnomaly(anomaly);
		if(result<1){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<Anomaly> findAllAnomaly() {
		return anomalyMapper.findAllAnomaly();
	}

	@Override
	public List<Anomaly> findAllAnomalyByPage(Integer offset , Integer limit) {
		Map<String, Integer> paremMap = new HashMap<String, Integer>();
		paremMap.put("offset", offset);
		paremMap.put("limit", limit);
		return anomalyMapper.findAllAnomalyByPage(paremMap);
	}

	@Override
	public List<Anomaly> findAnomalyByConditionVague(Map<String, Object> paremMap) {
		return null;
	}

	@Override
	public boolean deleteAnomalyById(String exceptionId) {
		int result = anomalyMapper.deleteAnomalyById(exceptionId);
		if(result<1){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public List<String> findAllExceptionNo() {
		return anomalyMapper.findAllExceptionNo();
	}

	@Override
	public List<String> findAllExceptionType() {
		return anomalyMapper.findAllExceptionType();
	}
	
	
}
