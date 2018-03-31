package com.atguigu.survey.e;

public class HasNoAuthorityException extends RuntimeException {
	
	static final long serialVersionUID = 1L;

	public HasNoAuthorityException(String message) {
		super(message);
	}

}
