package com.TsugaruInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TsugaruInfo.entity.PictureMaster;
import com.TsugaruInfo.repository.PictureMasterRepository;

@Service
public  class PictureServiceImpl implements PictureService {

	@Autowired
	PictureMasterRepository pRepository;
	
	/**
	 * 画像を登録する。
	 */
	@Override
	public int addPicture(byte[] picturedata, String pictureName, String originalName, Integer uploadUserId) {
		// TODO 自動生成されたメソッド・スタブ
		PictureMaster input = new PictureMaster();
		
		input.setPictureData(picturedata);
		input.setPictureName(pictureName);
		input.setOriginalName(originalName);
		input.setUploadUserId(uploadUserId);
		
		pRepository.saveAndFlush(input);
		
		return 0;
	}

	/**
	 * ユーザー名に基づく登録画像を返す
	 */
	@Override
	public List<PictureMaster> readUserPicture(Integer uploadUserId) {
		
	List<PictureMaster> searchResult = pRepository.findByUploadUserId(uploadUserId);
	
	return searchResult;
	
	}

}
