package com.slx.surveypark.struts2.action;

import com.slx.surveypark.model.User;
import com.slx.surveypark.service.UserService;
import com.slx.surveypark.util.DataUtil;
import com.slx.surveypark.util.ValidateUtil;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2016/11/27.
 */
//注册action
@Controller(value="regAction")
@Scope("prototype")
public class RegAction extends BaseAction<User> {

    private static final long serialVersionUID=9180917383072055589L;
    

    @Resource
    private UserService userService;

    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }



    //到达注册页面
    @SkipValidation
    public String toRegPage(){
        return "regPage";
    }

    //进行用户注册
    public String doReg(){
        //密码加密
        model.setPassword(DataUtil.md5(model.getPassword()));
        userService.saveEntity(model);
        return SUCCESS;
        /*return "success";*/
    }

    //校验
    public void validate(){
        //1非空
        if(!ValidateUtil.isValid(model.getEmail())){
            addFieldError("email","email是必填项");
        }
        if(!ValidateUtil.isValid(model.getPassword())){
            addFieldError("password","password是必填项");
        }
        if(!ValidateUtil.isValid(model.getNickName())){
            addFieldError("nickName","nickName是必填项");
        }
        if(hasErrors()){
            return;
        }
        //2密码一致性
        if(!model.getPassword().equals(confirmPassword)){
            addFieldError("password","密码不一致");
            return ;
        }
        //3email占用
        if(userService.isRegisted(model.getEmail())){
            addFieldError("email","email已占用！");
        }
    }
}
