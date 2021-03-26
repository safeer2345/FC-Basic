package com.aitrich.iconelement;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.aitrich.iconelement.model.IconElement;
import com.aitrich.iconelement.model.IconElementRoot;
import com.aitrich.iconelement.request.IconElementCreateRequest;
import com.aitrich.iconelement.request.IconElementupdateRequest;
import com.aitrich.iconelement.request.converter.CreateRequestConverter;
import com.aitrich.iconelement.request.converter.UpdateRequestConverter;

import io.smallrye.mutiny.Uni;

@Path("/iconelement")
public class IconElementResourseEndpoint {
	
	@Inject
	IconElementService service;
	
	@Inject
	CreateRequestConverter createRequestConverter;
	
	@Inject
	UpdateRequestConverter updateRequestConverter;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public IconElement findByIconElementId(@PathParam int id) throws SQLException 
    {
    	return service.findByIconElementId(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public int saveIconELement(@MultipartForm IconElementCreateRequest multipartBody) throws IOException, SQLException
    {	
    	return service.saveIconELement(createRequestConverter.convert(multipartBody));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public IconElementRoot findAllIconElement() throws SQLException 
    {
    	return service.findAllIconELement();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public IconElement updateIconELement(@MultipartForm IconElementupdateRequest multipartBody,@PathParam int id) throws IOException, SQLException
    {	
    	return service.updateIconELement(updateRequestConverter.convert(multipartBody),id);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteByIconElementId(@PathParam int id) throws SQLException 
    {
    	service.deleteByIconELementId(id);
    }
    
    
}