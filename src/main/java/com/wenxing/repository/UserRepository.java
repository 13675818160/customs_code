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
import com.wenxing.mapper.UserRowMapper;
import com.wenxing.pojo.User;

@Repository
public class UserRepository {
	
	@Autowired  
    private JdbcTemplate jdbcTemplate;  
	
    @Transactional(readOnly = true)  
    public List<User> findAll() {  
        return jdbcTemplate.query("select * from user", new UserRowMapper());  
    }  
    
    
    public User create(final User user) {  
        final String sql = "insert into user(user_name,company_id,role_id,password,phone) values(?,?,?,?,?)";  
  
        KeyHolder holder = new GeneratedKeyHolder();  
  
        jdbcTemplate.update(new PreparedStatementCreator() {  
			@Override
			public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
                ps.setString(1, user.getUser_name());  
                ps.setInt(2, user.getCompany_id());  
                ps.setInt(3, user.getRole_id());  
                ps.setString(1, user.getPassword());
                ps.setString(1, user.getPhone());
                return ps;  
			}  
        }, holder);  
  
        int newUserId = holder.getKey().intValue();  
        user.setId(newUserId);  
        return user;  
    }  
    
    public void delete(final Integer id) {  
        final String sql = "delete from users where id=?";  
        jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });  
    }  
  
    public void update(final User user) {  
        jdbcTemplate.update("update users set user_name=?,company_id=?,role_id=?, password=?,phone=?  where id=?",  
                new Object[] { user.getUser_name(), user.getCompany_id(), user.getRole_id(),user.getPassword(),user.getPhone(),user.getId() });  
    }  
}
