package com.slx.surveypark.service.impl;

import com.slx.surveypark.dao.BaseDao;
import com.slx.surveypark.service.BaseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/11/26.
 */
//抽象的baseService，专门用于继承
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> baseDao;
    //注入dao
    @Resource
    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void saveEntity(T t) {
        baseDao.saveEntity(t);

    }

    @Override
    public void saveOrUpdateEntity(T t) {
        baseDao.saveOrUpdateEntity(t);

    }

    @Override
    public void updateEntity(T t) {
        baseDao.updateEntity(t);

    }

    @Override
    public void deleteEntity(T t) {
        baseDao.deleteEntity(t);

    }

    @Override
    public void batchEntityByHQL(String hql, Object... objects) {
        baseDao.batchEntityByHQL(hql,objects);

    }

    @Override
    public T loadEntity(Integer id) {
        return baseDao.loadEntity(id);
    }

    @Override
    public T getEntity(Integer id) {
        return baseDao.getEntity(id);
    }

    @Override
    public List<T> findEntityByHQL(String hql, Object... objects) {
        return baseDao.findEntityByHQL(hql,objects);
    }
}
