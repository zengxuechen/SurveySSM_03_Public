package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;


/**
 * TbCompany Entity.
 */
public class TbCompany implements Serializable{
	
	//列信息
	private Integer id;
	
	private String companyNameEn;
	
	private String companyNameCn;
	
	private String companyLogo;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setCompanyNameEn(String value) {
		this.companyNameEn = value;
	}
	
	public String getCompanyNameEn() {
		return this.companyNameEn;
	}
		
		
	public void setCompanyNameCn(String value) {
		this.companyNameCn = value;
	}
	
	public String getCompanyNameCn() {
		return this.companyNameCn;
	}
		
		
	public void setCompanyLogo(String value) {
		this.companyLogo = value;
	}
	
	public String getCompanyLogo() {
		return this.companyLogo;
	}
		
}

