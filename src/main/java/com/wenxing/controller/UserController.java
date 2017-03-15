package com.wenxing.controller;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenxing.pojo.User;
import com.wenxing.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> getUserList(){
        logger.info("从数据库读取list");
        return userService.getList();
    }
}
