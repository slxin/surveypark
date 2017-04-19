package com.slx.surveypark.service;

import java.util.List;

/**
 * Created by lenovo on 2016/11/26.
 */
public interface BaseService<T> {
    //写操作
    void saveEntity(T t);
    void saveOrUpdateEntity(T t);
    void updateEntity(T t);
    void deleteEntity(T t);
    void batchEntityByHQL(String hql, Object... objects);

    //读操作
    T loadEntity(Integer id);
    T getEntity(Integer id);
    List<T> findEntityByHQL(String hql, Object... objects);
}
