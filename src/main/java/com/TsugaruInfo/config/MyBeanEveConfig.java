package com.TsugaruInfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.TsugaruInfo.bean.MyBeanEve;
import com.TsugaruInfo.sample1.MyBeanEventListener;
import com.TsugaruInfo.sample1.MyBeanEventService;
import com.TsugaruInfo.sample1.MySampleApplicationListener;

@Configuration
@ComponentScan(basePackages = "com.TsugaruInfo.bean")
public class MyBeanEveConfig {
	
	@Bean
	MyBeanEve myBean2() {
		return new MyBeanEve();
	}
	
	@Bean
	public MySampleApplicationListener addListener() {
		return new MySampleApplicationListener();
	}
	
	@Bean
	public MyBeanEventListener mybeanListener() {
		return new MyBeanEventListener();
	}
	
	@Bean
	public MyBeanEventService mybeanService() {
		return new MyBeanEventService();
	}

}
