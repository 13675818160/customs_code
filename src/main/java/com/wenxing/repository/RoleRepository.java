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
import com.wenxing.mapper.ResourceRowMapper;
import com.wenxing.mapper.RoleRowMapper;
import com.wenxing.pojo.Resource;
import com.wenxing.pojo.Role;

@Repository
public class RoleRepository {
	
	@Autowired  
    private JdbcTemplate jdbcTemplate;  
	
    @Transactional(readOnly = true)  
    public List<Role> findAll() {  
        return jdbcTemplate.query("select * from role where status=1", new RoleRowMapper());  
    }  
    
    public Role findByKey(Integer key) {
    	List<Role> roleList = jdbcTemplate.query("select * from role where status=1 and id=?", new Object[]{key}, new RoleRowMapper());
        return  roleList== null  ? null : roleList.get(0) ;
    } 
    
    public List<Resource> queryResByIds(String[] resIdList){
    	String sql = "select * from resource where status=1 ";
    	return jdbcTemplate.query(sql, new ResourceRowMapper());  
    }
    
    
    public Role create(final Role role) {  
        final String sql = "insert into roles(role_name,res_ids) values(?,?)";  
  
        KeyHolder holder = new GeneratedKeyHolder();  
  
        jdbcTemplate.update(new PreparedStatementCreator() {  
			@Override
			public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
                ps.setString(1, role.getRole_name());  
                ps.setString(2, role.getRes_ids());  
                return ps;  
			}  
        }, holder);  
  
        int newRoleId = holder.getKey().intValue();  
        role.setId(newRoleId);  
        return role;  
    }  
    
    public void delete(final Integer id) {  
        final String sql = "delete from roles where id=?";  
        jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });  
    }  
  
    public void update(final Role role) {  
        jdbcTemplate.update("update roles set role_name=?,res_ids=? where id=?",  
                new Object[] { role.getRole_name(), role.getRes_ids(), role.getId() });  
    }  
}
