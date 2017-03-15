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
import com.wenxing.mapper.AppformRowMapper;
import com.wenxing.pojo.Appform;

@Repository
public class AppformRepository {
	
	@Autowired  
    private JdbcTemplate jdbcTemplate;  
	
    @Transactional(readOnly = true)  
    public List<Appform> findAll() {  
        return jdbcTemplate.query("select * from appform", new AppformRowMapper());  
    }  
    
    
    public Appform create(final Appform appform) {  
        final String sql = "insert into appform(appform_id,appform_code,appform_type,appform_status) values(?,?,?,?)";  
  
        KeyHolder holder = new GeneratedKeyHolder();  
  
        jdbcTemplate.update(new PreparedStatementCreator() {  
			@Override
			public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
                return ps;  
			}  
        }, holder);  
  
        int newAppformId = holder.getKey().intValue();  
        appform.setId(newAppformId);  
        return appform;  
    }  
    
    public void delete(final Integer id) {  
        final String sql = "delete from appforms where id=?";  
        jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });  
    }  
  
    public void update(final Appform appform) {  
//        jdbcTemplate.update("update appforms set appform_status=? where id=?",  
//                new Object[] { appform.getAppform_status(),appform.getId() });  
    }  
}
