#根据产品UUID查询出产品的所有属性值
select product.name,property.name,propertyValue.value from propertyValue left join product  on product.uuid=propertyValue.pd_uuid left join property on propertyValue.pp_uuid=property.uuid where product.uuid='005e2984-644d-4d1b-9878-f36cb52541e6'; 