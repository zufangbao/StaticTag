package com.zufangbao.web.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;

public class StaticJsContentTag extends StaticBaseTag{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2854916881707836107L;
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
		BodyContent bc = this.getBodyContent();
		if (this.getSetting().getAutoConcat() == null || !this.getSetting().getAutoConcat()){
			JspWriter writer = bc.getEnclosingWriter();
			try {
				writer.write(String.format("<script type=\"text/javascript\">%s</script>", bc.getString()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return BodyTag.EVAL_PAGE;
		}else{
			List<StaticItem> list = StaticTagHolder.get();
			list.add(new StaticItem(StaticType.JsContent, bc.getString()));
			StaticTagHolder.set(list);
			return BodyTag.SKIP_BODY;
		}
	}
}
