package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbMnPtReport Entity.
 */
public class TbMnPtReport implements Serializable{
	
	//列信息
	private Integer id;
	
	private String ptTypeCode;
	
	private String ptTypeName;
	
	private int standardValueBgn;
	
	private int standardValueEnd;
	
	private String ptDesc;
	
	private String ptTips;
	
	private String advice;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setPtTypeCode(String value) {
		this.ptTypeCode = value;
	}
	
	public String getPtTypeCode() {
		return this.ptTypeCode;
	}
		
		
	public void setPtTypeName(String value) {
		this.ptTypeName = value;
	}
	
	public String getPtTypeName() {
		return this.ptTypeName;
	}
		
		
	public void setStandardValueBgn(Byte value) {
		this.standardValueBgn = value;
	}
	
	public int getStandardValueBgn() {
		return this.standardValueBgn;
	}
		
		
	public void setStandardValueEnd(Byte value) {
		this.standardValueEnd = value;
	}
	
	public int getStandardValueEnd() {
		return this.standardValueEnd;
	}
		
		
	public void setPtDesc(String value) {
		this.ptDesc = value;
	}
	
	public String getPtDesc() {
		return this.ptDesc;
	}
		
		
	public void setPtTips(String value) {
		this.ptTips = value;
	}
	
	public String getPtTips() {
		return this.ptTips;
	}
		
		
	public void setAdvice(String value) {
		this.advice = value;
	}
	
	public String getAdvice() {
		return this.advice;
	}
		
}

