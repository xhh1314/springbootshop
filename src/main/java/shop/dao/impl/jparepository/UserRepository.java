package shop.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findUserByEmail(String email);

	User findUserByUuid(String uuid);
	
}
