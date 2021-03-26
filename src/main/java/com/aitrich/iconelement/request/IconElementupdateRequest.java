package com.aitrich.iconelement.request;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import com.aitrich.iconelement.model.IconElement;

public class IconElementupdateRequest {
	
    @FormParam("id")
    @PartType(MediaType.TEXT_PLAIN)
	private int id;
	
    @FormParam("iconName")
    @PartType(MediaType.TEXT_PLAIN)
	private String iconName;
	
	@FormParam("icon")
	@PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream icon;
    
    @FormParam("parentId")
    @PartType(MediaType.TEXT_PLAIN)
    private long parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

}
