package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbPaPcReport Entity.
 */
public class TbPaPcReport implements Serializable{
	
	//列信息
	private Integer id;
	
	private String styleTypeCode;
	
	private String styleTypeTendency;
	
	private String styleTypeName;
	
	private String styleTypeDesc;
	
	private String blindSpotTips;
	
	private String suitedCareer;
	
	private String developmentAdvice;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setStyleTypeCode(String value) {
		this.styleTypeCode = value;
	}
	
	public String getStyleTypeCode() {
		return this.styleTypeCode;
	}
		
		
	public void setStyleTypeTendency(String value) {
		this.styleTypeTendency = value;
	}
	
	public String getStyleTypeTendency() {
		return this.styleTypeTendency;
	}
		
		
	public void setStyleTypeName(String value) {
		this.styleTypeName = value;
	}
	
	public String getStyleTypeName() {
		return this.styleTypeName;
	}
		
		
	public void setStyleTypeDesc(String value) {
		this.styleTypeDesc = value;
	}
	
	public String getStyleTypeDesc() {
		return this.styleTypeDesc;
	}
		
		
	public void setBlindSpotTips(String value) {
		this.blindSpotTips = value;
	}
	
	public String getBlindSpotTips() {
		return this.blindSpotTips;
	}
		
		
	public void setSuitedCareer(String value) {
		this.suitedCareer = value;
	}
	
	public String getSuitedCareer() {
		return this.suitedCareer;
	}
		
		
	public void setDevelopmentAdvice(String value) {
		this.developmentAdvice = value;
	}
	
	public String getDevelopmentAdvice() {
		return this.developmentAdvice;
	}
		
}

