package shop.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	Product findByUuid(String uuid);

	List<Product> findBySb_uuid(String uuid);

}
