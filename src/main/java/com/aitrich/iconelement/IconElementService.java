package com.aitrich.iconelement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.aitrich.iconelement.model.IconElement;
import com.aitrich.iconelement.model.IconElementRoot;
import com.aitrich.iconelement.request.IconElementCreateRequest;
import com.aitrich.iconelement.request.IconElementupdateRequest;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class IconElementService {

	@Inject
	IconElementRepository repo;

	public int saveIconELement(IconElement iconElement) throws IOException, SQLException {
		return repo.saveIconELement(iconElement);
	}

	public IconElement updateIconELement(IconElement iconElement, int iconElementId) throws SQLException {

		int status=repo.updateIconELement(iconElement, iconElementId);
		
		if(status==1)
		{
			return iconElement;
		}
		
		return null;
	}

	public void deleteByIconELementId(int iconElementId) throws SQLException {
		
		int status=repo.deleteByIconELementId(iconElementId);
	}

	public IconElement findByIconElementId(int iconElementId) throws SQLException {

		List<IconElement> iconElementList = repo.findByIconElementId(iconElementId);
		IconElement iconElement = new IconElement();
		if (iconElementList.size() >= 1) {
			iconElement = iconElementList.get(0);
			iconElementList = iconElementList.subList(1, iconElementList.size());
			add(iconElement, iconElementList);
		}
		return iconElement;
	}

	public IconElementRoot findAllIconELement() throws SQLException {
		List<IconElement> iconElementList = repo.findAllIconELement();
		IconElement iconElement = new IconElement(iconElementList.get(0).getId(),iconElementList.get(0).getName(),iconElementList.get(0).getParentId());
		//iconElementRoot.add(iconElementList);
		int length=iconElementList.size();
		List<IconElement> iconElements=new ArrayList<IconElement>();
		
		/*
		 * while(true) { List<IconElement> iconElementsList=new
		 * ArrayList<IconElement>();
		 * 
		 * for(int i=0;i<length;i++) { if() insert(iconElement,iconElement.getId(),ie);
		 * 
		 * } }
		 */
		
		iconElementList=iconElementList.subList(1, iconElementList.size());
		for(IconElement ie: iconElementList)
		{
			insert(iconElement,ie.getParentId(),ie);
		}
		
		IconElementRoot iconElementRoot=new IconElementRoot();
		iconElementRoot.setIconElement(iconElement);
		
		System.out.println(iconElementRoot);
		return iconElementRoot;
	}

	public void add(IconElement iconElement, List<IconElement> iconElementList) {
		
		
		
		
		
		
		
		
		
		
//		boolean present = false;
//		int index = -1;
//		for (int i = 0; i < iconElementList.size();) {
//			if (iconElement.getChildren() != null) {
//				for (int j = 0; j < iconElement.getChildren().size() - 1; j++) {
//					if (iconElement.getChildren().get(j).getId() == iconElementList.get(0).getId())
//						present = true;
//				}
//			}
//
//			if (!present) {
//				iconElement.addIconElement(
//						new IconElement(iconElementList.get(0).getId(), iconElementList.get(0).getName(),
//								iconElementList.get(0).getIconImage(), iconElementList.get(0).getParentId()));
//			}
//
//			for (IconElement ie : iconElement.getChildren()) {
//				index++;
//				if (ie.getId() == iconElementList.get(0).getId()) {
//					if (index <= iconElement.getChildren().size() - 1)
//						iconElement = iconElement.getChildren().get(index);
//					if (iconElementList.size() >= 1)
//						iconElementList = iconElementList.subList(1, iconElementList.size());
//					add(iconElement, iconElementList);
//					break;
//
//				}
//			}
//			break;
//		}
	}
	
	public void insert(IconElement root, long parent, IconElement node)
	{
		if (root == null)
		{
			root = node;
		}
		else
		{
			if (root.getId() == parent)
			{
			root.addIconElement(node);
			}
			else
			{
				int l = root.getChildren().size();

				for (int i = 0; i < l; i++)
				{
					if (root.getChildren().get(i).getParentId() == parent)
					{
						insert(root.getChildren().get(i), parent, node);
					}
					else
					{
						insert(root.getChildren().get(i), parent, node);
					}
				}
			}
		}
	}

}
