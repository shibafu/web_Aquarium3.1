package com.TsugaruInfo.validation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy= {PasswordConfirmValidationImpl.class})
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConfirm{
    String message() default "com.TsugaruInfo.Validation.PasswordConfirmValidationImpl.message"; //エラーメッセージ
    Class<?>[] groups() default {};            //引数に使う肩を宣言
    Class<? extends Payload>[] payload() default {}; //Payload荷重
    
    String property();
    String comparingProperty();
    
    @Documented
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
    	PasswordConfirm[] value();
    }
}