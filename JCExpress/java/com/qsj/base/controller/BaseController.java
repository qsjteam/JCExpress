package com.qsj.base.controller;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/** 
* @ClassName: BaseController 
* @Description: TODO
* @author: 作者 Mao
* @date: 时间 2018年1月26日 下午6:50:42  
*/
public class BaseController {
	/**
	 * 初始化数据绑定
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
	}

	/**
	 * 重定向至地址 url
	 * @param url 请求地址
	 * @return
	 */
	protected String redirectTo(String url) {
		StringBuilder rto = new StringBuilder("redirect:");
		rto.append(url);
		return rto.toString();
	}
}
