package shop.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.PropertyValue;
@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, String> {

}
