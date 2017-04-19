package com.slx.surveypark.service;

import com.slx.surveypark.model.User;

/**
 * Created by lenovo on 2016/11/26.
 */
public interface UserService extends BaseService<User> {

    //判断email是否占用
    public boolean isRegisted(String email);

    //验证登录信息
    User ValidateLoginInfo(String email, String md5);
}
