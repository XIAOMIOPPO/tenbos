package com.yidu.tencloud.biz.route.line;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.route.line.Line;

public interface LineBiz {
   
    public int countLine(Map<String,Object> param);
	
	public List<Line> findAllLine(Map<String,Object>paramMap);
	
	public boolean addLine(Line line);
	
	public boolean updateLine(Line line);
}
