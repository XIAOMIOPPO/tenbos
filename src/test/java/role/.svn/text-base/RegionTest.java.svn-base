package role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.tencloud.bean.basis.regionsetting.Area;
import com.yidu.tencloud.biz.basis.regionsettingbiz.RegionService;
import com.yidu.tencloud.dao.basis.regionsetting.RegionMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring/spring.xml"})
public class RegionTest {
	@Resource RegionMapper regionMapper;
	@Resource RegionService regionService;
	
	//@Test
	public void test() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("citycode", "0731");
		paramMap.put("brevitycode", "0731");
		/*paramMap.put("offset", 2);
		paramMap.put("limit", 1);*/
		
		List<Area> areaList = regionService.pageQuery(paramMap);
		
		for(Area areaVo : areaList) {
			System.out.println(areaVo);
		}
		
		//System.out.println(regionMapper.countArea());
		
		
		
		
	}
	
	@Test
	public void test1() {
		/*Area area =  new Area();
		
		area.setAreaId(IDGenderatorUtil.generateId());
		area.setProvince("湖南省");
		area.setCity("长沙市");
		area.setCounty("开福区");
		area.setPostcode("410000");
		area.setCitycode("0731");
		area.setBrevitycode("HN");
		area.setStatus("Y");
		System.out.println(regionMapper.addArea(area));*/
		
		/*ap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("province", "湖南省");
		paramMap.put("city", "长沙市");
		paramMap.put("county", "天心区");
		paramMap.put("areaId", "6BA5BBFD8F86448D");
		
		System.out.println(regionService.updateArea(paramMap));*/
		
		System.out.println(regionService.deleteArea("FD0EB98D4D684A24"));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
