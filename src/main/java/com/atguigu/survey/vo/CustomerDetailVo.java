package com.atguigu.survey.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Using IntelliJ IDEA.
 *
 * @author 李小鑫 at 2018/4/6 15:07
 */
@Data
public class CustomerDetailVo implements Serializable {

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 公司名称（中文）
     */
    private String companyNameCN;

    /**
     * 公司名称（英文）
     */
    private String companyNameEN;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 职位名称
     */
    private String positionName;


}
