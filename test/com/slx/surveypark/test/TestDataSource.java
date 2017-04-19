package com.slx.surveypark.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * Created by lenovo on 2017/1/4.
 */
/*测试数据源*/
public class TestDataSource {
    @Test
    public void getConnection() throws SQLException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        DataSource dataSource=(DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());

    }
}
