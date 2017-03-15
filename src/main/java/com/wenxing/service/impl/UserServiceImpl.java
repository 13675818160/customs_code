package com.wenxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenxing.pojo.User;
import com.wenxing.repository.UserRepository;
import com.wenxing.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	

	/**
	 * 装载userRepository
	 * 
	 * @param userRepository
	 */
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getList() {
		return userRepository.findAll();
	}

/*    @Autowired
    UserLoginStatusMapper userLoginStatusMapper;

    @Override
    public Boolean userIsLogin(ReqParameter reqParameter) throws BizException{
        if(TextUtils.isBlank(reqParameter.getUserid()) || TextUtils.isBlank(reqParameter.getUuid())){
            throw new BizException(BizException.CODE_LACK_PARM, "【userid,uuid】为必须参数！");
        }

        UserLoginStatus userLoginStatus = userLoginStatusMapper.selectByPrimaryKey(reqParameter.getUuid());
        if(null == userLoginStatus || null == userLoginStatus.getUid() || !userLoginStatus.getUid().equals(reqParameter.getUserid()))
            throw new BizException(BizException.CODE_NO_LONIN,"【userid未在uuid登录】！");

        return true;

    }*/
}
