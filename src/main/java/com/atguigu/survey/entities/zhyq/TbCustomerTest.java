package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbCustomerTest Entity.
 */
public class TbCustomerTest implements Serializable{
	
	//列信息
	
	private Integer id;
	
	private Integer userId;
	
	private String testPaperIds;
	
	private String creator;

    private Integer testOnFlag;
	
	private java.util.Date creatTime;
	
	private java.util.Date lastModifyTime;
	

		
	public void setTestOnFlag(Integer value) {
		this.testOnFlag = value;
	}
	
	public Integer getTestOnFlag() {
		return this.testOnFlag;
	}
		
		
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
		
		
	public void setTestPaperIds(String value) {
		this.testPaperIds = value;
	}
	
	public String getTestPaperIds() {
		return this.testPaperIds;
	}
		
		
	public void setCreator(String value) {
		this.creator = value;
	}
	
	public String getCreator() {
		return this.creator;
	}
		
		
	public void setCreatTime(java.util.Date value) {
		this.creatTime = value;
	}
	
	public java.util.Date getCreatTime() {
		return this.creatTime;
	}
		
		
	public void setLastModifyTime(java.util.Date value) {
		this.lastModifyTime = value;
	}
	
	public java.util.Date getLastModifyTime() {
		return this.lastModifyTime;
	}
		
}

