package shop.dao;

import shop.bean.Orders;

public interface OrdersDao {
	
	public Orders insertOrder(Orders order);

	public Orders findbyUuid(String ordersUUID);

}
