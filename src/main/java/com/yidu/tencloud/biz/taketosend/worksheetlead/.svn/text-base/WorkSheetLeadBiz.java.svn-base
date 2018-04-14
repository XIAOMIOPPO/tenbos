package com.yidu.tencloud.biz.taketosend.worksheetlead;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLead;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLeads;

/**
 * 工作单导入业务逻辑接口
 * @author 陈玉娟
 * @since 2017年12月4日08:58:55
 */
public interface WorkSheetLeadBiz {
	/**
	 * @param myFile 文件名
	 * @return 返回所获得的文件
	 * @throws IOException 异常
	 */
	List<WorkSheetLeads> parseExecel(MultipartFile myFile) throws IOException;
	/**
	 * 获取对应地址匹配小件员
	 * @param senderAddress 寄件人地址
	 * @return 返回获得的结果
	 */
	List<Emp>  findAddressBySmallEmp(String senderAddress);
	/**
	 * 添加数据
	 * @param workSheetLeads 工作单导入对象
	 * @return 返回添加结果
	 */
	List<String> addWorkSheetLead(List<WorkSheetLead> workSheetLeads);
	
	

}
