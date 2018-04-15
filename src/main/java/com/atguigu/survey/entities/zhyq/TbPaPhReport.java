package com.atguigu.survey.entities.zhyq;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * TbPaPhReport Entity.
 */
@Data
public class TbPaPhReport implements Serializable{
	
	//列信息
	private Integer id;
	
	private String symptomTypeCode;
	
	private String symptomTypeName;
	
	private BigDecimal standardValueBgn;
	
	private BigDecimal standardValueEnd;
	
	private String symptomDesc;
	
	private Integer standardMode;
	
	private String developmentAdvice;
	


}

