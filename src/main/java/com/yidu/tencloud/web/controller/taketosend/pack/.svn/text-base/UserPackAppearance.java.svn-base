package com.yidu.tencloud.web.controller.taketosend.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.pack.Appearance;
import com.yidu.tencloud.biz.taketosend.pack.UserPackApperancerBiz;
@Controller
@RequestMapping("/pack")
public class UserPackAppearance {
	@Autowired
	private UserPackApperancerBiz apperancerBiz;

	public void setApperancerBiz(UserPackApperancerBiz apperancerBiz) {
		this.apperancerBiz = apperancerBiz;
	}
	
	@ResponseBody
	@RequestMapping("/listUserApperance")
	public Appearance listUserPack(String workSheetNo){
		Appearance zi = apperancerBiz.findAllUserApperancer("TCBOS-23432");
		System.out.println(zi);
		return apperancerBiz.findAllUserApperancer(workSheetNo);
	}
}
