package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbSelectQuestionLib Entity.
 */
public class TbSelectQuestionLib implements Serializable{
	
	//列信息
	private Integer id;
	
	private String testTypeCode;
	
	private String testTypeName;
	
	private String questionTypeCode;
	
	private String questionTypeName;
	
	private String questionContent;
	
	private String options;
	
	private String optionsBitmap;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setTestTypeCode(String value) {
		this.testTypeCode = value;
	}
	
	public String getTestTypeCode() {
		return this.testTypeCode;
	}
		
		
	public void setTestTypeName(String value) {
		this.testTypeName = value;
	}
	
	public String getTestTypeName() {
		return this.testTypeName;
	}
		
		
	public void setQuestionTypeCode(String value) {
		this.questionTypeCode = value;
	}
	
	public String getQuestionTypeCode() {
		return this.questionTypeCode;
	}
		
		
	public void setQuestionTypeName(String value) {
		this.questionTypeName = value;
	}
	
	public String getQuestionTypeName() {
		return this.questionTypeName;
	}
		
		
	public void setQuestionContent(String value) {
		this.questionContent = value;
	}
	
	public String getQuestionContent() {
		return this.questionContent;
	}
		
		
	public void setOptions(String value) {
		this.options = value;
	}
	
	public String getOptions() {
		return this.options;
	}
		
		
	public void setOptionsBitmap(String value) {
		this.optionsBitmap = value;
	}
	
	public String getOptionsBitmap() {
		return this.optionsBitmap;
	}
		
}

