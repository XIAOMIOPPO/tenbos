package com.yidu.tencloud.biz.taketosend.receivebiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.receive.Receive;
import com.yidu.tencloud.biz.taketosend.receivebiz.ReceiveBiz;
import com.yidu.tencloud.dao.taketosend.receive.ReceiveMapper;

/**
 * 签单接收的实现类
 * 
 * @author 邓哲敏
 * @since
 */
@Service
public class ReceiveBizImpl implements ReceiveBiz {

	/**
	 * 依赖注入签单接收mapper接口
	 */
	@Autowired
	private ReceiveMapper recMapper;

	/**
	 * 设置签单接收的接口
	 * 
	 * @param recMapper
	 */
	public void setRecMapper(ReceiveMapper recMapper) {
		this.recMapper = recMapper;
	}

	/**
	 * 分页查询
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 签单接收集合
	 */
	@Override
	public List<Receive> recPageQuery(Map<String, Object> paramMap) {
		// 返回方法
		return recMapper.recPageQuery(paramMap);
	}

	/**
	 * 添加
	 * 
	 * @param receive
	 *            签单接收对象
	 * @return 如果注册成功返回true，反之返回false
	 */
	@Override
	public boolean addRec(Receive rec) {
		// 添加方法为正确
		if (recMapper.addRec(rec) == true) {
			// 正确
			return true;
		}
		// 错误
		return false;
	}

	/**
	 * 删除
	 * 
	 * @param workId
	 *            工作单号
	 * @return 如果删除成功返回true，反之返回false
	 */
	@Override
	public boolean deleteRecByWorkId(String workId) {
		// 删除方法为正确
		if (recMapper.deleteRecByWorkId(workId) == true) {
			// 正确
			return true;
		}
		// 错误
		return false;
	}

	/**
	 * 查询总记录数
	 * 
	 * @param paramMap
	 *            参数集合
	 * @return 返回总记录数
	 */
	@Override
	public int recCountPageQuery(Map<String, Object> paramMap) {
		// 返回方法
		return recMapper.recCountPageQuery(paramMap);
	}

}
