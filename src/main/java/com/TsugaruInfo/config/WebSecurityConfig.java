package com.TsugaruInfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.TsugaruInfo.service.LoginUserDetailService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	LoginUserDetailService lService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * Web全般のセキュリティ
	 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring()
			.antMatchers("/resources/**");
	}
	
	/**
	 * Http通信のセキュリティ
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//セキュリティで管理されたページの設定
		http
			.authorizeRequests()	
			.antMatchers("/adminproc/*").authenticated()
			.and()
			.csrf()
			.disable()
			
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/top")
				.failureUrl("/login?error")
				.permitAll();
				
			

			
		//ログアウト設定
			http.logout()
				.logoutUrl("auth/logout")
				.permitAll();
	}
	
	/**
	 * 
	 */
    @Autowired
    void configureAuthenticationManager(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(lService)
        .passwordEncoder(passwordEncoder);
    }
}
