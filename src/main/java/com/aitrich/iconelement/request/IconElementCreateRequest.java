package com.aitrich.iconelement.request;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;


import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class IconElementCreateRequest {
	
    @FormParam("iconName")
    @PartType(MediaType.TEXT_PLAIN)
	private String iconName;
	
	@FormParam("icon")
	@PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream icon;
    
    @FormParam("parentId")
    @PartType(MediaType.TEXT_PLAIN)
    private long parentId;
    
	public IconElementCreateRequest() {
		super();
		
	}

	public IconElementCreateRequest(String iconName, InputStream icon, long parentId) {
		super();
		this.iconName = iconName;
		this.icon = icon;
		this.parentId = parentId;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public InputStream getIcon() {
		return icon;
	}

	public void setIcon(InputStream icon) {
		this.icon = icon;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "IconElementCreateRequest [iconName=" + iconName + ", icon=" + icon + ", parentId=" + parentId + "]";
	}
}
