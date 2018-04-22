package com.atguigu.survey.entities.zhyq;

import java.io.Serializable;

import lombok.Data;


/**
 * TbCustTestResult Entity.
 */
@Data
public class TbCustTestResult implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 627749161878467700L;

	//列信息
	private Integer id;
	
	private String testUserId;
	
	private String testTypeId;
	
	private String testResult;
	
	private String testPaperId;
	
}

