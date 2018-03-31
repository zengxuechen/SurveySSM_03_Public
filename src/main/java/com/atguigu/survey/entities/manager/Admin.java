package com.atguigu.survey.entities.manager;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体类
 * @author zhangyu
 *
 */
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer adminId; //管理员id

    private String adminName; //管理员名称

    private String adminPwd; //管理员密码

    private String codeArrStr; //管理员权限码
    
    private Set<Role> roleSet = new HashSet<Role>();//管理员角色集合

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
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