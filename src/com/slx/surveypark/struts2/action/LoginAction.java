package com.slx.surveypark.struts2.action;

import com.slx.surveypark.model.User;
import com.slx.surveypark.service.UserService;
import com.slx.surveypark.util.DataUtil;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lenovo on 2016/11/29.
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware {

    private static final long serialVersionUID=9180917383072055589L;

    //接收session的map
    private Map<String ,Object> sessionMap;
    @Resource
    private UserService userService;


    //到达登陆页面
    public String toLoginPage(){
        return "loginPage";
    }

    //进行登录处理
    public String doLogin(){
        return "success";
    }

    //校验登录信息
    public void validateDoLogin(){
        User user= userService.ValidateLoginInfo(model.getEmail(), DataUtil.md5(model.getPassword()));
        //User user= userService.ValidateLoginInfo(model.getEmail(), model.getPassword());
        if(user==null){
            addActionError("email/密码错误");
        }else{
            sessionMap.put("user",user);
        }
    }

    //注入session的map
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap=map;
    }
}
