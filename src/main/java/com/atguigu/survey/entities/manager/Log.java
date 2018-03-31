package com.atguigu.survey.entities.manager;

import java.io.Serializable;

/**
 * 日志实体类
 * @author zhangyu
 *
 */
public class Log implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer logId; //日志id

	private String operator; //记录日志-操作人

	private String operateTime; //记录日志-操作时间

	private String methodName; //记录日志-操作方法

	private String methodType; //记录日志-操作方法所在类型

	private String methodReturnValue; //记录日志-方法返回结果

	private String methodArgs; //记录日志-方法参数

	private String exceptionType; //异常类型

	private String exceptionMessage; //异常信息

	public Log() {
		super();
	}

	public Log(Integer logId, String operator, String operateTime,
			String methodName, String methodType, String methodReturnValue,
			String methodArgs, String exceptionType, String exceptionMessage) {
		super();
		this.logId = logId;
		this.operator = operator;
		this.operateTime = operateTime;
		this.methodName = methodName;
		this.methodType = methodType;
		this.methodReturnValue = methodReturnValue;
		this.methodArgs = methodArgs;
		this.exceptionType = exceptionType;
		this.exceptionMessage = exceptionMessage;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime == null ? null : operateTime.trim();
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName == null ? null : methodName.trim();
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType == null ? null : methodType.trim();
	}

	public String getMethodReturnValue() {
		return methodReturnValue;
	}

	public void setMethodReturnValue(String methodReturnValue) {
		this.methodReturnValue = methodReturnValue == null ? null
				: methodReturnValue.trim();
	}

	public String getMethodArgs() {
		return methodArgs;
	}

	public void setMethodArgs(String methodArgs) {
		this.methodArgs = methodArgs == null ? null : methodArgs.trim();
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType == null ? null : exceptionType
				.trim();
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage == null ? null
				: exceptionMessage.trim();
	}
}