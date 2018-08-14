package com.TsugaruInfo.form;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * APIのテストページに使ったフォーム
 * @author pratula
 *
 */
@Data
public class ImageUploadFormApi {

	@NotNull
	private MultipartFile image;

	private String filename;

}
