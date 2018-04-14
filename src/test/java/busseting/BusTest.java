package busseting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.tencloud.bean.basis.busseting.Bus;
import com.yidu.tencloud.biz.basis.bussetingbiz.BusSetingBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class BusTest {
	
	@Resource BusSetingBiz busB;
	
	//@Test
	public void testAllBus(){
		List<Bus> busList = this.busB.findBusPagenation(null);
		for(Bus bus : busList){
			System.out.println(bus);
		}
		assertNotNull(busList);
	}
	
	@Test
	public void testAddBus(){
		Bus bus = new Bus();
		bus.setBusId(IDGenderatorUtil.generateId());
		bus.setLicenseNum("湘E-99999");
		bus.setCommonCarrier("湘运集团");
		bus.setMotorcycleType("大卡车");
		bus.setEmpId("胡司机");
		bus.settControl(100);
		bus.setCircuitType("陆运");
		assertEquals(1,busB.addBus(bus));
	}
	
	/*public void testUpdateBus(){
		Bus bus = new Bus();
		bus.setBusId("0012");
		bus.setLicenseNum("京A-88888");
		this.busB.updateBus(bus);
		
	}*/

}
