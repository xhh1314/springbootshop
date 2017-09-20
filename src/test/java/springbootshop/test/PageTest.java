package springbootshop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import shop.ShopApplication;
import shop.bean.extend.ProductPropertyValue;
import shop.service.PropertyValueService;
import shop.util.Page;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE,classes=ShopApplication.class)
public class PageTest {

	@Autowired
	private PropertyValueService propertyValueService;
	
	@Test
	public void pageTest(){
		Page page=Page.getPageInstance();
		page.setCurrentPage(2);
		page.setBeginPage(1);
		page.setEndPage(5);
		List<ProductPropertyValue> ppvs=propertyValueService.getProductPropertyValueByNextPage(page);
		
	}

}
