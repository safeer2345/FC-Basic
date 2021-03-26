package com.aitrich.iconelement.model;

import java.util.Arrays;
import java.util.List;

public class IconElementRoot {

	private IconElement iconElementRoot;

	public IconElement getIconElement() {
		return iconElementRoot;
	}

	public void setIconElement(IconElement iconElementRoot) {
		this.iconElementRoot = iconElementRoot;
	}

	public void add(List<IconElement> iconElementList) {
		if (iconElementRoot == null)
			iconElementRoot = new IconElement(iconElementList.get(0).getId(), iconElementList.get(0).getName(),
					iconElementList.get(0).getIconImage(), iconElementList.get(0).getParentId());
		/*
		 * if(iconElementRoot.getId()==iconElementList.get(0).getId()) {
		 * 
		 * }
		 */
		if (iconElementList.size() >= 1) {
			iconElementList = iconElementList.subList(1, iconElementList.size());

			add(iconElementRoot, iconElementList);
		}
	}

	private void add(IconElement iElementRoot, List<IconElement> iconElementList) {

		boolean present = false;
		int index = -1;
		
		/*
		 * for(IconElement ie:iElementRoot.getChildren()) {
		 * 
		 */
		
		
		for (int i = 0; i < iconElementList.size();) {
//			if (iElementRoot.getChildren() != null) {
//				for (int j = 0; j < iElementRoot.getChildren().size() - 1; j++) {
//					if (iElementRoot.getChildren().get(j).getId() == iconElementList.get(0).getId())
//						present = true;
//				}
//
//			}
			//System.out.println(iElementRoot);
			if (iElementRoot.getChildren() !=null) {
				
//				System.out.println("entered");
//				
//				for(IconElement ie:iElementRoot.getChildren())
//				{
//					System.out.println("enterd");
//					if(ie.getId()==iconElementList.get(0).getId())
//					{
//						System.out.println(ie);
//						ie.addIconElement(new IconElement(iconElementList.get(0).getId(), iconElementList.get(0).getName(),
//								iconElementList.get(0).getIconImage(), iconElementList.get(0).getParentId()));
//					}
//				}
				
				iElementRoot.addIconElement(
						new IconElement(iconElementList.get(0).getId(), iconElementList.get(0).getName(),
								iconElementList.get(0).getIconImage(), iconElementList.get(0).getParentId()));
			}
//			else
//			{
//				System.out.println("else");
//				iElementRoot.addIconElement(
//						new IconElement(iconElementList.get(0).getId(), iconElementList.get(0).getName(),
//								iconElementList.get(0).getIconImage(), iconElementList.get(0).getParentId()));
//				
//			}
			for (IconElement ic : iElementRoot.getChildren()) {
				index++;
				if (ic.getId() == iconElementList.get(0).getId()) {
					if (index <= iElementRoot.getChildren().size() - 1)
						iElementRoot = iElementRoot.getChildren().get(index);
					if (iconElementList.size() >= 1)
						iconElementList = iconElementList.subList(1, iconElementList.size());
					
					add(iElementRoot, iconElementList);
					break;
				}
			}
			break;
		}
		
		
		System.out.println("asdasd"+iElementRoot);


	}

	@Override
	public String toString() {
		return "IconElementRoot [iconElement=" + iconElementRoot + "]";
	}
}
