package com.TsugaruInfo.service;

import java.util.List;

import com.TsugaruInfo.entity.UserMaster;

public interface UserService {
	void register(UserMaster userMaster);
	List<UserMaster> refferenceByName(String username);
	UserMaster searchByUsername(String Username);
	UserMaster searchByEmail(String email);
	int judgeRegisterdUser(UserMaster userMaster);
	String dummyPassword(String rawPassword);
}
