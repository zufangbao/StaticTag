package com.zufangbao.web.tag;

import javax.servlet.jsp.tagext.BodyTagSupport;

import com.zufangbao.core.spring.BeanHelper;
/**
 * 静态标签
 * @author Administrator
 *
 */
public class StaticBaseTag extends BodyTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1878263075436183561L;
	private static StaticTagSetting setting = null;
	/**
	 * 获取设置
	 * @return
	 */
	protected StaticTagSetting getSetting(){
		if (setting == null){
			setting = BeanHelper.getInstance(StaticTagSetting.class);
		}
		return setting;
	}
}
