package com.yidu.tencloud.biz.taketosend.fasterEntering.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.fastEntering.FastEntering;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.biz.taketosend.fasterEntering.FastEnteringBiz;
import com.yidu.tencloud.dao.taketosend.fastEntering.FastEnteringMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.Num;
import com.yidu.tencloud.util.ShiroUtil;
import com.yidu.tencloud.util.UpdateSta;

/**
 * 快速录入实现接口
 * @author 廖晓翠
 * @since 2017-12-2 08:59:22
 */
@Service
public class FastEnteringBizImpl implements FastEnteringBiz{
	/**
	 * 保留对快速录入数据访问层的引用
	 */
	@Autowired
	private FastEnteringMapper fastEnteringMapper;

	public void setFastEnteringMapper(FastEnteringMapper fastEnteringMapper) {
		this.fastEnteringMapper = fastEnteringMapper;
	}

	/**
	 * 根据基础档案名查找配载要求
	 * @param recordName 基础档案名
	 * @return 如果找到返回配载要求 否则返回null
	 */
	public List<String> findStowageRequirement(String recordName) {
		//返回数据访问层的方法
		return fastEnteringMapper.findStowageRequirement(recordName);
	}

	/**
	 * 根据工作单号查找工作单号
	 * @param workSheetNo 工作单号
	 * @return 如果找到返回true 否则返回false
	 */
	public boolean findWorkSheetNoByWorkSheetNo(String workSheetNo) {
		//调用数据访问层的方法 用集合接收
		List<String> strList = fastEnteringMapper.findWorkSheetNoByWorkSheetNo(workSheetNo);
		//如果集合不为空
		if(strList.isEmpty()) {
			//成功
			return true;
		}
		//失败
		return false;
	}

	/**
	 * 快速录入的添加
	 * @param fastEntering 快速录入对象
	 * @return 添加成功返回1 否则返回0
	 */
	public int addWorkSheet(FastEntering fastEntering) {
		//获得session域里的user对象
		SecurityUtils.getSubject().getSession().getAttribute("user");
		//添加一个开单人对象
		Drawer drawer = new Drawer();
		//设置开单Id
		drawer.setDrawerId(IDGenderatorUtil.generateId());
		//设置开单人
		drawer.setDrawerName(ShiroUtil.getUser().getUserName());
		//设置开单编号
		drawer.setDrawerNo(Num.creatNum("开单"));
		//设置开单人所属公司
		drawer.setDrawerOperationCompany(ShiroUtil.getUser().getOrgId());
		//设置开单时间
		drawer.setDrawerTime(new Date(System.currentTimeMillis()));
		//设置工作单编号
		drawer.setWorkSheetNo(fastEntering.getWorkSheetNo());
		//设置规则Id
		fastEntering.setRuleId(IDGenderatorUtil.generateId());
		//设置完整性状态
		fastEntering.setIntegraliyStatus(UpdateSta.changeStatusFas(fastEntering));
		//接收数据访问层的方法
		int result = fastEnteringMapper.addWorkSheet(fastEntering);
		//如果结果为1
		if(result==1) {
				//调用数据访问层的方法
			   fastEnteringMapper.addRule(fastEntering);
			   //成功
			   return 1;
			}else {
				//失败
				return 0;
			}	
	}

}
