package com.aitrich.iconelement.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IconElement {
	
	private int id;
	private String name;
	private byte[] iconImage;
	private List<IconElement> children=new ArrayList<>();
	private long parentId;
	
	
	
	
	public IconElement(int id) {
		super();
		this.id = id;
	}
	
	public IconElement(List<IconElement> children) {
		super();
		this.children = children;
	}

	public IconElement(int id, String name, byte[] iconImage, List<IconElement> children,long parentId) {
		super();
		this.id = id;
		this.name = name;
		this.iconImage = iconImage;
		this.children = children;
		this.parentId= parentId;
	}
	
	public IconElement(String name, byte[] iconImage, List<IconElement> children) {
		super();
		this.name = name;
		this.iconImage = iconImage;
		this.children = children;
	}
	
	public IconElement(int id, String name, byte[] iconImage, long parentId) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.iconImage = iconImage;
		this.parentId= parentId;
	}
	
	public IconElement(int id, String name, long parentId) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.parentId= parentId;
	}
	
	public IconElement(String name, byte[] iconImage, long parentId) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.iconImage = iconImage;
		this.parentId= parentId;
	}

	public IconElement() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getIconImage() {
		return iconImage;
	}
	public void setIconImage(byte[] bs) {
		this.iconImage = bs;
	}
	public List<IconElement> getChildren() {
		return children;
	}
	public void setChildren(List<IconElement> children) {
		this.children = children;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public void addIconElement(IconElement iconElement)
	{
		this.children.add(iconElement);
	}
	

	@Override
	public String toString() {
		return "IconElement [id=" + id + ", name=" + name + ", children="
				+ children + ", parentId=" + parentId + "]";
	}

	
}
