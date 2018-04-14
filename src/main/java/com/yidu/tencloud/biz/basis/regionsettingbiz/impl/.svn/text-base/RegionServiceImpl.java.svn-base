package com.yidu.tencloud.biz.basis.regionsettingbiz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.regionsetting.Area;
import com.yidu.tencloud.biz.basis.regionsettingbiz.RegionService;
import com.yidu.tencloud.dao.basis.regionsetting.RegionMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.PinYin4jUtils;

@Service
public class RegionServiceImpl implements RegionService {
	/**
	 * 对Mapper接口进行注入
	 */
	@Autowired
	private RegionMapper regionMapper;
	
	public void setRegionMapper(RegionMapper regionMapper) {
		this.regionMapper = regionMapper;
	}

	/**
	 * 记录总数的方法
	 * @param paramMap map集合
	 */
	@Override
	public int countArea(Map<String,Object> paramMap) {
		//返回记录数的方法
		return regionMapper.countArea(paramMap);
	}
 
	/**
	 * 分页带条件的查询
	 * @param paramMap map集合
	 */
	@Override
	public List<Area> pageQuery(Map<String,Object> paramMap) {
		//返回分页带添加查询的方法
		return regionMapper.pageQuery(paramMap);
	}
	
	/**
	 * 添加区域
	 * @param area 区域
	 */
	@Override
	public int addArea(Area area) {
		//判断是否添加成功1个
		if(regionMapper.addArea(area) == 1) {
			return 1;
		}
		return 0;
	}

	/**
	 * 修改区域
	 * @param paramMap map集合
	 */
	@Override
	public int updateArea(Map<String, Object> paramMap) {
		//返回修改方法
		return regionMapper.updateArea(paramMap);
	}

	/**
	 * 删除区域
	 * @param areaId 区域Id
	 */
	@Override
	public int deleteArea(String areaId) {
		//返回删除方法
		return regionMapper.deleteArea(areaId);
	}

	/**
	 * 导入方法
	 * @param list 集合
	 */
	@Override
    public void saveBath(List<String[]> list) {
		//遍历集合
		for (String[] strings : list) {
			//创建一个区域对象
			Area area = new Area();
			//设置值
			area.setAreaId(IDGenderatorUtil.generateId());
			area.setProvince(strings[0]);
			area.setCity(strings[1]);
            area.setCounty(strings[2]);
            area.setPostcode(strings[3]);
            
            //获得城市编码的拼音
            String[] cityCoeds = PinYin4jUtils.getHeadByString(strings[0].split("省|市")[0]);
            
            String cityCoed1 = "";
            //遍历集合
            for(String cityCode : cityCoeds) {
            	//字符串拼接
            	cityCoed1= cityCoed1+cityCode;
            }
            area.setCitycode(cityCoed1);
			
            //设置简码的拼音
            String[] brevityCodes = PinYin4jUtils.getHeadByString(strings[0].split("省|市")[0]
            		+strings[1].split("市")[0]+strings[2].split("县|区")[0]);
            String brevityCode1 = "";
            //遍历集合
            for(String brevityCode : brevityCodes) {
            	//字符串拼接
            	brevityCode1= brevityCode1+brevityCode;
            }
            area.setBrevitycode(brevityCode1);
            area.setIsUse("1");
            
            this.addArea(area);
		}
    }



}
