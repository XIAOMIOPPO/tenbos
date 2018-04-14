package com.yidu.tencloud.web.controller.system.clientcontroller;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.biz.system.clientbiz.ClientBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ResultUtil;

/**
 * 控制器层
 * @author 刘艺钿
 * @since 2017-11-07
 */
@Controller
@RequestMapping("/client")
public class ClientAction {
 
	@Resource
	private ClientBiz clientBiz;

	public ClientBiz getClientBiz() {
		return clientBiz;
	}

	public void setClientBiz(ClientBiz clientBiz) {
		this.clientBiz = clientBiz;
	}
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findCilentPagenation",method={RequestMethod.POST})
	public Map<String, Object> findCilentPagenation(@RequestBody Map<String, Object> map){

		Map<String, Object> clientMap =new HashMap<String,Object>();		
		clientMap.put("total", clientBiz.countCilent());
		clientMap.put("rows", clientBiz.findCilentPagenation(map));
		return clientMap;
		
	}
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findCilentPagenation1",method={RequestMethod.POST})
	public Map<String, Object> findCilentPagenation1(@RequestBody Map<String, Object> map){

		Map<String, Object> clientMap =new HashMap<String,Object>();		
		clientMap.put("total", clientBiz.countCilent1());
		clientMap.put("rows", clientBiz.findCilentPagenation1(map));
		return clientMap;
		
	}
	
	/**
	 * 分页模糊查询
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findCilentPagenationWithCriteria",method={RequestMethod.POST})
	public Map<String, Object> findCilentPagenationWithCriteria(@RequestBody Map<String, Object> map){

		Map<String, Object> clientMap =new HashMap<String,Object>();	
		clientMap.put("total", clientBiz.countClientWithCriteria(map));
		clientMap.put("rows", clientBiz.findCilentPagenationWithCriteria(map));
		System.out.println(clientBiz.countClientWithCriteria(map));
		
		return clientMap;
		
	}
	/**
	 * 添加
	 * @param client
	 * @return
	 */
	@RequestMapping("/AddClient")
	@ResponseBody
	public int addClient(Client client)
	{
		client.setClientId(IDGenderatorUtil.generateId());
		return clientBiz.addClient(client);
		
		
	}
	/**
	 * 修改
	 * @param client
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping("/UpdateClient")
	public int Update(Client client)
	{
		return clientBiz.updateClient(client);
		
	}
	/**
	 * 删除
	 * @param clientId
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="/delClient",method={RequestMethod.POST})
	public Map<String, String> deleteClient(@RequestParam(required=true,value="clientId[]")String[] clientId)
	{
		boolean result = clientBiz.deleteClient(clientId)>0?true:false;
		return ResultUtil.writeResult(result);
		
	}
	
	
	
	
	
	
	
	
	
}
