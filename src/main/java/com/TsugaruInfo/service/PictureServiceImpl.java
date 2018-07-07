package com.TsugaruInfo.service;

import java.util.List;
import java.util.Base64;

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
	public Long addPicture(byte[] picturedata, String pictureName, String originalName, Integer uploadUserId) {
		// TODO 自動生成されたメソッド・スタブ
		PictureMaster input = new PictureMaster();
		
		input.setPictureData(picturedata);
		input.setPictureName(pictureName);
		input.setOriginalName(originalName);
		input.setUploadUserId(uploadUserId);
		
		pRepository.saveAndFlush(input);
		
		return input.getPictureId();
	}
	
	/**
	 * 画像を登録する(API)
	 */
	@Override
	public Long addPicture(PictureMaster pictureMaster) {
		// TODO 自動生成されたメソッド・スタブ
		pictureMaster.setPictureData(Base64.getDecoder().decode(pictureMaster.getBase64string()));
		
		pRepository.saveAndFlush(pictureMaster);
		
		return pictureMaster.getPictureId();
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
