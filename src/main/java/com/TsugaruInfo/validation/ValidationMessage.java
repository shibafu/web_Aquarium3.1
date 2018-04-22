package com.TsugaruInfo.validation;

import lombok.Data;

/**
 * バリデーション用メッセージです。
 * バリデーターに使うメッセージを登録します。
 * @author nozawa
 *
 */
@Data
public class ValidationMessage {
	public final static String NOT_PASSWORD_ERROE_MESSAGE = "入力した確認パスワードが違います！";
}
