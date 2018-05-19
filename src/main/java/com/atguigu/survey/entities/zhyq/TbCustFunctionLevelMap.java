package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbCustFunctionLevelMap Entity.
 */
public class TbCustFunctionLevelMap implements Serializable{
	
	//列信息
	private Integer id;
	
	private Integer departmentId;
	
	private Integer functionId;
	
	private String functionLevel;
	
	private String functionName;
	
	private String functionContent;
	
	private Integer upId;
	
	private String upFunctionName;
	
	private Integer standardId;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setDepartmentId(Integer value) {
		this.departmentId = value;
	}
	
	public Integer getDepartmentId() {
		return this.departmentId;
	}
		
		
	public void setFunctionId(Integer value) {
		this.functionId = value;
	}
	
	public Integer getFunctionId() {
		return this.functionId;
	}
		
		
	public void setFunctionLevel(String value) {
		this.functionLevel = value;
	}
	
	public String getFunctionLevel() {
		return this.functionLevel;
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
		
		
	public void setUpId(Integer value) {
		this.upId = value;
	}
	
	public Integer getUpId() {
		return this.upId;
	}
		
		
	public void setUpFunctionName(String value) {
		this.upFunctionName = value;
	}
	
	public String getUpFunctionName() {
		return this.upFunctionName;
	}
		
		
	public void setStandardId(Integer value) {
		this.standardId = value;
	}
	
	public Integer getStandardId() {
		return this.standardId;
	}
		
}

