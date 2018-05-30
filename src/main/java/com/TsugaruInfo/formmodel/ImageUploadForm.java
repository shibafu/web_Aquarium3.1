package com.TsugaruInfo.formmodel;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.TsugaruInfo.validation.PasswordConfirm;

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
}
