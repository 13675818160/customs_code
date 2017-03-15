package com.wenxing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wenxing.pojo.Container;


public class ContainerRowMapper implements RowMapper<Container> {

	@Override
	public Container mapRow(ResultSet rs, int rowNum) throws SQLException {
		Container container = new Container();
		container.setId(rs.getInt("id"));
		container.setStatus(rs.getInt("status"));
		container.setLastupdated_by(rs.getInt("lastupdated_by"));
		container.setLastupdated_ts(rs.getDate("lastupdated_ts"));
		
		container.setContainer_code(rs.getString("container_code"));
		container.setContainer_status(rs.getString("container_status"));
		container.setContainer_type(rs.getString("container_type"));
		container.setAppform_id(rs.getInt("appform_id"));

		return container;
	}
}
