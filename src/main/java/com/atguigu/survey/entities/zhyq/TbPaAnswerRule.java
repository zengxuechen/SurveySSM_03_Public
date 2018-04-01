package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbPaAnswerRule Entity.
 */
public class TbPaAnswerRule implements Serializable{
	
	//列信息
	private Integer id;
	
	private String ruleTypeCode;
	
	private String ruleTypeName;
	
	private Integer questionId;
	
	private String option;
	
	private String answerBitmap;
	
	private String answerAnalysis;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setRuleTypeCode(String value) {
		this.ruleTypeCode = value;
	}
	
	public String getRuleTypeCode() {
		return this.ruleTypeCode;
	}
		
		
	public void setRuleTypeName(String value) {
		this.ruleTypeName = value;
	}
	
	public String getRuleTypeName() {
		return this.ruleTypeName;
	}
		
		
	public void setQuestionId(Integer value) {
		this.questionId = value;
	}
	
	public Integer getQuestionId() {
		return this.questionId;
	}
		
		
	public void setOption(String value) {
		this.option = value;
	}
	
	public String getOption() {
		return this.option;
	}
		
		
	public void setAnswerBitmap(String value) {
		this.answerBitmap = value;
	}
	
	public String getAnswerBitmap() {
		return this.answerBitmap;
	}
		
		
	public void setAnswerAnalysis(String value) {
		this.answerAnalysis = value;
	}
	
	public String getAnswerAnalysis() {
		return this.answerAnalysis;
	}
		
}

