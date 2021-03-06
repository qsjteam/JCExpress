package com.qsj.support.tag;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * 
* 类名称：ExtHtmlTagRuleBundle   
* 类描述：Sitemesh3中增加自定义tag（网页标签）      
* 创建人：chenguoji   
* 创建时间：2017年4月2日 上午12:34:11   
*
 */
public class MyHtmlTag implements TagRuleBundle{
	
	//组建自定义tag标签
	//addRule(String tagName,TagRule rule)
	//tagName 自定义tag的名字
	//rule 自定义tag的规则这里使用
	//new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("myfooter"), false)
    @Override  
    public void install(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {  
        defaultState.addRule("myfooter", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("myfooter"), false));  
    }

	@Override
	public void cleanUp(State defaultState, ContentProperty contentProperty,
			SiteMeshContext siteMeshContext) {
	}  

}
