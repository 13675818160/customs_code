package com.wenxing.controller;

import com.wenxing.pojo.ReqParameter;

/**
 * Created by maobg on 2015/7/7.
 */
public class RequestFacade {

    private  static ThreadLocal<ReqParameter> threadLocal = new ThreadLocal<ReqParameter>();

    public static void setParameters(ReqParameter parameterInfo)
    {
        threadLocal.set(parameterInfo);
    }

    public static ReqParameter getParameters(){
        return threadLocal.get();
    }
}
