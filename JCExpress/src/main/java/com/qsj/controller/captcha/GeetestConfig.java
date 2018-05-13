package com.qsj.controller.captcha;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * GeetestWeb配置文件
 * @author qsjteam   
 * @date 2018-5-5
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String captcha_id = "d42c638bd2be3f18daf8f051ce64c82c"; //773b40f779a05df90be6c500da1b740b
	private static final String private_key = "f46aaef24ee5edc97fd22ce39c7284ec";//a256b3c76c4a954dcf188162175ba892
	private static final boolean newfailback = true;
	
	public static final String getCaptcha_id() {
		return captcha_id;
	}

	public static final String getPrivate_key() {
		return private_key;
	}

	public static final boolean isnewfailback() {
		return newfailback;
	}
	
}
