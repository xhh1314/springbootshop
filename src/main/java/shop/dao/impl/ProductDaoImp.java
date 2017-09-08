package shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.bean.Product;
import shop.bean.extend.ProductPropertyValue;
import shop.dao.ProductDao;
import shop.dao.impl.jparepository.ProductRepository;

@Repository("productDao")
public class ProductDaoImp implements ProductDao {
	@Autowired
	private ProductRepository pr;

	public ProductDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		pr.save(product);
	}

	@Override
	public Product selectById(String uuid) {
		// TODO Auto-generated method stub
		return pr.findByUuid(uuid);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public List<Product> selectBySubdivide(String uuid) {
		// TODO Auto-generated method stub
		return pr.findBySb_uuid(uuid);
	}

	@Override
	public List<Product> selectByKeys(String keys) {
		// TODO Auto-generated method stub
		return pr.selectByKeys(keys);
	}

}
