package com.TsugaruInfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.TsugaruInfo.service.APILoginUserDetailService;

/**
 * API用セキュリティ
 * @author pratula
 *
 */
@EnableWebSecurity
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class APIWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	APILoginUserDetailService lService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	/**
	 * Web全般のセキュリティ
	 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**");
	}

	/**
	 * Http通信のセキュリティ
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// セキュリティで管理されたページの設定
		http.antMatcher("/api/**");

		http.authorizeRequests().anyRequest().authenticated(); // 適用された全リクエストに対して認証を要求
		http.httpBasic(); // Basic認証
		http.csrf().disable();
	}

	/**
	 *
	 */
	@Autowired
	void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(lService).passwordEncoder(passwordEncoder);
	}
}
