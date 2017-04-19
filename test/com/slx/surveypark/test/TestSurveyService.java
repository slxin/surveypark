package com.slx.surveypark.test;

import com.slx.surveypark.model.User;
import com.slx.surveypark.service.SurveyService;
import com.slx.surveypark.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by lenovo on 2016/11/26.
 */
public class TestSurveyService {

    private static SurveyService surveyService;

    @BeforeClass
    public static void iniSurveyService(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        surveyService=(SurveyService) context.getBean("surveyService");
    }
    //新建调查
    @Test
    public void newSurvey() throws SQLException {
        User user=new User();
        user.setId(8);
        surveyService.newSurvey(user);
    }
}
