package shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.bean.Category;
import shop.dao.CategoryDao;
import shop.dao.impl.jparepository.CategoryRepository;
@Repository("categoryDao")
public class CategoryDaoImp implements CategoryDao {
	
	@Autowired
	private CategoryRepository cr;

	@Override
	public Category selectById(String uuid) {
		// TODO Auto-generated method stub
		return cr.findByUuid(uuid);
	}

	@Override
	public void insertCategory(Category category) {
		// TODO Auto-generated method stub
		cr.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(String uuid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}
	
	



}
