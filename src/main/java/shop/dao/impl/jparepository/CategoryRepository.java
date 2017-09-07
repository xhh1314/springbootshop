package shop.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByUuid(String uuid);

	

}
