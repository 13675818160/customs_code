package com.wenxing.service;

import java.util.List;

import com.wenxing.base.BizException;
import com.wenxing.pojo.Company;
import com.wenxing.pojo.ReqParameter;
import com.wenxing.pojo.Role;
import com.wenxing.pojo.User;

/**
 */
public interface CompanyService {
    
    public List<Company> getList();
}
