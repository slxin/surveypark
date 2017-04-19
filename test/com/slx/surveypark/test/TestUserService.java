package com.slx.surveypark.test;

import com.slx.surveypark.model.User;
import com.slx.surveypark.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by lenovo on 2016/11/26.
 */
public class TestUserService {

    private static UserService userService;

    @BeforeClass
    public static void iniUserService(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        userService=(UserService) context.getBean("userService");
    }
    //插入用户
    @Test
    public void insertUser() throws SQLException {
        User user=new User();
        user.setEmail("xupccc@hotmail.com");
        user.setPassword("123456");
        user.setName("xupccc");
        userService.saveEntity(user);
    }
}
