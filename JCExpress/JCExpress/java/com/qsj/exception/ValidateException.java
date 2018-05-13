package com.qsj.exception;

/**
 * 
* 类名称：ValidateException   
* 类描述：ValidateException 验证异常   
* 创建人：chenguoji   
* 创建时间：2017年3月31日 下午12:55:39   
*
 */
public class ValidateException extends BaseException {
	private static final long serialVersionUID = 1L;

	public ValidateException(Object object) {
		super(object.toString());
	}
}
