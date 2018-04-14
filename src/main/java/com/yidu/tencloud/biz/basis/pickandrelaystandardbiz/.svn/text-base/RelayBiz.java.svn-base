package com.yidu.tencloud.biz.basis.pickandrelaystandardbiz;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Relay;


/**
 * 替班信息业务逻辑层接口
 * @author 张建勇
 * @date 2017年11月10日 09:15:19
 */
public interface RelayBiz {
	
	/**
	 * 查询所有的替班情况
	 * @return 所有的替班集合
	 */
	public List<Relay> findAllRelay();
	
	/**
	 * 添加一条替班信息
	 * @param relay 要添加的一条信息对象
	 * @return 是否成功
	 */
	public boolean addRealy(Relay relay);
	
	/**
	 * 根据员工名字查询员工Id
	 * @param empName 员工名
	 * @return 查询到的员工Id
	 */
	public String findEmpIdByEmpName(String empName);
	
	/**
	 * 分页查询
	 * @param paremMap 条件集合
	 * @return  分页查询到的集合
	 */
	public List<Relay> findRealyByPage(Map<String, Integer> paremMap);
	
	/**
	 * 模糊查询
	 * @param start 开始页数
	 * @param end 结束
	 * @param replaceName 替班名
	 * @param startTime 开始时间
	 * @param endTime  结束时间
	 * @return 查询到的集合
	 */
	public List<Relay> findRealyByCoiny(Map<String, Object> paramCriteriaMap);
	
	/**
	 * 查询所有的员工名字
	 * @return 名字集合
	 */
	public List<String> findAllEmpName();
	
	/**
	 * 根据ID删除一条替班信息 
	 * @param relayId 
	 * @return
	 */
	public boolean delRelay(String relayId);
	
	/**
	 * 修改替班信息
	 * @param relay
	 * @return
	 */
	public boolean updateRelay(String relayId, String replaceId, String replacedId, Date startTime,
			Date endTime, String replaceName, String replacedName,String remake);
}