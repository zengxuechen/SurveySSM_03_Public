package com.atguigu.survey.entities.manager;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限实体类
 * @author zhangyu
 *
 */
public class Auth implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer authId; //权限id

    private String authName; //权限名称

    private Set<Res> resSet = new HashSet<Res>(); //权限的资源集合
    
    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

	public Set<Res> getResSet() {
		return resSet;
	}

	public void setResSet(Set<Res> resSet) {
		this.resSet = resSet;
	}
    
    
}