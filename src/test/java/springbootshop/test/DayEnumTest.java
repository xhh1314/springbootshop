package springbootshop.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import shop.constant.DayEnum;




/**
 * 测试枚举类
 * @author lh
 * @date 2017年9月27日
 * @version 1.0
 */
public class DayEnumTest {

	public DayEnumTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test1() {
		System.out.println(DayEnum.MONDAY.name());
		System.out.println(DayEnum.MONDAY);
		int a = 22;
	}
	/**
	 * 
	 */
	@Test
	public void test2(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		for (String item : list) {
		if ("2".equals(item)) {
		list.remove(item);
		}
		
	}
		
	}

}
