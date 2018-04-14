package com.yidu.tencloud.web.controller.basis.pickandrelaystandardcontroller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Relay;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.RelayBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;

@Controller
@RequestMapping("/relay")
public class RelayController {
	
	@Autowired
	private RelayBiz relayBiz;
	
	@RequestMapping(value="/findAllRelay.action",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findAllRelay(@RequestBody Map<?, ?> map)throws Exception{
		Map<String, Object> relayMap = new HashMap<String, Object>();		
        Integer limit=(Integer)map.get("limit");
        Integer offset=(Integer)map.get("offset");
        Map<String, Integer> paremMap = new HashMap<String, Integer>();
		paremMap.put("offset", offset);
		paremMap.put("limit", limit);		
		relayMap.put("total", relayBiz.findAllRelay().size());
		relayMap.put("rows", relayBiz.findRealyByPage(paremMap));
		return relayMap;
	}
	
	@RequestMapping(value="/addRelay.action",method={RequestMethod.POST})
	public String addRelay(String startTimes,String endTimes,Relay relay)throws Exception{	
		relay.setRelayId(IDGenderatorUtil.generateId());
		relay.setReplaceId(relayBiz.findEmpIdByEmpName(relay.getReplaceName()));
		relay.setReplacedId(relayBiz.findEmpIdByEmpName(relay.getReplacedName()));	
		relay.setStartTime(new Date(Timestamp.valueOf(startTimes).getTime()));
		relay.setEndTime(new Date(Timestamp.valueOf(endTimes).getTime()));
		relay.setIsUse("1");
		boolean result = relayBiz.addRealy(relay);
		if(result==true){
			return "redirect:/jsps/basis/emp/relay.jsp";
		}else{
			return "redirect:/jsps/basis/relay.jsp";
		}
	}
	
	
	@RequestMapping(value="/findRelayByVague.action",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findRelayByVague(@RequestBody Map<String, Object> map) throws Exception{
        List<Relay> relays = relayBiz.findRealyByCoiny(map);
        Map<String, Object> relayMap = new HashMap<String, Object>();
        relayMap.put("total", relayBiz.findAllRelay().size());
        relayMap.put("rows", relays);
		return relayMap;
	}
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}
	
	@RequestMapping(value="/findAllEmpName.action")
	@ResponseBody
	public List<String> findDrawTimeName(){
		List<String> empName = relayBiz.findAllEmpName();		
		return empName;
	}
	
	
	@RequestMapping("/deleteRelay.action")
	@ResponseBody
	public String deleteRelay(String[] relayId) throws Exception{
		Boolean result = false;
		for(String relayID : relayId){	
			result = relayBiz.delRelay(relayID);
		}
		System.out.println(result);
		if(result) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping(value="/updateRealy.action",method={RequestMethod.POST})
	@ResponseBody
	public String updateRealy(String RstartTime,String RendTime, Relay relay) throws Exception{	
		boolean result = relayBiz.updateRelay(
				relay.getRelayId(),
				relayBiz.findEmpIdByEmpName(relay.getReplaceName()),
				relayBiz.findEmpIdByEmpName(relay.getReplacedName()),
				new Date(Timestamp.valueOf(RstartTime).getTime()),
				new Date(Timestamp.valueOf(RendTime).getTime()),
				relay.getReplaceName(),
				relay.getReplacedName(),
				relay.getRemake());
		if(result) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	public RelayBiz getRelayBiz() {
		return relayBiz;
	}

	public void setRelayBiz(RelayBiz relayBiz) {
		this.relayBiz = relayBiz;
	}
	
}