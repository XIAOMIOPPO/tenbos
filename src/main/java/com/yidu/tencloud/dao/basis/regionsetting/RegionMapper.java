package com.yidu.tencloud.dao.basis.regionsetting;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.regionsetting.Area;

public interface RegionMapper {
	/**
	 * 分页查询
	 * @param paramMap map集合
	 * @return 区域集合
	 */
	public abstract List<Area> pageQuery(Map<String,Object> paramMap);
	
	/**
	 * 记录区域总数
	 * @param paramMap map集合
	 * @return 总数
	 */
	public abstract int countArea(Map<String,Object> paramMap);
	
	/**
	 * 添加区域
	 * @param area 区域
	 * @return 添加成功的数量
	 */
	public abstract int addArea(Area area);
	
	/**
	 * 删除区域
	 * @param areaId 区域Id
	 * @return 删除成功的数量
	 */
	public abstract int deleteArea(String areaId);
	
	/**
	 * 修改区域
	 * @param paramMap map集合
	 * @return 修改成功的数量
	 */
	public abstract int updateArea(Map<String,Object> paramMap);
}
