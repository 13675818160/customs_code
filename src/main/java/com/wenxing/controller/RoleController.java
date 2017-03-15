package com.wenxing.controller;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.BaseController;
import com.wenxing.pojo.Resource;
import com.wenxing.pojo.Role;
import com.wenxing.pojo.User;
import com.wenxing.service.RoleService;
import com.wenxing.service.UserService;


@RestController
@RequestMapping("/role")
public class RoleController extends BaseController{

	private static Log logger = LogFactory.getLog(RoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public List<Role> getRoleList(){
        logger.info("从数据库读取list");
        return roleService.getList();
    }
    
    @RequestMapping("/menulist")
    public List<Resource> getResList(){
        logger.info("从数据库读取list");
        return roleService.getResourceListByUser(null);
    }
}
