package shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.bean.PropertyValue;
import shop.bean.wrap.ProductPropertyValue;
import shop.dao.PropertyValueDao;
import shop.dao.impl.jparepository.PropertyValueRepository;
@Repository("propertyValueDao")
public class PropertyValueDaoImp implements PropertyValueDao {

	@Autowired
	private PropertyValueRepository pvr;
	public PropertyValueDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(List<PropertyValue> propertyValues) {
		// TODO Auto-generated method stub

		pvr.save(propertyValues);
	}

	@Override
	public List<ProductPropertyValue> findProductPropertyValue(String uuid) {
		// TODO Auto-generated method stub
		return pvr.findByPd_uuid(uuid);
	}

}
