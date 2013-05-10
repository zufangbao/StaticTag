package com.zufangbao.web.tag;
/**
 * 静态项
 * @author Administrator
 *
 */
public class StaticItem {
	private StaticType type;
	private String value;
	
	public StaticItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaticItem(StaticType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	public StaticType getType() {
		return type;
	}
	public void setType(StaticType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
