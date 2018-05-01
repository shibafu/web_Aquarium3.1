package com.TsugaruInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TsugaruInfo.entity.UserMaster;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void LoginProcess(UserMaster loginUser) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
