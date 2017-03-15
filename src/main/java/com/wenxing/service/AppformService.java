package com.wenxing.service;

import java.util.List;

import com.wenxing.base.BizException;
import com.wenxing.pojo.Appform;
import com.wenxing.pojo.ReqParameter;
import com.wenxing.pojo.User;

/**
 */
public interface AppformService {

    public List<Appform> getAppformList();
    
    public boolean saveAppform(Appform appform,User optr);
}
