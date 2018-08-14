package com.TsugaruInfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 使用するBeanを登録するJavaConfig
 * 今のところpasswordEncoderしか登録してない
 * @author pratula
 *
 */
@Configuration
public class AppConfig {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
