package com.yidu.tencloud.biz.taketosend.pack;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.pack.Pack;

public interface LoadBiz {

	/**
	 * 核重操作的添加包装
	 * @param pack
	 * @return 添加成功返回1,否则返回0
	 */
	public boolean addPack(Pack pack);
	
	/**
	 * 核重监控的模糊查询(带分页)
	 * @param paramMap
	 * @return 包装集合
	 */
	public List<Pack> findPackPage(Map<String, Object> paramMap);
	
	/**
	 * 核重监控的计数(带分页)
	 * @param paramMap
	 * @return 返回查到的总数
	 */
	public int countPackPageQuery(Map<String,Object> paramMap);
	
	
	/**
	 * 查询组织名
	 * @param orgName
	 * @return 组织名集合
	 */
	public String findOrgNameByOrg(String orgName);
	
	
}
