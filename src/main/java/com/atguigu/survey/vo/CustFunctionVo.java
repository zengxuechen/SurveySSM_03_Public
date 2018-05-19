package com.atguigu.survey.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 职能Vo
 * @author 李小鑫
 * 2018年5月19日
 */
@Data
public class CustFunctionVo implements Serializable {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 职能Id
	 */
	private Integer functionId;
	
	/**
	 * 职能级别
	 */
    private String functionLevel;
    
    /**
     * 职能名称
     */
    private String functionName;
    
    /**
     * 职能内容
     */
    private String functionContent;
    
    /**
     * 上级职能Id
     */
    private Integer upId;
    
}
