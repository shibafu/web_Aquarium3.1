package com.TsugaruInfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.TsugaruInfo.bean.MyBean;

@Configuration
@ComponentScan(basePackages= "com.TsugaruInfo.bean")
public class MyBeanConfig {
	
	@Bean
	public MyBean myBean() {
		return new MyBean();
	}

}
