package com.slx.surveypark.struts2.action;

import com.slx.surveypark.model.Survey;
import com.slx.surveypark.model.User;
import com.slx.surveypark.service.SurveyService;
import com.slx.surveypark.struts2.UserAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/1/5.
 */
@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware {

    private static final long serialVersionUID=9180917383072055589L;

    //注入SurveyService
    @Resource
    private SurveyService surveyService;

    //调查集合
    private List<Survey> mySurveys;

    //接收user对象
    private User user;

    private Integer sid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public List<Survey> getMySurveys() {
        return mySurveys;
    }

    public void setMySurveys(List<Survey> mySurveys) {
        this.mySurveys = mySurveys;
    }

    /*
    查询我的调查列表
     */
    public String mySurveys(){
        this.mySurveys=surveyService.findMySurveys(user);
        return "mySurveyListPage";
    }

    /*
    新建调查
     */
    public String newSurvey(){
        this.model=surveyService.newSurvey(user);
        return "designSurveyPage";

    }

    /*
    设计调查
     */
    public String designSurvey() {
        this.model = surveyService.getSurveyWithChildren(sid);
        return "designSurveyPage";
    }


    /*
    编辑调查
     */
    public String editSurvey(){
        this.model=surveyService.getSurvey(sid);
        return "editSurveyPage";
    }

    /*
    更新调查
     */
    public String updateSurvey(){
        this.sid=model.getId();
        //保持关联关系
        model.setUser(user);
        surveyService.updateSurvey(model);
        return "designSurveyPage";
    }


    //注入User对象
    @Override
    public void setUser(User user) {
        this.user=user;
    }
}
