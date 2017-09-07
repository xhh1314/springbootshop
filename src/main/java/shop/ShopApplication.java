package shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
public class ShopApplication extends SpringBootServletInitializer{//通过继承这个类来实现对jsp的支持

	/*public static void main(String[] args){
		
		SpringApplication.run(ShopApplication.class, args);
        System.out.println("启动成功！");
	}*/
	
	//这个写法是为了适应使用jsp
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(ShopApplication.class);  
    }  
  
    public static void main(String[] args) throws Exception {  
        SpringApplication.run(ShopApplication.class, args);  
    }  

}
