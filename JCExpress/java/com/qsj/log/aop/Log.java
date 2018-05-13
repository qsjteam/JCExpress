package com.qsj.log.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


 /** 
  * @ClassName: Log 
  * @Description: TODO
  * @author: 作者 Mao
  * @date: 时间 2018年1月27日 上午11:54:32  
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

	boolean isLog() default true;
	
}
