package com.zufangbao.web.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTag;

/**静态标签项*/
public class StaticJsFileTag extends StaticBaseTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2951649297094471991L;
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public int doStartTag() throws JspException{
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	@Override
	public int doAfterBody() throws JspException{
		return BodyTag.SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException{
		if (this.getSetting().getAutoConcat() == null || !this.getSetting().getAutoConcat()){
			JspWriter writer = this.pageContext.getOut();
			try {
				writer.write(String.format("<script type=\"text/javascript\" src=\"%s%s\"></script>", this.getSetting().getScriptHomeSite(), this.getValue()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return BodyTag.EVAL_PAGE;
		}else{
			List<StaticItem> list = StaticTagHolder.get();
			list.add(new StaticItem(StaticType.JsFile, value));
			StaticTagHolder.set(list);
			return BodyTag.SKIP_BODY;
		}
	}
}
