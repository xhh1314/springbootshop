package shop.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders,String> {

	Orders findByUuid(String ordersUUID);

}
