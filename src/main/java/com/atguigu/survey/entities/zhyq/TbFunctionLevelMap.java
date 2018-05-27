package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbFunctionLevelMap Entity.
 */
public class TbFunctionLevelMap implements Serializable{
	
	//列信息
	private Integer id;
	
	private String functionName;
	
	private String functionContent;
	
	private String functionLevel;
	
	private String upId;
	
	private String upFunctionName;
	
	private String functionId;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setFunctionName(String value) {
		this.functionName = value;
	}
	
	public String getFunctionName() {
		return this.functionName;
	}
		
		
	public void setFunctionContent(String value) {
		this.functionContent = value;
	}
	
	public String getFunctionContent() {
		return this.functionContent;
	}
		
		
	public void setFunctionLevel(String value) {
		this.functionLevel = value;
	}
	
	public String getFunctionLevel() {
		return this.functionLevel;
	}
		
		
	public void setUpId(String value) {
		this.upId = value;
	}
	
	public String getUpId() {
		return this.upId;
	}
		
		
	public void setUpFunctionName(String value) {
		this.upFunctionName = value;
	}
	
	public String getUpFunctionName() {
		return this.upFunctionName;
	}
		
		
	public void setFunctionId(String value) {
		this.functionId = value;
	}
	
	public String getFunctionId() {
		return this.functionId;
	}
		
}

