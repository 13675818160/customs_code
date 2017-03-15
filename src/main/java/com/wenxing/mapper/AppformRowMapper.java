package com.wenxing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wenxing.pojo.Appform;


public class AppformRowMapper implements RowMapper<Appform> {

	@Override
	public Appform mapRow(ResultSet rs, int rowNum) throws SQLException {
		Appform appform = new Appform();
		appform.setId(rs.getInt("id"));
		appform.setStatus(rs.getInt("status"));
		appform.setLastupdated_by(rs.getInt("lastupdated_by"));
		appform.setLastupdated_ts(rs.getDate("lastupdated_ts"));
		
		appform.setAgent_id(rs.getInt("agent_id"));
		appform.setBaoguan_num(rs.getString("baoguan_num"));
		appform.setBaoguan_comp_id(rs.getInt("baoguan_comp_id"));
		appform.setChedui(rs.getString("chedui"));
		appform.setContainer_account(rs.getInt("container_account"));
		appform.setForm_status(rs.getString("form_status"));
		appform.setHarbour(rs.getString("harbour"));
		appform.setHuodai_comp_id(rs.getInt("huodai_comp_id"));
		appform.setPackage_type(rs.getString("package_type"));
		appform.setProd_name(rs.getString("prod_name"));
		appform.setSource_area(rs.getString("source_area"));
		appform.setTiyun_num(rs.getString("tiyun_num"));
		appform.setTotal_count(rs.getInt("total_count"));
		appform.setTotal_weight(rs.getInt("total_weight"));
		appform.setWarehouse(rs.getString("warehouse"));
		appform.setXiangzhu(rs.getString("xiangzhu"));
		appform.setZhuanguan_num(rs.getString("zhuanguan_num"));
		
		return appform;
	}
}
