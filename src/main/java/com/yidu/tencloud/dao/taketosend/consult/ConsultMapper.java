package com.yidu.tencloud.dao.taketosend.consult;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.Consult;

public interface ConsultMapper {
	
	/**
	 * 添加一个咨询
	 * @param consult  要添加的咨询
	 * @return  受影响的行数
	 */
	public int addConsult(Consult consult);
	
	/**
	 * 受理单查询
	 * @return
	 */
	public List<Consult> findBusReConsult();
	
	/**
	 * 工单查询
	 * @return
	 */
	public List<Consult> findWorkOrderConsult();
	
	/**
	 * 分页
	 * @param parMap
	 * @return
	 */
	public List<Consult> findAllConsultByPage(Map<String, Object> parMap);
	
	/**
	 * 查询受理单
	 * @param phoneNum  电话号码
	 * @return 
	 */
	public List<String> findBusinessRecsiptNoByClient(String phoneNum);
	
	/**
	 * 查询受理单
	 * @param phoneNum  电话号码
	 * @return 
	 */
	public List<String> findWorkOrderNoByClient(String phoneNum);
}
