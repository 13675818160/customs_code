package com.wenxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenxing.base.BizException;
import com.wenxing.pojo.Appform;
import com.wenxing.pojo.User;
import com.wenxing.pojo.Appform;
import com.wenxing.repository.AppformRepository;
import com.wenxing.service.AppformService;
import com.wenxing.service.AppformService;

@Service
public class AppformServiceImpl  implements AppformService {
	
	private final AppformRepository appformRepository;
	

	/**
	 * 装载appformRepository
	 * 
	 * @param appformRepository
	 */
	@Autowired
	public AppformServiceImpl(AppformRepository appformRepository) {
		this.appformRepository = appformRepository;
	}
	

	@Override
	public List<Appform> getAppformList() {
		return appformRepository.findAll();
	}


	@Override
	public boolean saveAppform(Appform appform, User optr) {
		 appformRepository.create(appform);
		 return true;
	}

    
}
