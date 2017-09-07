package shop.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.PropertyValue;
import shop.bean.wrap.ProductPropertyValue;
@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, Integer> {

	List<ProductPropertyValue> findByPd_uuid(String uuid);

}
