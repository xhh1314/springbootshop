package shop.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.Property;
@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {

	Property findByUuid(String uuid);

	List<Property> findBySb_uuid(String uuid);

}
