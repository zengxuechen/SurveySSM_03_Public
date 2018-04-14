package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbPaCaReport Entity.
 */
public class TbPaCaReport implements Serializable{
	
	//列信息
	private Integer id;
	
	private String professionCode;
	
	private String professionCodeName;
	
	private String characterSummarize;
	
	private String characterDesc;
	
	private String developmentAdvice;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setProfessionCode(String value) {
		this.professionCode = value;
	}
	
	public String getProfessionCode() {
		return this.professionCode;
	}
		
		
	public void setProfessionCodeName(String value) {
		this.professionCodeName = value;
	}
	
	public String getProfessionCodeName() {
		return this.professionCodeName;
	}
		
		
	public void setCharacterSummarize(String value) {
		this.characterSummarize = value;
	}
	
	public String getCharacterSummarize() {
		return this.characterSummarize;
	}
		
		
	public void setCharacterDesc(String value) {
		this.characterDesc = value;
	}
	
	public String getCharacterDesc() {
		return this.characterDesc;
	}
		
		
	public void setDevelopmentAdvice(String value) {
		this.developmentAdvice = value;
	}
	
	public String getDevelopmentAdvice() {
		return this.developmentAdvice;
	}
		
}

