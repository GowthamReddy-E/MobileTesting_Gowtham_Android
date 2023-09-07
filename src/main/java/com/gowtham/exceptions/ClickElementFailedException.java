package com.gowtham.exceptions;

public class ClickElementFailedException extends RuntimeException{
	private String message;
	
	public ClickElementFailedException(String message) {
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	
	
}
