package com.yidu.tencloud.web.controller.taketosend.worksheetLead;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLead;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLeads;
import com.yidu.tencloud.biz.taketosend.worksheetlead.WorkSheetLeadBiz;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.Num;
import com.yidu.tencloud.util.WorkSheetNo;

/**
 * 工作单导入控制器
 * @author 陈玉娟
 * @since 2017年12月20日14:56:11
 */
@Controller
@RequestMapping("/workSheetLead")
public class WorkSheetLeadController {
	/**
	 * 依赖注入workSheetLeadBiz
	 */
	@Autowired
	private WorkSheetLeadBiz workSheetLeadBiz;

	public void setWorkSheetLeadBiz(WorkSheetLeadBiz workSheetLeadBiz) {
		this.workSheetLeadBiz = workSheetLeadBiz;
	}

	/**
	 * 上传导入模板
	 * @param myFile文件名
	 * @return 返回上传结果
	 */
	@RequestMapping("/uploadWorkSheetLead")
	@ResponseBody
	public Map<String, Object> uploadWorkSheetLead(MultipartFile myFile) {
		// 定义一个变量
		Map<String, Object> map = new HashMap<>();
		try {
			// 判断文件是否为空
			if (myFile == null) {
				// 操作失败
				map.put("status", "failed");
				//操作出错
				map.put("error", "文件不能为空");
			} else {
				// 调用方法解析Excel文件
				List<WorkSheetLeads> sheets = workSheetLeadBiz.parseExecel(myFile);
				// 操作成功
				map.put("status", "success");
				
				// 将解析好的数据添加进集合
				map.put("list", sheets);
			}
		} catch (IOException e) {
			// 操作失败
			map.put("status", "failed");
		}

		return map;
	}

	/**
	 * 下载EXCEL模板
	 * @param request请求
	 * @return 返回下载好的结果
	 */
	@RequestMapping("/findDownLoadBorder")
	@ResponseBody
	public List<String> findDownLoadBorder(HttpServletRequest request) {
		// 定义一个集合
		List<String> list = new ArrayList<String>();
		// 获取容器的根路径
		String path = RequestContextUtils.getWebApplicationContext(request).getServletContext().getRealPath("/Excel/");
		// 创建一个文件
		File file = new File(path);
		// 文件数组
		File[] name = file.listFiles();
		// 遍历循环
		for (int i = 0; i < name.length; i++) {
			//将 数组名的元素添加进集合
			list.add(name[i].getName());
		}
		// 返回集合
		return list;

	}

	/**
	 * 根据寄件人地址查找小件员
	 * @param senderAddress 寄件地址
	 * @return 返回查找到的结果
	 * @throws Exception异常
	 */
	@RequestMapping("/findAddressBySmallEmp")
	@ResponseBody
	public List<Emp> findAddressBySmallEmp(String senderAddress) throws Exception {
		// 调用业务层方法根据寄件人地址查找小件员
		return workSheetLeadBiz.findAddressBySmallEmp(senderAddress);

	}

	/**
	 * 添加数据
	 * @param workSheetLeads工作单对象
	 * @return 返回添加结果
	 * @throws Exception异常
	 */
	@RequestMapping("/addWorkSheetLead")
	@ResponseBody
	public List<String> addWorkSheetLead(String workSheetLeads) throws Exception {
		// 创建一个解析器
		ObjectMapper mapper = new ObjectMapper();
		// 要转换的java类型
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, WorkSheetLead.class);
		// 解析json字符串
		List<WorkSheetLead> workSheetLead = mapper.readValue(workSheetLeads, javaType);
		// 添加工作单
		return workSheetLeadBiz.addWorkSheetLead(workSheetLead);

	}

	/**
	 * 批量生成工作单号
	 * @param workSheetNo工作单号
	 * @return 返回生成好的工作单号
	 * @throws Exception异常
	 */
	@RequestMapping("/quantilyWorkOrderNum")
	@ResponseBody
	public Map<Object, Object> quantilyWorkOrderNum(int num) throws Exception {
		// 定义一个工作单集合
		List<WorkSheet> workSheet = new ArrayList<WorkSheet>();
		// 定义一个寄件人集合
		List<Sender> sender = new ArrayList<Sender>();
		// 遍历循环
		for (int i = 0; i < num; i++) {
			// 调用方法生成工作单号
			String workSheetNo = WorkSheetNo.createWorkSheetNo();
			// 调用方法生成业务通知单号
			String businessNoticeNo = FlowOddNumber.AtomicRangeInteger("业务通知单号");
			// 调用方法生成客户单号
			String customerListNo = Num.creatNum("客户单号");
			// 线程休眠
			Thread.sleep(100);
			// 创建工作单对象
			WorkSheet workers = new WorkSheet();
			// 创建寄件人对象
			Sender send = new Sender();
			// 给工作单号赋值
			workers.setWorkSheetNo(workSheetNo);
			// 给业务通知单号赋值
			workers.setBusinessNoticeNo(businessNoticeNo);
			// 将生成的工作单号添加到工作单
			workSheet.add(workers);
			// 给客户单号赋值
			send.setSenderNo(customerListNo);
			// 添加到寄件人表
			sender.add(send);
		}
		// 创建一个Map对象
		Map<Object, Object> param = new HashMap<Object, Object>();
		// 给工作单赋值
		param.put("workSheet", workSheet);
		// 给寄件人赋值
		param.put("sender", sender);
		// 返回集合
		return param;

	}

}
