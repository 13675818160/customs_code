package com.wenxing.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Statement;
import com.wenxing.mapper.CompanyRowMapper;
import com.wenxing.pojo.Company;

@Repository
public class CompanyRepository {
	
	@Autowired  
    private JdbcTemplate jdbcTemplate;  
	
    @Transactional(readOnly = true)  
    public List<Company> findAll() {  
        return jdbcTemplate.query("select * from company", new CompanyRowMapper());  
    }  
    
    
    public Company create(final Company company) {  
        final String sql = "insert into companys(company_name,company_type,leader,leader_phone,salesman,salesman_phone) values(?,?,?,?,?,?)";  
  
        KeyHolder holder = new GeneratedKeyHolder();  
  
        jdbcTemplate.update(new PreparedStatementCreator() {  
			@Override
			public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
                ps.setString(1, company.getCompany_name());  
                ps.setInt(2, company.getCompany_type());  
                ps.setString(3, company.getLeader()); 
                ps.setString(4, company.getLeader_phone()); 
                ps.setString(5, company.getSalesman()); 
                ps.setString(6, company.getSalesman_phone()); 
                
                return ps;  
			}  
        }, holder);  
  
        int newCompanyId = holder.getKey().intValue();  
        company.setId(newCompanyId);  
        return company;  
    }  
    
    public void delete(final Integer id) {  
        final String sql = "delete from companys where id=?";  
        jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });  
    }  
  
    public void update(final Company company) {  
        jdbcTemplate.update("update companys set company_name=?,company_type=?,leader=?,leader_phone=?,salesman=?,salesman_phone=? where id=?",  
                new Object[] { company.getCompany_name(), company.getCompany_type(), company.getLeader(), company.getLeader_phone(), company.getSalesman(), company.getSalesman_phone(), company.getId() });  
    }  
}
