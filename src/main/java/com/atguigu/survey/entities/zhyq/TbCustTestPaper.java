package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbCustTestPaper Entity.
 */
public class TbCustTestPaper implements Serializable{
	
	//列信息
	private Integer id;
	
	private String testTypeCode;
	
	private String testTypeName;
	
	private String testPaperName;
	
	private String paperOnFlag;
	
	private String questionIds;
	
	private Integer creatorId;
	

		
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
		
		
	public void setTestPaperName(String value) {
		this.testPaperName = value;
	}
	
	public String getTestPaperName() {
		return this.testPaperName;
	}
		
		
	public void setPaperOnFlag(String value) {
		this.paperOnFlag = value;
	}
	
	public String getPaperOnFlag() {
		return this.paperOnFlag;
	}
		
		
	public void setQuestionIds(String value) {
		this.questionIds = value;
	}
	
	public String getQuestionIds() {
		return this.questionIds;
	}
		
		
	public void setCreatorId(Integer value) {
		this.creatorId = value;
	}
	
	public Integer getCreatorId() {
		return this.creatorId;
	}
		
}

