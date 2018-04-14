package com.yidu.tencloud.dao.basis.pickandrelaystandard;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Relay;

/**
 * 替班Mapper接口
 * @author 张建勇
 * @date 2017.11.02
 */
public interface RelayMapper {
	
	/**
	 * 添加一条替班信息
	 * @param relay 替班信息对象
	 * @return 受影响的行数
	 */
	public int addRelay(Relay relay);
	
	
	/**
	 * 要修改的一条替班信息
	 * @param relay 替班信息对象
	 * @return 受影响的行数
	 */
	public int updateRelay(Relay relay);
	
	/**
	 * 查询所有的替班信息
	 * @return 所有的替班信息集合
	 */
	public List<Relay> findAllRelay();
	/**
	 * 条件模糊查询
	 * @param paremMap 条件查询参数集合
	 * @return 查询到的职员替班信息集合
	 */
	public List<Relay> findRelayByCondition(Map<String, Object> paremMap);
	
	/**
	 * 分页查询
	 * @param paremMap  条件集合
	 * @return 查询到的集合
	 */
	public List<Relay> findRealyByPage(Map<String, Integer> paremMap);
	
	/**
	 * 根据员工名字查询员工Id
	 * @param empName 员工名字
	 * @return 员工Id
	 */
	public String findEmpIdByEmpName(String empName);
	
	/**
	 * 查询所有的员工名字
	 * @return 所有员工名字集合
	 */
	public List<String> findAllEmpName(List<String> orgList);
	
	/**
	 * 根据ID删除一条替班信息
	 * @param relayId  替班信息Id
	 * @return 受影响的行数
	 */
	public int delRelay(String relayId);
}