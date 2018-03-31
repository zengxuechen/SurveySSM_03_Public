package com.atguigu.survey.entities.guest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 调查实体类
 * @author zhangyu
 *
 */
public class Survey implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer surveyId; //调查 id

	private String surveyName;//调查名称

	private Boolean completed = false; //是否完成调查 (调查设计完成时状态为已完成)

	private String logoPath = "res_static/logo.gif"; //调查图片

	private Integer userId; //创建调查的用户id

	private Set<Bag> bagSet = new HashSet<Bag>(); //包裹集合

	public Survey(Integer surveyId, String surveyName, Boolean completed,
			String logoPath) {
		super();
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.completed = completed;
		this.logoPath = logoPath;
	}

	public Survey(Integer surveyId) {
		super();
		this.surveyId = surveyId;
	}

	public Survey() {
		super();
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName == null ? null : surveyName.trim();
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath == null ? null : logoPath.trim();
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Set<Bag> getBagSet() {
		return bagSet;
	}

	public void setBagSet(Set<Bag> bagSet) {
		this.bagSet = bagSet;
	}

}