package com.slx.surveypark.model;

/**
 * Created by lenovo on 2016/11/26.
 */
//问题类
public class Question {
    private Integer id;
    //题型0-8
    private int questionType;
    //
    private String title;
    //选项
    private String options;
    //其他项
    private boolean other;
    //其他项样式：0-1无 1-文本框 2-下拉列表
    private int otherStyle;
    //其他向下拉选项
    private String otherSelectOptions;
    //矩阵式行标题集
    private String matrixRowTitles;
    //矩阵式列标题集
    private String matrixColTitles;
    //矩阵式下拉选项集
    private String matrixSelectOptions;
    //建立从question到page之间多对一的关联关系
    private Page page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    public int getOtherStyle() {
        return otherStyle;
    }

    public void setOtherStyle(int otherStyle) {
        this.otherStyle = otherStyle;
    }

    public String getOtherSelectOptions() {
        return otherSelectOptions;
    }

    public void setOtherSelectOptions(String otherSelectOptions) {
        this.otherSelectOptions = otherSelectOptions;
    }

    public String getMatrixRowTitles() {
        return matrixRowTitles;
    }

    public void setMatrixRowTitles(String matrixRowTitles) {
        this.matrixRowTitles = matrixRowTitles;
    }

    public String getMatrixColTitles() {
        return matrixColTitles;
    }

    public void setMatrixColTitles(String matrixColTitles) {
        this.matrixColTitles = matrixColTitles;
    }

    public String getMatrixSelectOptions() {
        return matrixSelectOptions;
    }

    public void setMatrixSelectOptions(String matrixSelectOptions) {
        this.matrixSelectOptions = matrixSelectOptions;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
