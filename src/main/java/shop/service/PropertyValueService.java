package shop.service;

import java.util.List;

import shop.bean.Property;
import shop.bean.PropertyValue;
import shop.bean.extend.ProductPropertyValue;
import shop.util.Page;

public interface PropertyValueService {
	
	//public boolean add(PropertyValue proertyValue);
	public boolean update(PropertyValue proertyValue);
	public boolean delete(PropertyValue proertyValue );
	boolean add(List<PropertyValue> propertyValues);
	//根据产品的uuid，查找出产品的所有属性,这里应该写错了位置了
	public List<Property> getPropertyByProductUUID(String uuid);
	
	/**
	 * 根据一个page对象查询出结果
	 * @param page
	 * @return
	 */
	public List<ProductPropertyValue> getProductPropertyValueByPage(Page page);
	public List<ProductPropertyValue> getProductPropertyValueByNextPage(Page page);
	public List<ProductPropertyValue> getProductPropertyValueByPreviousPage(Page page);
	
	public int propertyValueNumber();

}
