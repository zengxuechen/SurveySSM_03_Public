package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbDepartment Entity.
 */
public class TbDepartment implements Serializable{
	
	//列信息
	private Integer id;
	
	private Integer companyId;
	
	private String departmentName;
	
	private String departmentId;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setCompanyId(Integer value) {
		this.companyId = value;
	}
	
	public Integer getCompanyId() {
		return this.companyId;
	}
		
		
	public void setDepartmentName(String value) {
		this.departmentName = value;
	}
	
	public String getDepartmentName() {
		return this.departmentName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
		
}

