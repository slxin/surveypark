package com.slx.surveypark.service;

import com.slx.surveypark.model.Survey;
import com.slx.surveypark.model.User;

import java.util.List;

/**
 * Created by lenovo on 2017/1/5.
 */
public interface SurveyService {

     //查询调查列表
     List<Survey> findMySurveys(User user);

     //新建调查
     Survey newSurvey(User user);

     //按照id查询Survey
     Survey getSurvey(Integer sid);

     //按照id查询Survey，同时携带所有的孩子
     Survey getSurveyWithChildren(Integer sid);

     //更新调查
     void updateSurvey(Survey model);

}