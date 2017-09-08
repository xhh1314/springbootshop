package springbootshop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import shop.ShopApplication;
import shop.bean.Product;
import shop.bean.Subdivide;
import shop.bean.extend.ProductPropertyValue;
import shop.dao.OrderItemDao;
import shop.dao.impl.jparepository.ProductPropertyValueRepository;
import shop.dao.impl.jparepository.SubdivideRepository;
import shop.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE,classes=ShopApplication.class)
public class SpringjpaandHibernateTest {

	

	@Autowired
	private  ProductPropertyValueRepository pvr;
	@Autowired
	private  SubdivideRepository sr;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private ProductService productService;
	
	@Test
	public void findPropertyValueTest(){
		
		List<ProductPropertyValue> pv=pvr.findByPd_uuid("005e2984-644d-4d1b-9878-f36cb52541e6");
		System.out.println();
	}
	@Test
	public void findSubdivideTest(){
		@SuppressWarnings("unused")
		List<Subdivide> lss=sr.findAll();
		sr.findByUuid("36bd55a6-df93-4c99-b849-ae5dcb5489f3");
		
	}
	@Test
	public void OrderItemTest(){
		//orderItemDao.selectItemByProcuctIdAndUserId("8b6e6f52-41c7-4c8e-83b2-64e7829df0d1", "81cd4b2f-f7f3-4240-b813-72c7909f67d2");
		//orderItemDao.updateNumber("81cd4b2f-f7f3-4240-b813-72c7909f67d2", "8b6e6f52-41c7-4c8e-83b2-64e7829df0d1", 10);
		//orderItemDao.deleteItem("19");
		
	}
	@Test
	public void ProductTest(){
		
		@SuppressWarnings("unused")
		List<Product> pp=productService.selectBykeys("羽毛球");
		System.out.println();
	}
	
	
	

}


