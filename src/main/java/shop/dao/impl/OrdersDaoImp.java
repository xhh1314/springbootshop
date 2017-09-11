package shop.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.bean.Orders;
import shop.dao.OrdersDao;
import shop.dao.impl.jparepository.OrdersRepository;

@Repository("ordersDao")
public class OrdersDaoImp implements OrdersDao {
	@Autowired
	private OrdersRepository or;

	@Override
	//@Transactional
	public Orders insertOrder(Orders order) {
		// TODO Auto-generated method stub
		return or.save(order);
		
	}

	@Override
	public Orders findbyUuid(String ordersUUID) {
		// TODO Auto-generated method stub
		return or.findByUuid(ordersUUID);
	}

}
