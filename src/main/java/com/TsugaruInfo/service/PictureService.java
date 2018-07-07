package com.TsugaruInfo.service;

import java.util.List;

import com.TsugaruInfo.entity.PictureMaster;

public interface PictureService {
	public Long addPicture(PictureMaster pictureMaster);
	public Long addPicture(byte[] picturedata, String pictureName,String originalName, Integer uploadUserId);
	public List<PictureMaster> readUserPicture(Integer uploadUserId);
//	public int readPicture(String pictureName, Integer uploadUserId);
	//	public int deletePicture(String pictureName, Integer uploadUserId);
	//	public int editName(String pictureName, Integer uploadUserId);
}
