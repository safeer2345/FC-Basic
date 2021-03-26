package com.aitrich.iconelement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.aitrich.iconelement.model.IconElement;
import com.aitrich.iconelement.request.IconElementCreateRequest;
import com.aitrich.iconelement.request.IconElementupdateRequest;

import io.smallrye.mutiny.Uni;
//import io.vertx.mutiny.pgclient.PgPool;

//import io.vertx.mutiny.sqlclient.Tuple;

@ApplicationScoped
public class IconElementRepository {

	
	  //@Inject PgPool pgPool;
	 
	  @Inject DataSource dataSource;
		 

	public int saveIconELement(IconElement iconElement) throws IOException, SQLException {
//		return pgPool.preparedQuery("insert into icon_element values($1,$2,$3)")
//				.execute(Tuple.of(iconElementRequest.getIconId(), iconElementRequest.getIcon().readAllBytes())).onItem().transform(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
		Connection connection=dataSource.getConnection();
		PreparedStatement statement=connection.prepareStatement("insert into icon_element(icon_name,icon_image,parent_id)values(?,?,?)");
		statement.setString(1, iconElement.getName());
		statement.setBytes(2, iconElement.getIconImage());
		statement.setLong(3, iconElement.getParentId());
		int status=statement.executeUpdate();
		
		statement.close();
		connection.close();
		
		return status;
	}
	
	public int updateIconELement(IconElement iconElement,int iconElementId) throws SQLException
	{
		Connection connection=dataSource.getConnection();
		PreparedStatement statement=connection.prepareStatement("update icon_element set icon_name=?,icon_image=?,parent_id=? where id=?");
		statement.setString(1, iconElement.getName());
		statement.setBytes(2, iconElement.getIconImage());
		statement.setLong(3, iconElement.getParentId());
		statement.setInt(4, iconElementId);
		return statement.executeUpdate();
	}
	
	public int deleteByIconELementId(int iconElementId) throws SQLException
	{
		Connection connection=dataSource.getConnection();
		PreparedStatement statement=connection.prepareStatement("delete from icon_element where id=?");
		statement.setInt(1, iconElementId);
		return statement.executeUpdate();
	}
	
	public List<IconElement> findByIconElementId(int iconElementId) throws SQLException
	{
		
		Connection connection=dataSource.getConnection();
		PreparedStatement statement=connection.prepareStatement("with recursive children as(select id,icon_name,icon_image,parent_id from icon_element where id=? union select ii.id,ii.icon_name,ii.icon_image,ii.parent_id from icon_element ii inner join children c on c.id=ii.parent_id) select * from children;");
		statement.setInt(1, iconElementId);
		ResultSet rs=statement.executeQuery();
		
		List<IconElement> iconElementList=new ArrayList<IconElement>();
		
		while (rs.next()) {
			
			iconElementList.add(new IconElement(rs.getInt(1),rs.getString(2),rs.getBytes(3),rs.getLong(4)));
		}
		/* order by parent_id desc */
		return iconElementList;
	}
	
	public List<IconElement> findAllIconELement() throws SQLException
	{
		Connection connection=dataSource.getConnection();
		PreparedStatement statement=connection.prepareStatement("with recursive children as(select id,icon_name,icon_image,parent_id from icon_element union select ii.id,ii.icon_name,ii.icon_image,ii.parent_id from icon_element ii inner join children c on c.id=ii.parent_id) select * from children;");
		ResultSet rs=statement.executeQuery();
		
		List<IconElement> iconElementList=new ArrayList<IconElement>();
		while (rs.next()) {
			
			iconElementList.add(new IconElement(rs.getInt(1),rs.getString(2),rs.getLong(4))); 
		}
		return iconElementList;
	}
	
	
	
	
	

}
