package com.wenxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenxing.base.BizException;
import com.wenxing.pojo.Resource;
import com.wenxing.pojo.Role;
import com.wenxing.pojo.User;
import com.wenxing.repository.RoleRepository;
import com.wenxing.service.RoleService;

@Service
public class RoleServiceImpl  implements RoleService {
	
	private final RoleRepository roleRepository;
	

	/**
	 * 装载roleRepository
	 * 
	 * @param roleRepository
	 */
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> getList() {
		return roleRepository.findAll();
	}

	@Override
	public List<Resource> getResourceListByUser(User user) {
		
		return roleRepository.queryResByIds(null);
	}
    
}
