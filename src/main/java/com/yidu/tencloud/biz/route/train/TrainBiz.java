package com.yidu.tencloud.biz.route.train;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.line.Line;
import com.yidu.tencloud.bean.route.train.Station;

public interface TrainBiz {
   
    public int countTrain(Map<String,Object> param);
	
	public List<Station> findAllTrain(Map<String,Object>paramMap);
	
	public boolean addTrain(Station station);
	
	public boolean updateTrain(Station station);
}
