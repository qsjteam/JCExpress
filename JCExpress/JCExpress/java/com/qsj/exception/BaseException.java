package com.qsj.exception; 
/**   
 * Copyright © 2017  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.exception 
 * @author:作者 Mao   
 * @date:创建时间 2017年12月19日 下午5:17:24 
 */
public class BaseException extends RuntimeException{
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = -5281856732211487164L;
	public BaseException(Object obj)
	{
		super(obj.toString());
	}
}
 