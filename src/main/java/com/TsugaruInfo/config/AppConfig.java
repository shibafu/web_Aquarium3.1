package com.TsugaruInfo.config;

import org.springframework.security.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.TsugaruInfo.bean.MyBean;
import com.TsugaruInfo.repository.UserMasterRepository;
import com.TsugaruInfo.service.UserService;
import com.TsugaruInfo.service.UserServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
