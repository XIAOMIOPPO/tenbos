package com.yidu.tencloud.biz.system.clientbiz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.biz.system.clientbiz.ClientBiz;
import com.yidu.tencloud.dao.system.clientdao.ClientMapper;
import com.yidu.tencloud.util.Num;

/**
 * 业务逻辑层
 * @author 刘艺钿
 * @since 2017-11-07
 */
@Service
public class ClientBizImpl implements ClientBiz{
 
	 @Autowired
	 private ClientMapper clientMapper;
	 
	 
	public ClientMapper getClientmapper() {
		return clientMapper;
	}

	public void setClientmapper(ClientMapper clientmapper) {
		this.clientMapper = clientmapper;
	}
    
	@Override
	public List<Client> FindClient() {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(map);
		return clientMapper.FindClient();
	
	}
	/**
     * 添加客户信息
     */
	@Override
	public int addClient(Client client) {
		client.setClientNum(Num.creatNum("客户编号"));
		return clientMapper.addClient(client);
	}
	
	/**
     * 修改客户信息
     */
	@Override
	public int updateClient(Client client) {
		
		return clientMapper.updateClient(client);
	}
	/**
     * 删除客户信息
     */
	@Override
	public int deleteClient(String[] clientId) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<clientId.length; i++)
		{
			list.add(clientId[i]);
			
		}
		System.out.println(list);
		
		return clientMapper.deleteClient(list);	
	}
	/**
     * 分页查询客户
     */
	@Override
	public List<Client> findCilentPagenation(Map<String, Object> param) {
		
		return clientMapper.findCilentPagenation(param);
	}
	/**
     * 查询客户总条数
     */
	@Override
	public int countCilent() {
		return clientMapper.countCilent();
	}

	/**
     * 模糊查询客户总条数
     */
	@Override
	public int countClientWithCriteria(Map<String, Object> paremMap) {
		
		return clientMapper.countClientWithCriteria(paremMap);
	}
	/**
     * 分页模糊查询客户信息
     */
	@Override
	public List<Client> findCilentPagenationWithCriteria(Map<String, Object> paremMap) {
		
		return clientMapper.findCilentPagenationWithCriteria(paremMap);
	}
	/**
     * 分页查询客户信息
     */
	@Override
	public List<Client> findCilentPagenation1(Map<String, Object> param) {
		
		return clientMapper.findCilentPagenation1(param);
	}
	/**
     * 查询客户总条数
     */
	@Override
	public int countCilent1() {
		return clientMapper.countCilent1();
	}

	/**
     * 模糊查询客户总条数
     */
	@Override
	public int countClientWithCriteria1(Map<String, Object> paremMap) {
		
		return clientMapper.countClientWithCriteria1(paremMap);
	}
    /**
     * 客户查询模糊分页
     * (non-Javadoc)
     * @see com.yidu.tencloud.biz.system.clientbiz.ClientBiz#findCilentPagenationWithCriteria1(java.util.Map)
     */
	@Override
	public List<Client> findCilentPagenationWithCriteria1(Map<String, Object> paremMap) {
		
		return clientMapper.findCilentPagenationWithCriteria1(paremMap);
	}

	

}
