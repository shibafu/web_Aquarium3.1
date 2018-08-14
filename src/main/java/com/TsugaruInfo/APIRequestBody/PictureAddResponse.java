package com.TsugaruInfo.APIRequestBody;

import lombok.Data;
import lombok.ToString;

/**
 * 画像用APIコントローラーのレスポンスボディ
 * @author nozawa
 *
 */
@Data
@ToString
public class PictureAddResponse {

	private String pictureId;
	private Boolean SuccessedIs;
}
