package shop.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SpringBeanUtil implements ApplicationContextAware {

	public SpringBeanUtil() {
		// TODO Auto-generated constructor stub
	}

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	
	public <T> T getBean(Class<T> beanClass){
		return applicationContext.getBean(beanClass);
		
	}

}
