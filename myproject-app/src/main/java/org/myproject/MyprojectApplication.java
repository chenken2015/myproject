package org.myproject;

import org.myproject.aop.MyBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableDiscoveryClient
@EnableJpaRepositories
@ComponentScan(basePackages="org.myproject")
@SpringBootApplication
public class MyprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	} 
	
	@Bean
	public MyBeanPostProcessor createBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}
}
