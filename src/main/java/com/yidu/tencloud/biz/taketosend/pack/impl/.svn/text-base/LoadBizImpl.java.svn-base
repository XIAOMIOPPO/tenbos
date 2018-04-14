package com.yidu.tencloud.biz.taketosend.pack.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.taketosend.pack.Pack;
import com.yidu.tencloud.biz.taketosend.pack.LoadBiz;
import com.yidu.tencloud.dao.taketosend.pack.PackMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;


/**
 * 荷重业务层
 * @author 刘子轩
 * @since 2017/12/26
 */
@Service
public class LoadBizImpl implements LoadBiz{
	
	
	/**
	 * 荷重数据访问对象
	 */
	@Autowired
	private PackMapper packMapper;
	

	public PackMapper getPackMapper() {
		return packMapper;
	}

	public void setPackMapper(PackMapper packMapper) {
		this.packMapper = packMapper;
	}

	@Override
	public boolean addPack(Pack pack) {
		User user = ShiroUtil.getUser();
		pack.setPackageId(IDGenderatorUtil.generateId());
		pack.setOperateTime(new Date());
		pack.setStorageTime(new Date());
		pack.setUserName(user.getUserName());
		pack.setOperatingPer(user.getUserId());
		pack.setOrgName(user.getOrgId());
		return packMapper.addPack(pack)>0?true:false;
	}

	@Override
	public List<Pack> findPackPage(Map<String, Object> paramMap) {
		return packMapper.packPageQuery(paramMap);
	}

	@Override
	public int countPackPageQuery(Map<String, Object> paramMap) {
		return packMapper.countPackPageQuery(paramMap);
	}

	@Override
	public String findOrgNameByOrg(String orgName) {
		return packMapper.findOrgNameByOrg(orgName);
	}

}
