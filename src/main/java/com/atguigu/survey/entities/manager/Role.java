package com.atguigu.survey.entities.manager;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 * @author zhangyu
 *
 */
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer roleId; //角色id

    private String roleName; //角色名称
    
    private Set<Auth> authSet = new HashSet<Auth>(); //权限集合

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

	public Set<Auth> getAuthSet() {
		return authSet;
	}

	public void setAuthSet(Set<Auth> authSet) {
		this.authSet = authSet;
	}
    
    
}