package com.yidu.tencloud.biz.basis.regionsettingbiz;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.regionsetting.Area;

/**
 * 区域的业务逻辑层接口
 * @author 鲁静芝
 * @since 2017/11/6
 */
public interface RegionService {
	/**
	 * 分页方法
	 * @param paramMap map集合
	 * @return 区域集合
	 */
	public abstract List<Area> pageQuery(Map<String,Object> paramMap);

	/**
	 * 记录总数
	 * @param paramMap map集合
	 * @return 记录数
	 */
	public abstract int countArea(Map<String,Object> paramMap);
	
	/**
	 * 添加区域
	 * @param area 区域对象
	 * @return 添加成功的数量
	 */
	public abstract int addArea(Area area);
	
	/**
	 * 删除区域
	 * @param areaId 区域ID
	 * @return 删除成功的数量
	 */
	public abstract int deleteArea(String areaId);
	
	/**
	 * 修改区域
	 * @param paramMap map集合
	 * @return 修改成功的数量
	 */
	public abstract int updateArea(Map<String,Object> paramMap);
	
	/**
	 * 导入Excel文件
	 * @param list 文件的集合
	 */
	public void saveBath(List<String[]> list);
	
	
	
	
	
}
