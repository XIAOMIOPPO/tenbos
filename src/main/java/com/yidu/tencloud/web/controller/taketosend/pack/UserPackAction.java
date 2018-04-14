package com.yidu.tencloud.web.controller.taketosend.pack;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.pack.Appearance;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.biz.taketosend.pack.UserPackApperancerBiz;
import com.yidu.tencloud.biz.taketosend.pack.UserPackBiz;
import com.yidu.tencloud.biz.taketosend.worksheetBiz.WorkSheetBiz;
import com.yidu.tencloud.util.ShiroUtil;

@Controller
@RequestMapping("/pack")
public class UserPackAction {

	@Autowired
	private UserPackBiz userPackBiz;

	
	/**
     * 引用业务逻辑层
     */
	@Autowired
	private WorkSheetBiz workSheetBiz;
	
	/**
	 * 赋值
	 * @param workSheetBiz
	 */
	public void setWorkSheetBiz(WorkSheetBiz workSheetBiz) {
		this.workSheetBiz = workSheetBiz;
	}
	
	
	public void setUserPackBiz(UserPackBiz userPackBiz) {
		this.userPackBiz = userPackBiz;
	}



	@ResponseBody
	@RequestMapping("/listUserPack")
	public Map<String, Object> listUserPack(@RequestBody Map<String, Object> contMap){
		Map<String,Object> catext = new HashMap<String, Object>();
		catext.put("total", userPackBiz.countUserPack(contMap));
		catext.put("rows",userPackBiz.listUserPack(contMap));
		return catext;
	}

	
	@ResponseBody
	@RequestMapping("/printPack")
	public String printPackInfo(String wno,int width,int height){
		WorkSheet workSheet = workSheetBiz.findWorkSheet(wno);
		ShiroUtil.setAttribute("gen", workSheet);
		return "jsps/TakeToSend/pack/titac.jsp";
	}
	
	
	
}
