package shop.dao;

import java.util.List;

import shop.bean.PropertyValue;
import shop.bean.wrap.ProductPropertyValue;

public interface PropertyValueDao {
	public void insert(List<PropertyValue> propertyValues);
	
	/**
	 * @param uuid
	 * @return根据产品UUID查询出该产品对应的所有属性
	 */
	public List<ProductPropertyValue> findProductPropertyValue(String uuid);

}
