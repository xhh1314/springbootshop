package shop.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.Subdivide;
@Repository
public interface SubdivideRepository extends JpaRepository<Subdivide,Integer> {

	Subdivide findByUuid(String uuid);

	

}
