package shop.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.bean.OrderItem;
import shop.dao.OrderItemDao;
import shop.dao.impl.jparepository.OrderItemRepository;

@Repository("orderItemDao")
public class OrderItemDaoImp implements OrderItemDao {
	@Autowired
	private OrderItemRepository oir;

	@Override
	public void addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		oir.save(orderItem);
	}

	@Override
	public List<OrderItem> selectOrderItemsByUser(String userUUID) {
		// TODO Auto-generated method stub
		return oir.findByU_uuid(userUUID);
	}

	@Override
	public Integer selectItemNumberByUser(String userUUID) {
		// TODO Auto-generated method stub
		return oir.countByU_uuid(userUUID);
	}

	@Override
	public void deleteItem(String id) {
		// TODO Auto-generated method stub
		oir.delete(Integer.valueOf(id));
	}

	@Override
	// 注意这个参数顺序是否正确
	public Integer selectItemNumberByUserAndProduct(String uid, String pid) {
		// TODO Auto-generated method stub
		return oir.countByPd_uuidAndU_uuid(pid, uid);
	}

	@Override
	@Transactional
	public void updateNumber(String uid, String pid, int number) {
		// TODO Auto-generated method stub
		oir.updateNumber(uid,pid,number);

	}

	@Override
	public void updateOrderId(String[] oids, String orderId) {
		// TODO Auto-generated method stub
		throw new RuntimeException("该方法没有实现");
	}

	@Override
	public List<OrderItem> selectItemsByIds(String[] oids) {
		throw new RuntimeException("该方法没有实现");
	}

	@Override
	public List<OrderItem> selectItemByProcuctIdAndUserId(String pid, String uid) {
		// TODO Auto-generated method stub
		return oir.findByProcuctIdAndUser(pid,uid);
	}

}
