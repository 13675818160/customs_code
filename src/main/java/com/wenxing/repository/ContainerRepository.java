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
import com.wenxing.mapper.ContainerRowMapper;
import com.wenxing.pojo.Container;

@Repository
public class ContainerRepository {
	
	@Autowired  
    private JdbcTemplate jdbcTemplate;  
	
    @Transactional(readOnly = true)  
    public List<Container> findAll() {  
        return jdbcTemplate.query("select * from container", new ContainerRowMapper());  
    }  
    
    
    public Container create(final Container container) {  
        final String sql = "insert into container(appform_id,container_code,container_type,container_status) values(?,?,?,?)";  
  
        KeyHolder holder = new GeneratedKeyHolder();  
  
        jdbcTemplate.update(new PreparedStatementCreator() {  
			@Override
			public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
                ps.setInt(1, container.getAppform_id());  
                ps.setString(2, container.getContainer_code());  
                ps.setString(3, container.getContainer_type());
                ps.setString(4, container.getContainer_status());
                return ps;  
			}  
        }, holder);  
  
        int newContainerId = holder.getKey().intValue();  
        container.setId(newContainerId);  
        return container;  
    }  
    
    public void delete(final Integer id) {  
        final String sql = "delete from containers where id=?";  
        jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });  
    }  
  
    public void update(final Container container) {  
        jdbcTemplate.update("update containers set container_status=? where id=?",  
                new Object[] { container.getContainer_status(),container.getId() });  
    }  
}
