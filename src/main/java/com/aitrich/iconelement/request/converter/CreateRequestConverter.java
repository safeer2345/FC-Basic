package com.aitrich.iconelement.request.converter;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.iconelement.model.IconElement;
import com.aitrich.iconelement.request.IconElementCreateRequest;

@ApplicationScoped
public class CreateRequestConverter {
	
	public IconElement convert(IconElementCreateRequest createRequest) throws IOException
	{
		return new IconElement(createRequest.getIconName(),createRequest.getIcon().readAllBytes(),createRequest.getParentId());
	}

}
