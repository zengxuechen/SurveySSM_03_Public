package com.atguigu.survey.entities.guest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.atguigu.survey.entities.manager.Role;

/**
 * 用户实体类
 * @author zhangyu
 *
 */
public class User implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -46281696827991510L;

	private Integer userId; //用户id

    private String userName; //用户名称
 
    private String userPwd; //用户密码

    private Boolean company; //用户类型: true-企业用户;false-个人用户

    private String codeArrStr; //用户权限码
    
    
    private Set<Role> roleSet = new HashSet<Role>(); //角色集合

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Boolean getCompany() {
        return company;
    }

    public void setCompany(Boolean company) {
        this.company = company;
    }

    public String getCodeArrStr() {
        return codeArrStr;
    }

    public void setCodeArrStr(String codeArrStr) {
        this.codeArrStr = codeArrStr == null ? null : codeArrStr.trim();
    }

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
    
    
}