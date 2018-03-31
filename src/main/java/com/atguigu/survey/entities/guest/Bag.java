package com.atguigu.survey.entities.guest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 包裹实体类:一个包裹含有多个问题
 * @author zhangyu
 *
 */
public class Bag implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer bagId; //包裹id

    private String bagName; //包裹名称

    private Integer bagOrder = 1 ; //包裹序号

    private Integer surveyId ;  //调查id
    
    private Set<Question> questionSet = new HashSet<Question>(); //问题集合

    public Integer getBagId() {
        return bagId;
    }

    public void setBagId(Integer bagId) {
        this.bagId = bagId;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName == null ? null : bagName.trim();
    }

    public Integer getBagOrder() {
        return bagOrder;
    }

    public void setBagOrder(Integer bagOrder) {
        this.bagOrder = bagOrder;
    }

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Set<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}

}