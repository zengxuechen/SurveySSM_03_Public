package com.atguigu.survey.entities.guest;

import java.io.Serializable;

/**
 * 搭建环境时用于测试的实体类
 * @author zhangyu
 *
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empId;

	private String empName;

	private Integer age;

	public Employee(Integer empId, String empName, Integer age) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
	}

	public Employee() {
		super();
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName == null ? null : empName.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}