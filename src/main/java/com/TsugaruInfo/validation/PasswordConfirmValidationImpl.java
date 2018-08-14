package com.TsugaruInfo.validation;

import java.util.ResourceBundle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * パスワード相関確認用のバリデーション実装
 * @author pratula
 *
 */
@Component
public class PasswordConfirmValidationImpl
	implements ConstraintValidator<PasswordConfirm, Object>{

	private String property;
	private String comparingProperty;
	private String message;

	@Override
	public void initialize(PasswordConfirm constraintsAnnotation) {
		this.property = constraintsAnnotation.property();
		this.comparingProperty = constraintsAnnotation.comparingProperty();
		//プロパティファイルからメッセージを取得
		ResourceBundle resources = ResourceBundle.getBundle("message");
		this.message = resources.getString("messsage.error.PasswordAndConfimationIsDiffernt");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		BeanWrapper beanWrapper = new BeanWrapperImpl(value);
		Object propertyValue = beanWrapper.getPropertyValue(property);
		Object comparingPropertyValue = beanWrapper.getPropertyValue(comparingProperty);

		//二つの入力プロパティを比較
		boolean matched = ObjectUtils.nullSafeEquals(propertyValue, comparingPropertyValue);

		if(matched) {
			return true;
		}else {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
			.addPropertyNode(property).addConstraintViolation();

			return false;
		}
	}

}
