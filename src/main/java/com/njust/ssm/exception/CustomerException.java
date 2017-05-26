package com.njust.ssm.exception;

public class CustomerException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerException(String message) {
		super();
		this.message = message;
	}
	
}
