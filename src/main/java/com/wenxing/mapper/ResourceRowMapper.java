package com.wenxing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wenxing.pojo.Resource;


public class ResourceRowMapper implements RowMapper<Resource> {

	@Override
	public Resource mapRow(ResultSet rs, int rowNum) throws SQLException {
		Resource resource = new Resource();
		resource.setId(rs.getInt("id"));
		resource.setStatus(rs.getInt("status"));
		resource.setLastupdated_by(rs.getInt("lastupdated_by"));
		resource.setLastupdated_ts(rs.getDate("lastupdated_ts"));
		
		resource.setRes_name(rs.getString("res_name"));
		resource.setUrl(rs.getString("url"));
		
		return resource;
	}
}
