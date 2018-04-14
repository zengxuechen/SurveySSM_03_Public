package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbCustomerRelation Entity.
 */
public class TbCustomerRelation implements Serializable{
	
	//列信息
	private Integer id;
	
	private Integer userId;
	
	private Integer departmentId;
	
	private Integer positionId;
	
	private String phone;
	
	private String email;
	
	private String userNameCn;
	
	private String testPaperIds;
	
	private java.util.Date createTime;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
		
		
	public void setDepartmentId(Integer value) {
		this.departmentId = value;
	}
	
	public Integer getDepartmentId() {
		return this.departmentId;
	}
		
		
	public void setPositionId(Integer value) {
		this.positionId = value;
	}
	
	public Integer getPositionId() {
		return this.positionId;
	}
		
		
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
		
		
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
		
		
	public void setUserNameCn(String value) {
		this.userNameCn = value;
	}
	
	public String getUserNameCn() {
		return this.userNameCn;
	}
		
		
	public void setTestPaperIds(String value) {
		this.testPaperIds = value;
	}
	
	public String getTestPaperIds() {
		return this.testPaperIds;
	}
		
		
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
		
}

