package com.yidu.tencloud.web.controller.transitshipment.sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yidu.tencloud.bean.transitshipment.sort.Outstorage;
import com.yidu.tencloud.bean.transitshipment.sort.OutstorageDetail;
import com.yidu.tencloud.bean.transitshipment.sort.StorageinDetail;
import com.yidu.tencloud.biz.transitshipment.sort.SignBiz;
import com.yidu.tencloud.util.ResultUtil;

@Controller
@RequestMapping("sign")
public class SignController {

	@Autowired
	private SignBiz signBiz;

	public SignBiz getSignBiz() {
		return signBiz;
	}

	public void setSignBiz(SignBiz signBiz) {
		this.signBiz = signBiz;
	}
	
	
	@RequestMapping("sin")
	@ResponseBody
	public Map<String, Object> findStoragein(@RequestBody Map<String,Object> params){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", signBiz.findStorages(params));
		map.put("total", signBiz.countStorages(params));
		return map;
	}
	
	
	@RequestMapping("sindetail")
	@ResponseBody
	public Map<String, Object> findStorageInDetail(@RequestBody Map<String,Object> params){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", signBiz.findStorageDetailById(params));
		map.put("total", signBiz.countStorageDetail(params));
		return map;
	}
	
	
	@RequestMapping("upload")
	@ResponseBody
	public List<StorageinDetail> parseExecel(MultipartFile myFile){
		//解析execel文件
		List<StorageinDetail> signs = signBiz.parseExecel(myFile);
		//返回解析好的数据
		return signs;
	}
	
	
	@RequestMapping("sheetdata")
	@ResponseBody
	public List<StorageinDetail> findSheetData(String no){
		//获取传进来的字符串查询数据
		List<StorageinDetail> signs = signBiz.findSheetDetailByNo(no);
		//返回解析好的数据
		return signs;
	}
	
	
	@RequestMapping("odetail")
	@ResponseBody
	public List<OutstorageDetail> findoDetail(@RequestParam(value="outstoragenos[]")String[] outstoragenos){
		//结果集合
		List<OutstorageDetail> details = new ArrayList<OutstorageDetail>();
		//遍历数组t
		for (String no : outstoragenos) {
			details.addAll(signBiz.findOutDetialByNo(no));
		}
		//获取出库详情
		return details;
	}
	
	
	@RequestMapping("addin")
	@ResponseBody
	public Map<String,String> addStoragein(String storagein) throws JsonParseException, JsonMappingException, IOException{
		//解析json数据
		//新创一个对象集合
		ObjectMapper mapper = new ObjectMapper();
		//将这个集合转换为Java类型的对象数组
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, StorageinDetail.class);
		//将对象数组转换为Java对象
		List<StorageinDetail> storageins = mapper.readValue(storagein, javaType);
		//添加数据
		int result = signBiz.addStoragein(storageins);
		//返回结果
		return ResultUtil.writeResult(result>0);
	}
	
	
	
	
	@RequestMapping("ostatus")
	@ResponseBody
	public List<Map<String,String>> findOutStatus(@RequestParam(value="outno[]") String[] outno) {
		//返回状态
		return signBiz.findOutStatus(CollectionUtils.asList(outno));
	}
	
	
	@RequestMapping("odetails")
	@ResponseBody
	public List<OutstorageDetail> findOutDetailsByNo(String outNo){
		return signBiz.findOutDetialByNo(outNo);
	}
	
	
	@RequestMapping("fpout")
	@ResponseBody
	public Map<String,Object> findPageOutstorage(Map<String,Object> params){
		Map<String,Object> result = new HashMap<String,Object>();
		//查询总数
		result.put("total", signBiz.countPageOutstorage(params));
		//查询总行数
		result.put("rows", signBiz.findPageOutstorage(params));
		//返回结果
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
