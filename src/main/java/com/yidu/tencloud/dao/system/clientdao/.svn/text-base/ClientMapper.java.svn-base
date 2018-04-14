package com.yidu.tencloud.dao.system.clientdao;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.system.client.Client;

/**
 * Mapper接口 
 * @author 刘艺钿
 * @since 2017-11-07
 */
public interface ClientMapper {

	/**
	 * 查询客户信息
	 * @return
	 */
	public abstract List<Client> FindClient();
	/**
	 * 添加客户信息
	 * @param client
	 * @return
	 */
	public abstract int addClient(Client client);
	/**
	 * 修改客户信息
	 * @param client
	 * @return
	 */
	public abstract int updateClient(Client client);
	/**
	 * 根据ID删除客户信息
	 * @param clientId
	 * @return
	 */
	public abstract int deleteClient(List<String> clientId); 
	 /**
     * 分页查询
     * @param param
     * @return
     */
	public abstract List<Client> findCilentPagenation(Map<String, Object> paremMap);

	/**
	 * 查询客户总记录数
	 * @return 客户总记录数
	 */
    public abstract int countCilent();

    /**
     * 查询满足条件查询的客户记录数
     * @param paremMap 查询条件
     * @return 满足条件查询的客户记录数
     */
    public abstract int countClientWithCriteria(Map<String, Object> paremMap);

    /**
     * 带条件的分页查询
     * @param paremMap
     * @return
     */
    public abstract List<Client> findCilentPagenationWithCriteria(Map<String, Object> paremMap);
    /**
     * 分页查询
     * @param param
     * @return
     */
	public abstract List<Client> findCilentPagenation1(Map<String, Object> paremMap);

	/**
	 * 查询客户总记录数
	 * @return 客户总记录数
	 */
    public abstract int countCilent1();

    /**
     * 查询满足条件查询的客户记录数
     * @param paremMap 查询条件
     * @return 满足条件查询的客户记录数
     */
    public abstract int countClientWithCriteria1(Map<String, Object> paremMap);

    /**
     * 带条件的分页查询
     * @param paremMap
     * @return
     */
    public abstract List<Client> findCilentPagenationWithCriteria1(Map<String, Object> paremMap);

}
