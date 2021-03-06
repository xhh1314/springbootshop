package shop.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shop.bean.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	Product findByUuid(String uuid);

	@Query(value="select * from product where sb_uuid=?1",nativeQuery=true)
	List<Product> findBySb_uuid(String uuid);

	static final String sql="select a.uuid,a.name,a.orignalprice,a.promoteprice,a.promoteprice,a.stock,a.subdivide_uuid as sb_uuid,a.createDate from"
	+" (select product.uuid,product.name,product.orignalprice,product.promoteprice,product.stock,product.createdate,subdivide.uuid as subdivide_uuid,subdivide.name as subdivide_name,category.name as category_name,productImage.type as image_value from product left join subdivide on product.sb_uuid=subdivide.uuid left join category on subdivide.ct_uuid=category.uuid left join productImage on product.uuid=productImage.pd_uuid) a "
			+"where  a.name like %?1% or subdivide_name like %?1% or category_name like %?1%";
	@Query(value=sql,nativeQuery=true)
	List<Product> selectByKeys(String keys);

}
