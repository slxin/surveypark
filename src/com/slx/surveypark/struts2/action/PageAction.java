package com.slx.surveypark.struts2.action;

import com.slx.surveypark.model.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by lenovo on 2017/1/6.
 */
@Controller
@Scope("prototype")
public class PageAction extends BaseAction<Page>{
    private static final long serialVersionUID=9180917383072055589L;

    private Integer sid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /*
        到达添加page页面
         */
    public String toAddPage(){
        return "addPagePage";
    }
}
