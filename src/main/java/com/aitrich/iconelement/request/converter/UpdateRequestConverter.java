package com.aitrich.iconelement.request.converter;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.iconelement.model.IconElement;

import com.aitrich.iconelement.request.IconElementupdateRequest;

@ApplicationScoped
public class UpdateRequestConverter {
	
	public IconElement convert(IconElementupdateRequest iconElementupdateRequest) throws IOException
	{
		return new IconElement(iconElementupdateRequest.getId(),iconElementupdateRequest.getIconName(),iconElementupdateRequest.getIcon().readAllBytes(),iconElementupdateRequest.getParentId());
	}

}
