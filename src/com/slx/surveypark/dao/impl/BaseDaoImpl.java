package com.slx.surveypark.dao.impl;

import java.lang.reflect.ParameterizedType;
import com.slx.surveypark.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/11/26.
 */
//抽象的dao实现，专门用于继承
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    //注入sessionFactory
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    public BaseDaoImpl() {
        //得到泛型化超类
        ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
        clazz=(Class<T>) type.getActualTypeArguments()[0];
    }

    @Override
    public void saveEntity(Object o) {
        sessionFactory.getCurrentSession().save(o);
       /* sessionFactory.openSession().save(o);*/
    }

    @Override
    public void saveOrUpdateEntity(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);


    }

    @Override
    public void updateEntity(Object o) {
        sessionFactory.getCurrentSession().update(o);

    }

    @Override
    public void deleteEntity(Object o) {
        sessionFactory.getCurrentSession().delete(o);

    }

    /*
    按照HQL语句进行批量更新
     */
    @Override
    public void batchEntityByHQL(String hql, Object... objects) {
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        for(int i=0;i<objects.length;i++){
            query.setParameter(i,objects[i]);
        }
        query.executeUpdate();

    }

    @Override
    public T loadEntity(Integer id) {
        return (T)sessionFactory.getCurrentSession().load(clazz,id);
    }

    @Override
    public T getEntity(Integer id) {
        return (T)sessionFactory.getCurrentSession().get(clazz,id);
    }

    @Override
    public List findEntityByHQL(String hql, Object... objects) {
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        for(int i=0;i<objects.length;i++){
            query.setParameter(i,objects[i]);
        }
        return query.list();
    }
}
