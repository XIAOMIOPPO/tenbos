package com.yidu.tencloud.web.controller.taketosend.cancel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.cancel.Cancel;
import com.yidu.tencloud.biz.taketosend.cancelbiz.CancelBiz;

/**
 * 原单核销的控制类
 * @author 邓哲敏
 *
 */
public class CancelController {
	/**
	 * 注入签单接收接口
	 */
	@Autowired
	private CancelBiz cancelBiz;
	
	/**
	 * 设置签单接收接口
	 * @param recBiz 签单接收接口
	 */
	public void setCancelBiz(CancelBiz cancelBiz) {
		this.cancelBiz = cancelBiz;
	}
	  
	/**
	 * 分页查询
	 * @param offset
	 * @param limit
	 * @param returnType
	 * @param acceptingUnit
	 * @return
	 * @throws Exception 异常
	 */
	@RequestMapping("/cancel")
	@ResponseBody
	public Map<String,Object> recPageQuery(Integer offset,Integer limit,
			String returnType,String acceptingUnit) throws Exception{
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("offset", offset);
		paramMap.put("limit", limit);
		paramMap.put("returnType", returnType);
		paramMap.put("acceptingUnit", acceptingUnit);
		List<Cancel> cancelList = cancelBiz.cancelPageQuery(paramMap);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", cancelBiz.cancelCountPageQuery(paramMap));
		map.put("rows", cancelList);
		
		return map;
	}
	
	/**
	 * 删除
	 * @param workIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCancelByWorkId")
	public String deleteRecByWorkId(@RequestParam(value="workIds[]")String[] workIds) throws Exception{
		//设置结果
		boolean result = false;
		for(int i=0;i<workIds.length;i++) {
			result = this.cancelBiz.deleteCancelByWorkId(workIds[i]);
		}
		if(result) {
			return "success";
		}else {
			return "fail";
		}
	}
}
