package com.yidu.tencloud.web.controller.transitshipment.sort;

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

import com.yidu.tencloud.bean.transitshipment.sort.Outwarehouse;
import com.yidu.tencloud.biz.transitshipment.sort.OutwarehouseBiz;
import com.yidu.tencloud.util.OutWareExcel;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 出入库控制器层
 * @author 刘艺钿
 *
 */
@Controller
@RequestMapping("/outwarehouse")
public class Outwarehousecontroller {
	
	@Autowired
	private OutwarehouseBiz outwarehousebiz;

	public OutwarehouseBiz getOutwarehousebiz() {
		return outwarehousebiz;
	}

	public void setOutwarehousebiz(OutwarehouseBiz outwarehousebiz) {
		this.outwarehousebiz = outwarehousebiz;
	}
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findoutwarehousePagenation",method= {RequestMethod.POST})
	public Map<String,Object> findoutwarehousePagenation(@RequestBody Map<String,Object> map){
		Map<String,Object> house = new HashMap<String,Object>();
		house.put("total", outwarehousebiz.outwarehousecount());
		house.put("rows", outwarehousebiz.findOutWareHousePagenation(map));
		return house;
		
	}
	/**
	 * 分页模糊查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findoutwarehousePagenationWithCriteria",method={RequestMethod.POST})
	public Map<String, Object> findoutwarehousePagenationWithCriteria(@RequestBody Map<String, Object> map){

		Map<String, Object> fingappmap =new HashMap<String,Object>();	
		fingappmap.put("total",outwarehousebiz.outwareousecountWithCriteria(map));
		fingappmap.put("rows", outwarehousebiz.findOutWareHousePagenationWithCriteria(map));
		
		return fingappmap;
		
	}
	
	/**
	 * 文件导出
	 * @param path 导出的路径
	 * @return 结果
	 * @throws Exception 异常
	 */
	@RequestMapping("/outware")
	@ResponseBody
	public String outware(String path) throws Exception{
		//调用工具类中的导出方法
		String result = OutWareExcel.outExcel(outwarehousebiz.findOutWareHousePagenationWithCriteria(null), path);
		//返回结果
		return result;
	}
	/**
	 * 打印出入库信息
	 * @param outwarehouse
	 * @return
	 */
	@RequestMapping("/outprint")
	public String outprint(@RequestParam(required=true,value="outwarehouseIds[]") String[] outwarehouseId) {
		
		List<Outwarehouse> outware = outwarehousebiz.findOutwareHouseId(outwarehouseId);
		//设置视图名字，跳转到打印页面上
		ShiroUtil.setAttribute("outware", outware);
		System.out.println("pgno"+outware+outwarehouseId);
		return "/jsps/transitShipment/sort/prinout";
		
	}
	

}
