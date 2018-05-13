package com.qsj.exception;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 验证异常
 * @author qsjteam   
 * @date 2018-5-5 
*
 */
public class ValidateException extends BaseException {
	private static final long serialVersionUID = 1L;

	public ValidateException(Object object) {
		super(object.toString());
	}
}
