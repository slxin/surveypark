package com.slx.surveypark.service.impl;

import com.slx.surveypark.dao.BaseDao;
import com.slx.surveypark.model.Page;
import com.slx.surveypark.model.Survey;
import com.slx.surveypark.model.User;
import com.slx.surveypark.service.SurveyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/1/5.
 */
@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {

    @Resource(name="surveyDao")
    private BaseDao<Survey> surveyDao;

    @Resource(name="pageDao")
    private BaseDao<Page> pageDao;
    /*
    查询调查集合
     */
    @Override
    public List<Survey> findMySurveys(User user) {
        String hql="from Survey s where s.user.id=?";
        return surveyDao.findEntityByHQL(hql,user.getId());
    }

    //新建调查
    @Override
    public Survey newSurvey(User user) {
        Survey survey=new Survey();
        Page page=new Page();

        //设置关联关系
        survey.setUser(user);
        page.setSurvey(survey);
        survey.getPages().add(page);

        surveyDao.saveEntity(survey);
        pageDao.saveEntity(page);
        return survey;
    }

    //按照id查询survey
    @Override
    public Survey getSurvey(Integer sid) {
        return surveyDao.getEntity(sid);
    }

    //按照id查询Survey，同时携带所有的孩子
    @Override
    public Survey getSurveyWithChildren(Integer sid){
        //Survey survey=surveyDao.getEntity(sid);
        Survey survey=this.getSurvey(sid);
        //强行初始化pages和questions集合
        for(Page page:survey.getPages()){
            page.getQuestions().size();
        }
        return survey;
    }

    @Override
    public void updateSurvey(Survey model) {
        surveyDao.updateEntity(model);

    }
}
