package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbPaPhReport Entity.
 */
public class TbPaPhReport implements Serializable{
	
	//列信息
	private Integer id;
	
	private String symptomTypeCode;
	
	private String symptomTypeName;
	
	private Double standardValueBgn;
	
	private Double standardValueEnd;
	
	private String symptomDesc;
	
	private Integer standardMode;
	
	private String developmentAdvice;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setSymptomTypeCode(String value) {
		this.symptomTypeCode = value;
	}
	
	public String getSymptomTypeCode() {
		return this.symptomTypeCode;
	}
		
		
	public void setSymptomTypeName(String value) {
		this.symptomTypeName = value;
	}
	
	public String getSymptomTypeName() {
		return this.symptomTypeName;
	}
		
		
	public void setStandardValueBgn(Double value) {
		this.standardValueBgn = value;
	}
	
	public Double getStandardValueBgn() {
		return this.standardValueBgn;
	}
		
		
	public void setStandardValueEnd(Double value) {
		this.standardValueEnd = value;
	}
	
	public Double getStandardValueEnd() {
		return this.standardValueEnd;
	}
		
		
	public void setSymptomDesc(String value) {
		this.symptomDesc = value;
	}
	
	public String getSymptomDesc() {
		return this.symptomDesc;
	}
		
		
	public void setStandardMode(Integer value) {
		this.standardMode = value;
	}
	
	public Integer getStandardMode() {
		return this.standardMode;
	}
		
		
	public void setDevelopmentAdvice(String value) {
		this.developmentAdvice = value;
	}
	
	public String getDevelopmentAdvice() {
		return this.developmentAdvice;
	}
		
}

