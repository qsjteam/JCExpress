package com.qsj.exception; 
/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class BaseException extends RuntimeException{
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = -5281856732211487164L;
	public BaseException(Object obj)
	{
		super(obj.toString());
	}
}
 