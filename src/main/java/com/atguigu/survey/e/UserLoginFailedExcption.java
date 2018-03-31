package com.atguigu.survey.e;

public class UserLoginFailedExcption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserLoginFailedExcption(String message) {
		super(message);
	}
	
}
