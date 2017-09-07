package shop.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.ProductImage;
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer>{

}
