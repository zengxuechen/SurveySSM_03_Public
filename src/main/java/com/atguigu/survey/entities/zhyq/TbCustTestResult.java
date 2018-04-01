package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbCustTestResult Entity.
 */
public class TbCustTestResult implements Serializable{
	
	//列信息
	private Integer id;
	
	private String testUserId;
	
	private String testTypeId;
	
	private String testResult;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setTestUserId(String value) {
		this.testUserId = value;
	}
	
	public String getTestUserId() {
		return this.testUserId;
	}
		
		
	public void setTestTypeId(String value) {
		this.testTypeId = value;
	}
	
	public String getTestTypeId() {
		return this.testTypeId;
	}
		
		
	public void setTestResult(String value) {
		this.testResult = value;
	}
	
	public String getTestResult() {
		return this.testResult;
	}
		
}

