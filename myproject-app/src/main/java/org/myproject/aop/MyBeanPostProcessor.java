package org.myproject.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		if(bean.getClass().isAnnotationPresent(Controller.class) ||
//				bean.getClass().isAnnotationPresent(RestController.class)) {
//			Method[] methods = bean.getClass().getMethods();
//			for(Method method:methods) {
//				if(method.isAnnotationPresent(CustomerBindingResult.class)) {
//					System.out.println("beanName:"+beanName+",methodName:"+method.getName());
//					Parameter[] parameters = method.getParameters();
//			    	for(Parameter parameter:parameters) {
//			    		if(parameter.isAnnotationPresent(Valid.class)) {
//			    			System.out.println("parameter:"+parameter.getName());
//			    		}
//			    	}
//				}
//			}
//		}
		return bean;
	}
	
}
