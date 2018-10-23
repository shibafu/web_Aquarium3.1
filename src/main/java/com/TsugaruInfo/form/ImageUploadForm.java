package com.TsugaruInfo.form;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * 登録用フォーム
 * @author nozawa
 *
 */
@Data
public class ImageUploadForm {
	@NotNull
	private MultipartFile image;
	@NotNull
	private String filename;
}
