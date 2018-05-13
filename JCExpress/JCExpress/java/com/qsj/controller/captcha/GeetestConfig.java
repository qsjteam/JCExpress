package com.qsj.controller.captcha;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String captcha_id = "d42c638bd2be3f18daf8f051ce64c82c";
	private static final String private_key = "f46aaef24ee5edc97fd22ce39c7284ec";

	public static final String getCaptcha_id() {
		return captcha_id;
	}

	public static final String getPrivate_key() {
		return private_key;
	}

}
