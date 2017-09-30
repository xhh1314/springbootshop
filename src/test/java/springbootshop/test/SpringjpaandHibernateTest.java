package springbootshop.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import shop.ShopApplication;
import shop.bean.OrderItem;
import shop.bean.Orders;
import shop.bean.Product;
import shop.bean.ProductImage;
import shop.bean.Subdivide;
import shop.bean.User;
import shop.bean.extend.ProductPropertyValue;
import shop.dao.OrderItemDao;
import shop.dao.OrdersDao;
import shop.dao.ProductDao;
import shop.dao.ProductImageDao;
import shop.dao.SubdivideDao;
import shop.dao.UserDao;
import shop.dao.impl.jparepository.OrderItemRepository;
import shop.dao.impl.jparepository.ProductPropertyValueRepository;
import shop.dao.impl.jparepository.SubdivideRepository;
import shop.manager.util.GetUUID;
import shop.manager.util.OrderCode;
import shop.service.OrderService;
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
	@Autowired
	private OrderItemRepository otr;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OrdersDao ordersDao;
@Autowired
private ProductImageDao PID;
@Autowired
private SubdivideDao subdivideDao;
@Autowired
private ProductDao productDao;
	
	
	//@Test
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
	@SuppressWarnings("unused")
	public void OrderItemTest(){
		//orderItemDao.selectItemByProcuctIdAndUserId("8b6e6f52-41c7-4c8e-83b2-64e7829df0d1", "81cd4b2f-f7f3-4240-b813-72c7909f67d2");
		//orderItemDao.updateNumber("81cd4b2f-f7f3-4240-b813-72c7909f67d2", "8b6e6f52-41c7-4c8e-83b2-64e7829df0d1", 10);
		//orderItemDao.deleteItem("19");
		//OrderItem oi=otr.findItemById(24);
		String[] oids={"24","26","29"};
		//List<OrderItem> items=orderItemDao.selectItemsByIds(oids);
		//System.out.println();
		//otr.updateOrderId("26", "3.5673368979269632E17");
		User user=userDao.findByEmail("903440799@qq.com");
		Orders order=new Orders();
		order.setUser(user);
		order.setAddress("DDDDDD");
		order.setMobile("15901015147");
		orderService.updateOrderItemOid(oids, order);
	}
	@Test
	public void insertOrderTest(){
		User user=userDao.findByEmail("903440799@qq.com");
		Orders order=new Orders();
		order.setUser(user);
		order.setAddress("DDDDDD");
		order.setMobile("15901015147");
		String ordersUUID=GetUUID.getUuid();
		order.setUuid(ordersUUID);//设置uuid
		//初始化创建订单时间
		Calendar calendar=Calendar.getInstance();
		Date date=new Date();
		Timestamp time=new Timestamp(date.getTime());
		order.setCreateDate(time);
		//生成一个订单号
		OrderCode oc=new OrderCode();
		String ordercode=oc.getOrderCode(calendar, order.getUser().getUuid());
		order.setOrdercode(ordercode);
		ordersDao.insertOrder(order);
		
	}

	@Test
	public void ProductTest(){
		@SuppressWarnings("unused")
		List<Product> pp=productService.selectBykeys("羽毛球");
		System.out.println();
	}
	@Test
	public void ProductInserTest(){
		Product p=new Product();
		Subdivide sb=new Subdivide();
		sb.setUuid("3.574417817192407E17");
		p.setName("I5");
		p.setOriginalPrice(1300);
		p.setPromotePrice(1200);
		p.setSubdivide(sb);
		//productService.insert(p, new CommonsMultipartFile(new DiskFileItem(null, null, false, null, 0, null)), request)
	}
	@Test
	public void productImageInsertTest(){
		Product p=new Product();
		Subdivide sb=subdivideDao.selectById("3.574417817192407E17");
		p.setUuid(GetUUID.getUuid());
		p.setName("I5");
		p.setOriginalPrice(1300);
		p.setPromotePrice(1200);
		p.setSubdivide(sb);
		ProductImage pi=new ProductImage();
		pi.setValue("dddd\\ddd\\dd");
		pi.setProduct(p);
		productDao.insert(p);
		List<ProductImage> pis=new ArrayList<ProductImage>();
		pis.add(pi);
		PID.insert(pis);
		
	}

}


