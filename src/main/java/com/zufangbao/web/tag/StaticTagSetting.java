package com.zufangbao.web.tag;

import org.springframework.stereotype.Component;

@Component
public class StaticTagSetting {
	/**
	 * 自动合并
	 */
	private Boolean autoConcat;
	/**
	 * 样式的根目录
	 */
	private String styleHomeSite;
	/**
	 * 脚本的根目录
	 */
	private String scriptHomeSite;
	public Boolean getAutoConcat() {
		return autoConcat;
	}
	public void setAutoConcat(Boolean autoConcat) {
		this.autoConcat = autoConcat;
	}
	public String getStyleHomeSite() {
		return styleHomeSite;
	}
	public void setStyleHomeSite(String styleHomeSite) {
		this.styleHomeSite = styleHomeSite;
	}
	public String getScriptHomeSite() {
		return scriptHomeSite;
	}
	public void setScriptHomeSite(String scriptHomeSite) {
		this.scriptHomeSite = scriptHomeSite;
	}
}
