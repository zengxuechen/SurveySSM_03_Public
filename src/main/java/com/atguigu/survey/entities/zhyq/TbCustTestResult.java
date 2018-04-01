package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbCustTestResult Entity.
 */
public class TbCustTestResult implements Serializable{
	
	//列信息
	private Integer id;
	
	private String testTypeCode;
	
	private String testTypeName;
	
	private String testResult;
	

		
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
		
		
	public void setTestResult(String value) {
		this.testResult = value;
	}
	
	public String getTestResult() {
		return this.testResult;
	}
		
}

