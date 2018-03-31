package com.atguigu.survey.entities.manager;

import java.io.Serializable;

/**
 * 资源实体类
 * @author zhangyu
 *
 */
public class Res implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer resId; //资源id

	private String servletPath; //资源路径

	private Boolean publicRes; //是否为公共资源:true公共资源,false非公共资源

	private Integer resCode; //资源权限码

	private Integer resPos; //资源权限位

	public Res() {
		super();
	}

	public Res(Integer resId, String servletPath, Boolean publicRes,
			Integer resCode, Integer resPos) {
		super();
		this.resId = resId;
		this.servletPath = servletPath;
		this.publicRes = publicRes;
		this.resCode = resCode;
		this.resPos = resPos;
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getServletPath() {
		return servletPath;
	}

	public void setServletPath(String servletPath) {
		this.servletPath = servletPath == null ? null : servletPath.trim();
	}

	public Boolean getPublicRes() {
		return publicRes;
	}

	public void setPublicRes(Boolean publicRes) {
		this.publicRes = publicRes;
	}

	public Integer getResCode() {
		return resCode;
	}

	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}

	public Integer getResPos() {
		return resPos;
	}

	public void setResPos(Integer resPos) {
		this.resPos = resPos;
	}
}