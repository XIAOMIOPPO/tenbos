package com.yidu.tencloud.dao.taketosend.pack;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.taketosend.pack.UserPack;
import com.yidu.tencloud.bean.taketosend.pack.UserUncl;

public interface UserUnclMapper {
	/**
	 * 查询
	 * @return
	 */
	public List<UserPack> findAllUserUncl();
	/**
	 * 分页
	 * @param ronseMap
	 * @return
	 */
	public List<UserUncl> ronseUserUncl(Map<String,Object> ronseMap);
	/**
	 * 模糊查询
	 * @param contMap
	 * @return
	 */
	public List<UserUncl> contUserUncl(Map<String,Object> contMap);
}
