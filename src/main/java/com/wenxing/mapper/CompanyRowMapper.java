package com.wenxing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wenxing.pojo.Company;


public class CompanyRowMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
		Company company = new Company();
		company.setId(rs.getInt("id"));
		company.setStatus(rs.getInt("status"));
		company.setLastupdated_by(rs.getInt("lastupdated_by"));
		company.setLastupdated_ts(rs.getDate("lastupdated_ts"));
		
		company.setCompany_name(rs.getString("company_name"));
		company.setCompany_type(rs.getInt("company_type"));
		company.setLeader(rs.getString("leader"));
		company.setLeader_phone(rs.getString("leader_phone"));
		company.setSalesman(rs.getString("salesman"));
		company.setSalesman_phone(rs.getString("salesman_phone"));
		
		return company;
	}
}
