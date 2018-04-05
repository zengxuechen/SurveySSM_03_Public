package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbPosition Entity.
 */
public class TbPosition implements Serializable{
	
	//列信息
	private Integer id;
	
	private String positionName;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setPositionName(String value) {
		this.positionName = value;
	}
	
	public String getPositionName() {
		return this.positionName;
	}
		
}

