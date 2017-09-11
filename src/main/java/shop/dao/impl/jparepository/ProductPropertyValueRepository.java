package shop.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shop.bean.extend.ProductPropertyValue;

@Repository
public interface ProductPropertyValueRepository extends JpaRepository<ProductPropertyValue, Integer> {

	
	static final String sql="select(@i\\:=@i+1) pvid, pv.pd_uuid as productUuid, pp.name as propertyName, pv.value as propertyValue from (select @i\\:=0) tt, propertyValue pv LEFT JOIN property pp on pv.pp_uuid=pp.uuid where pv.pd_uuid=?1";
	 

	@Query(value =sql, nativeQuery = true)
	List<ProductPropertyValue> findByPd_uuid(String uuid);


}
