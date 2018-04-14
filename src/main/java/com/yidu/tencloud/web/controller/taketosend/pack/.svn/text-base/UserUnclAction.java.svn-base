package com.yidu.tencloud.web.controller.taketosend.pack;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.biz.taketosend.pack.UserUnclBiz;
@Controller
@RequestMapping("/uncl")
public class UserUnclAction {

	@Autowired
	private UserUnclBiz userUnclBiz;

	public void setUserUnclBiz(UserUnclBiz userUnclBiz) {
		this.userUnclBiz = userUnclBiz;
	}
	
	@ResponseBody
	@RequestMapping("/listUserUncl")
	public Map<String,Object> listUserUncl(@RequestBody Map<String,Object> listMap){
		Map<String,Object> utext =new HashMap<String,Object>();
		utext.put("total",userUnclBiz.contUserUncl(listMap));
		utext.put("rows",userUnclBiz.ronesUserUncl(listMap));
		return utext;
	}
	
}
