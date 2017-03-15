package com.wenxing.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wenxing.pojo.Appform;
import com.wenxing.service.AppformService;


@RestController
@RequestMapping("/appform")
public class AppformController {

	private static Log logger = LogFactory.getLog(AppformController.class);

    @Autowired
    private AppformService appformService;

    @RequestMapping("/list")
    public List<Appform> getAppformList(){
        return appformService.getAppformList();
    }
    
	@ResponseBody
	public Map<String,Object> createAppform(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		return resultMap;
	}
}
