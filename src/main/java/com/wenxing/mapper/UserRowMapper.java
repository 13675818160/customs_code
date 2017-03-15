package com.wenxing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wenxing.pojo.User;


public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setStatus(rs.getInt("status"));
		user.setLastupdated_by(rs.getInt("lastupdated_by"));
		user.setLastupdated_ts(rs.getDate("lastupdated_ts"));
		user.setUser_name(rs.getString("user_name"));
		user.setCompany_id(rs.getInt("company_id"));
		user.setPassword(rs.getString("password"));
		user.setRole_id(rs.getInt("role_id"));
		user.setPhone(rs.getString("phone"));

		return user;
	}
}
