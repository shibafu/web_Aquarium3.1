package com.TsugaruInfo.APIRequestBody;

import lombok.Data;
import lombok.ToString;

/**
 * APIの通信用レスポンス
 * @author nozawa
 *
 */
@Data
@ToString
public class PictureAddResponse {

	private String pictureId;
	private Boolean SuccessedIs;
}
