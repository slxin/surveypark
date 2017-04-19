package com.slx.surveypark.service.impl;

import com.slx.surveypark.dao.BaseDao;
import com.slx.surveypark.model.User;
import com.slx.surveypark.service.UserService;
import com.slx.surveypark.util.ValidateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/11/26.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource(name="userDao")
    public void setBaseDao(BaseDao<User> baseDao) {
        super.setBaseDao(baseDao);
    }


    //判断email是否占用
    @Override
    public boolean isRegisted(String email) {
        String hql="from User u where u.email=?";
        List<User> list=this.findEntityByHQL(hql,email);
        return ValidateUtil.isValid(list);
    }

    @Override
    public User ValidateLoginInfo(String email,String md5){
        String hql="from User u where u.email=? and u.password=?";
        List<User> list=this.findEntityByHQL(hql,email,md5);
        return ValidateUtil.isValid(list)?list.get(0):null;
    }
}
