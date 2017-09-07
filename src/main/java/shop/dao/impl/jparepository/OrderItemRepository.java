package shop.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	List<OrderItem> findByU_uuid(String u_uuid);

	Integer countByU_uuid(String uuid);

	Integer countByPd_uuidAndU_uuid(String pid, String uid);

}
