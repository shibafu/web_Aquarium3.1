package com.TsugaruInfo.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.TsugaruInfo.validation.PasswordConfirm;

import lombok.Data;

/**
 * 登録用フォーム
 * @author nozawa
 *
 */
@Data
@PasswordConfirm(comparingProperty = "password", property = "passwordConfirm")
public class RegisterForm {
	
	@NotNull
	private String username;
	@NotNull
	@Email
	private String email;
	@NotEmpty
	private String password;
	@NotEmpty
	private String passwordConfirm;
}
