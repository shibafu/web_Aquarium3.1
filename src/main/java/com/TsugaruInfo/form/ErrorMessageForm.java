package com.TsugaruInfo.form;

import java.util.HashMap;

import lombok.Data;

/**
 * エラーメッセージフォーム
 * @author pratula
 *
 */
@Data
public class ErrorMessageForm {
	private HashMap<String, String> error = new HashMap<String, String>();
}
