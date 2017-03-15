package com.wenxing.service;

import java.util.List;

import com.wenxing.base.BizException;
import com.wenxing.pojo.ReqParameter;
import com.wenxing.pojo.Resource;
import com.wenxing.pojo.Role;
import com.wenxing.pojo.User;

/**
 */
public interface RoleService {

    /**
     * 调用user-server判断用户是否登录
     * @param reqParameter
     * @return
     * @throws BizException
     */
//    Boolean userIsLogin(ReqParameter reqParameter) throws BizException;
    
    public List<Role> getList();
    
    public List<Resource> getResourceListByUser(User user);
}
