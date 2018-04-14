package com.yidu.tencloud.web.controller.taketosend.applygoods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.returnGoods.ApplyGoods;
import com.yidu.tencloud.biz.taketosend.applygoodsbiz.ApplyGoodsBiz;
import com.yidu.tencloud.util.ResultUtil;

/**
 * 控制器
 * @author 刘艺钿
 *
 */
@Controller
@RequestMapping("/apply")
public class ApplyGoodsController {

	@Autowired
	private ApplyGoodsBiz applyGoodsBiz;

	public ApplyGoodsBiz getApplyGoodsBiz() {
		return applyGoodsBiz;
	}

	public void setApplyGoodsBiz(ApplyGoodsBiz applyGoodsBiz) {
		this.applyGoodsBiz = applyGoodsBiz;
	}
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findApplyGoodsPagenation",method= {RequestMethod.POST})
	public Map<String,Object> findApplyGoodsPagenation(@RequestBody Map<String,Object> map){
		Map<String,Object> applyMap = new HashMap<String,Object>();
		applyMap.put("total", applyGoodsBiz.applyGoodscount());
		applyMap.put("rows", applyGoodsBiz.findApplyGoodsPagenation(map));
		return applyMap;
		
	}
	/**
	 * 分页模糊查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findApplyGoodsPagenationWithCriteria",method={RequestMethod.POST})
	public Map<String, Object> findApplyGoodsPagenationWithCriteria(@RequestBody Map<String, Object> map){

		Map<String, Object> fingappmap =new HashMap<String,Object>();	
		fingappmap.put("total",applyGoodsBiz.countapplyGoodsWithCriteria(map));
		fingappmap.put("rows", applyGoodsBiz.findApplyGoodsPagenationWithCriteria(map));
		
		fingappmap.put("entryPerson1", applyGoodsBiz.findApplyGoodsPagenationWithCriteria(map));
		
		
		return fingappmap;
		
	}
	/**
	 * 添加返货信息
	 * @param applyGoods
	 * @return
	 */
	@RequestMapping("/addApplyGoods")
	@ResponseBody
	public int addApplyGoods(ApplyGoods applyGoods) {
		return applyGoodsBiz.addApplyGoods(applyGoods);
		
	}
	/**
	 * 修改作废返货信息
	 * @return
	 */
	@RequestMapping("/updateApplyGoodsIn")
	@ResponseBody
	public Map<String,String> updateApplyGoods(@RequestParam(required=true,value="applyGoods[]")String[] applyGoods)
	{
		return ResultUtil.writeResult(applyGoodsBiz.updateApplyGoods(applyGoods));
	}
	/**
	 * 修改返货信息
	 * @param applyGoods
	 * @return
	 */
	@RequestMapping("/updateApplyGoods")
	@ResponseBody
	public int updateApplyGood(ApplyGoods applyGoods)
	{
		return applyGoodsBiz.updateIApplyGoods(applyGoods);
		
	}
	@RequestMapping("/workSheetApplyGood")
	@ResponseBody
	public List<String> workSheetApplyGood(String senderPhone)
	{
		return applyGoodsBiz.findworkSheetByNo(senderPhone);
		
	}
	
}
