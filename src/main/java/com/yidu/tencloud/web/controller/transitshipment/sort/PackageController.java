package com.yidu.tencloud.web.controller.transitshipment.sort;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.gson.Gson;
import com.yidu.tencloud.bean.basis.picktime.Picktime;
import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.transitshipment.sort.Packageinfo;
import com.yidu.tencloud.bean.transitshipment.sort.Packagelist;
import com.yidu.tencloud.biz.transitshipment.sort.PackageBiz;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 合包控制器层
 * @author 刘勇杰
 *
 */
@Controller
@RequestMapping("/packages")
public class PackageController {
	
	@Autowired
	private PackageBiz pBiz;

	public void setpBiz(PackageBiz pBiz) {
		this.pBiz = pBiz;
	}
	
	/**
	 * 分页查询
	 * @param paramMap Map对象
	 * @return 返回结果集
	 * @throws Exception
	 */
	@RequestMapping(value="/findPackageinfoPagenation",method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> findPackageinfoPagenation(@RequestBody Map<String, Integer> paramMap)throws Exception{
		//创建个Map结果集
		Map<String, Object> pickMap = new HashMap<>();
		//设置总数 调用查询合包主表总数方法
		pickMap.put("total", pBiz.countPackageinfo());
		//设置行 调用分页查询合包主表方法
		pickMap.put("rows", pBiz.findPackageinfoPagenation(paramMap));
		return pickMap;
	}
	
	/**
	 * 添加
	 * @param packageinfo 主表对象
	 * @return 返回结果集
	 * @throws Exception
	 */
	@RequestMapping(value="/addPackageinfo")//produces = "application/json; charset=utf-8"
	@ResponseBody
	public Map<String, Object> addPackageinfo(String  packageinfo)throws Exception{
		//解码 通过url方法里的d设置
		String jsonStr = URLDecoder.decode(packageinfo, "UTF-8");
		//创建Gson对象
		Gson gson = new Gson();
		//把字符串转换为Java对象
		Packageinfo pGson = gson.fromJson(jsonStr, Packageinfo.class);
		//创建解果集
		Map<String, Object> resultMap = new HashMap<>();
		//判断调用业务层添加方法
		if(pBiz.addPackageinfo(pGson)) {
			//状态为成功
			resultMap.put("status", "success");
		}else {
			//否则状态为失败
			resultMap.put("status", "failed");
		}
		return resultMap;
	}
	
			
			
		   
	/**
	 * 作废
	 * @param packageNo 合包号
	 * @return 返回结果集
	 * @throws Exception
	 */
	@RequestMapping("/deletePackageStatus")
	@ResponseBody
	public Map<String, Object> deletePackageStatus(@RequestParam(value="packageNo[]") String[] packageNo)throws Exception{
		//创建解果集
		Map<String, Object> resultMap = new HashMap<>();
		//判断调用业务层逻辑删除方法
		if(pBiz.deletePackageStatus(packageNo)) {
			//设置状态为成功
			resultMap.put("status", "success");
		}else {
			//否则设置为是否
			resultMap.put("status", "failed");
		}
		return resultMap;
	}
	
	/**
	 * 上传导入模板
	 * @param myFile 文件名
	 * @return 返回上传结果
	 */
	@RequestMapping("/uploadPackageLead")
	@ResponseBody
	public Map<String, Object> uploadPackageLead(MultipartFile myFile) {
		// 定义一个变量
		Map<String, Object> map = new HashMap<>();
		try {
			//判断文件是否为空
			if (myFile == null) {
				//操作失败
				map.put("status", "failed");
				map.put("error", "文件不能为空");
			} else {
				//调用方法解析Excel文件
				List<Packagelist> sheets = pBiz.parseExecel(myFile);
				//操作成功
				map.put("status", "success");
				//将解析好的数据添加进集合
				map.put("list", sheets);
			}
		} catch (IOException e) {
			//操作失败
			map.put("status", "failed");
		}

		return map;
	}
	/**
	 * 下载EXCEL模板
	 * @param request 请求
	 * @return 返回下载好的结果
	 */
	@RequestMapping("/findDownLoadBorder")
	@ResponseBody
	public List<String> findDownLoadBorder(HttpServletRequest request) {
		//定义一个集合
		List<String> list = new ArrayList<String>();
		//获取容器的根路径
		String path = RequestContextUtils.getWebApplicationContext(request).getServletContext().getRealPath("/Excel/");
		//创建一个文件
		File file = new File(path);
		// 文件数组
		File[] name = file.listFiles();
		//遍历循环
		for (int i = 0; i < name.length; i++) {
			// 数组名的元素
			list.add(name[i].getName());
		}
		//返回集合
		return list;
	}
	
	/**
	 * 将单号传到后台
	 * @param strings 数组对象
	 * @return
	 */
	@RequestMapping(value="/fileup",method={RequestMethod.POST})
	@ResponseBody
	public List<Packagelist> fileup(@RequestParam(value="strings[]") String[] strings) {
		//创建明细集合对象
		List<Packagelist> pList = new ArrayList<>();
		//遍历数组
		for (String string : strings) {
			//截取字符串，前11位
			String workSheetNo1 = string.substring(0, 11);
			//创建Map对象
			Map<String, String> pickMap = new HashMap<>();
			//在Map对象里设置工作单号
			pickMap.put("workSheetNo", workSheetNo1);
			//创建个对象，调用业务层的根据工作单号查询相关信息方法
			Packagelist list = pBiz.findPackagelistByOddNo(pickMap);
			//创建用户对象，获得用户信息
			User user=ShiroUtil.getUser();
			//设置合包明细Id
			list.setPackListId(IDGenderatorUtil.generateId());
			//设置工作单号
			list.setWorkSheetNo(workSheetNo1);
			//设置单号
			list.setOddNo(string);
			//设置输入类型
			list.setInputType("手工");
			//设置票数
			list.setVote(1);
			//将集合数据添加到明细集合对象中
			pList.add(list);
		}
		return pList;
	}
	
	/**
	 * 获得合包人的方法
	 * @return 合包人
	 * @throws Exception
	 */
	@RequestMapping("getPackageName")
	@ResponseBody
	public String getPackageName() throws Exception{
		//创建用户对象，获得用户信息
		User user=ShiroUtil.getUser();
		//获得当前用户名
		String packageName = user.getUserName();
		return packageName;
	}

	/**
	 * 获得合包号的方法
	 * @return 合包号字符串
	 * @throws Exception 抛出异常
	 */
	@RequestMapping("getPackageNo")
	@ResponseBody
	public String getPackageNo() throws Exception{
		String packageNo = FlowOddNumber.AtomicRangeInteger("合包");
		return packageNo;
	}
	
	/**
	 * 获得封签号的方法
	 * @return 合包号字符串
	 * @throws Exception 抛出异常
	 */
	@RequestMapping("getSealNo")
	@ResponseBody
	public String getSealNo() throws Exception{
		//获得封签号
		String sealNumber = IDGenderatorUtil.getSealNo();
		return sealNumber;
	}

	/**
	 * 根据合包Id查询合包信息
	 * @param packageId 合包Id
	 * @return 返回合包信息
	 * @throws Exception
	 */
	@RequestMapping(value="/findPackageinfoById")
	public @ResponseBody Packageinfo findPackageinfoById(String packageId)throws Exception{
		//根据合包Id查询合包信息
		Packageinfo package1 = pBiz.findPackageinfoById(packageId);
		return package1;
	}

	/**
	 * 修改
	 * @param packageinfo 合包主表对象
	 * @return 返回结果集
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/updatePackageinfo")	
	public Map<String,Object> updatePackageinfo(Packageinfo packageinfo)throws Exception{
		//创建解果集		
		Map<String, Object> resultMap = new HashMap<>();
		//判断修改方法
		if(pBiz.updatePackageinfo(packageinfo)) {
			//设置状态为成功
			resultMap.put("status", "success");
		}else {
			//设置状态为失败
			resultMap.put("status", "failed");
		}
		return resultMap;
	}

	/**
	 * 当日合包的数量
	 * @return 调用业务层查询合包数量
	 * @throws Exception
	 */
	@RequestMapping("/countPackageNumber")
	public @ResponseBody int countPackageNumber()throws Exception{
		return pBiz.countPackageNumber();
	};
}
