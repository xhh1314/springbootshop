package shop.dao.impl;

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
	public void insertOrder(Orders order) {
		// TODO Auto-generated method stub
		or.save(order);
	}

}
