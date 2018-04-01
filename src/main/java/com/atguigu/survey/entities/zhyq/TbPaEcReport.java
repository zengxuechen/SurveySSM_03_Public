package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbPaEcReport Entity.
 */
public class TbPaEcReport implements Serializable{
	
	//列信息
	private Integer id;
	
	private String eqSectionCode;
	
	private Integer standardValueBgn;
	
	private Integer standardValueEnd;
	
	private String sectionDesc;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setEqSectionCode(String value) {
		this.eqSectionCode = value;
	}
	
	public String getEqSectionCode() {
		return this.eqSectionCode;
	}
		
		
	public void setStandardValueBgn(Integer value) {
		this.standardValueBgn = value;
	}
	
	public Integer getStandardValueBgn() {
		return this.standardValueBgn;
	}
		
		
	public void setStandardValueEnd(Integer value) {
		this.standardValueEnd = value;
	}
	
	public Integer getStandardValueEnd() {
		return this.standardValueEnd;
	}
		
		
	public void setSectionDesc(String value) {
		this.sectionDesc = value;
	}
	
	public String getSectionDesc() {
		return this.sectionDesc;
	}
		
}

