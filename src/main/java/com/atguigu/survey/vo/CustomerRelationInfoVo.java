package com.atguigu.survey.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import com.atguigu.survey.entities.zhyq.TbCustTestPaper;

/**
 * Using IntelliJ IDEA.
 *
 * @author 李小鑫 at 2018/4/5 15:33
 */
@Data
public class CustomerRelationInfoVo implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -839696157302948552L;

	/**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;
    
    /**
     * 中文用户名
     */
    private String userNameCn;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 职位id
     */
    private Integer positionId;
    
    private String companyNameCN;
    private String departmentName;
    private String positionName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;
    
    /**
     * 公司
     */
    private boolean company;
    
    /**
     * 问卷列表
     */
    private List<TbCustTestPaper> paperList;

}
