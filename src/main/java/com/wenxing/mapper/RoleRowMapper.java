package com.wenxing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wenxing.pojo.Role;


public class RoleRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setId(rs.getInt("id"));
		role.setStatus(rs.getInt("status"));
		role.setLastupdated_by(rs.getInt("lastupdated_by"));
		role.setLastupdated_ts(rs.getDate("lastupdated_ts"));
		
		role.setRole_name(rs.getString("role_name"));
		role.setRes_ids(rs.getString("res_ids"));
		
		return role;
	}
}
