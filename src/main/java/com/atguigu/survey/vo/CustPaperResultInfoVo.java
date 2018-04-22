package com.atguigu.survey.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Using IntelliJ IDEA.
 *
 * @author 李小鑫 at 2018/4/6 15:07
 */
@Data
public class CustPaperResultInfoVo implements Serializable {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9102212081839752352L;

	/**
     * 用户Id
     */
    private String userId;

    /**
     * 试卷ID
     */
    private String testPaperId;
    
    /**
     * 试卷类型
     */
    private String testTypeCode;

    /**
     * 测试结果
     */
    private String testResult;

}
