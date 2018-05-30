package com.TsugaruInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TsugaruInfo.entity.PictureMaster;
import com.TsugaruInfo.repository.PictureMasterRepository;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	PictureMasterRepository pRepository;
	
	@Override
	public int addPicture(byte[] picturedata, String pictureName, Integer uploadUserId) {
		// TODO 自動生成されたメソッド・スタブ
		PictureMaster input = new PictureMaster();
		
		input.setPictureData(picturedata);
		input.setPictureName(pictureName);
		input.setUploadUserId(uploadUserId);
		
		pRepository.saveAndFlush(input);
		
		return 0;
	}

}
