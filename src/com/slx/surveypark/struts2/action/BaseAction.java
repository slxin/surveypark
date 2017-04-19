package com.slx.surveypark.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.lang.reflect.ParameterizedType;


/**
 * Created by lenovo on 2016/11/27.
 */
//抽象action，专门用于继承
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>,Preparable {

    private static final long serialVersionUID=9180917383072055589L;

    public T model;

    public BaseAction(){
        try {
            ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
            Class clazz=(Class) type.getActualTypeArguments()[0];
            model =(T)clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getModel(){
        return model;
    };

    @Override
    public void prepare() throws Exception {

    }
}
