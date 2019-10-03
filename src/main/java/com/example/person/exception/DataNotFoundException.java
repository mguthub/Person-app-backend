package com.example.person.exception;

public class DataNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public DataNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public DataNotFoundException() {
		super();
	}
}