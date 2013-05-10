package com.zufangbao.web.tag;
import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTag;

/**静态标签*/
public class StaticOutTag extends StaticBaseTag{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2100809214823608499L;
	
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
		StringBuilder strOut = new StringBuilder();
		List<StaticItem> list = StaticTagHolder.get();
		if (this.getSetting().getAutoConcat() != null && this.getSetting().getAutoConcat()){
			StringBuilder strCssFiles = new StringBuilder();
			StringBuilder strJsFiles = new StringBuilder();
			StringBuilder strJsContents= new StringBuilder();
			for(StaticItem item : list){
				if (item.getType() == StaticType.JsFile){
					if (strJsFiles.length() > 0) strJsFiles.append(",");
					strJsFiles.append(item.getValue());
				}else if (item.getType() == StaticType.CssFile){
					if (strCssFiles.length() > 0) strCssFiles.append(",");
					strCssFiles.append(item.getValue());
				}else{
					if (strJsContents.length() > 0)strJsContents.append("\r\n");
					strJsContents.append(item.getValue());
				}
			}
			if (strCssFiles.length() > 0){
				strOut.append(String.format("<link rel=\"stylesheet\" type=\"text/css\" href=\"%s??%s\"/>\r\n", this.getSetting().getStyleHomeSite(), strCssFiles));
			}
			if (strJsFiles.length() > 0){
				strOut.append(String.format("<script type=\"text/javascript\" src=\"%s??%s\"></script>\r\n", this.getSetting().getScriptHomeSite(), strJsFiles));
			}
			if (strJsContents.length() > 0){
				strOut.append(String.format("<script type=\"text/javascript\">%s</script>\r\n", strJsContents));
			}

			StaticTagHolder.reset();
			//输出
			try {
				JspWriter writer = this.pageContext.getOut();
				writer.write(strOut.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return BodyTag.EVAL_PAGE;
		}
		return BodyTag.SKIP_BODY;
	}
}
