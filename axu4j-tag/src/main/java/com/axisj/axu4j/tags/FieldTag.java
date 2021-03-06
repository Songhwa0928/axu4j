package com.axisj.axu4j.tags;

import com.axisj.axu4j.config.ConfigReader;
import org.apache.commons.lang.StringUtils;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.tagext.JspFragment;

public class FieldTag extends AXUTagSupport {

	public FieldTag() throws Exception {
		super();
	}
	
	// =======================================================

	private String id;
	private String label;
	private String title;
	private String css;
	private String style;

	// =======================================================
	
	public String getId() {
		return StringUtils.defaultIfEmpty(id, String.format("field-%d", tagIndex));
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void beforeDoTag(JspContext context, JspFragment fragment) {
		this.tagBody = ConfigReader.getConfig().getFieldWrap();
		this.doBody  = TagUtils.toString(fragment);
	}
	@Override
	public void afterDoTag(JspContext context, JspFragment fragment) { }
	
}
