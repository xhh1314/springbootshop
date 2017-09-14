package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.bean.Product;
import shop.bean.Property;
import shop.bean.PropertyValue;
import shop.bean.extend.MessageObject;
import shop.service.ProductService;
import shop.service.PropertyValueService;
import shop.util.ResponseWrite;

@Controller
@RequestMapping(value="/pvc")
public class PropertyValueController {
	@Autowired
	private PropertyValueService propertyValueService;
	@Autowired
	private ProductService productService;
	
	//传入一个产品uuid
	@RequestMapping(value="/addBefor/{pduuid:.+}")
	public String addBefor(@PathVariable String pduuid,ModelMap model){
		//System.out.println(pduuid);
		List<Property> propertys=propertyValueService.getPropertyByProductUUID(pduuid);
		model.addAttribute("pd_uuid",pduuid);
		model.addAttribute("propertys",propertys);
		return "back/addPropertyValue";
	}
	//produces注解为text/html时,可以接受application/json，格式数据。反之则不行
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public MessageObject add(@RequestBody List<PropertyValue> propertyValues ,ModelMap model,HttpServletResponse response) throws IOException{
		String flag=null;
		MessageObject mo=new MessageObject();
		try {
			propertyValueService.add(propertyValues);
			flag="result:success";
			mo.setMessage("数据添加成功");
			mo.setResult("success");
			System.out.println("数据添加成功！");
			//ResponseWrite.write(response, "succcess");
		} catch (Exception e) {
			// TODO: handle exception
			//ResponseWrite.write(response, "fail");
			System.out.println("数据添加失败");
			flag="result:fail";
			mo.setMessage("产品添加失败");
			mo.setResult("fail");
			e.printStackTrace();
		}
		//这里返回ajax消息给前端
		return mo;
		
		//return "forward:/product/productView"; 这里返回消息给ajax，就不能再转发到其他视图了
		
	}

	
}
