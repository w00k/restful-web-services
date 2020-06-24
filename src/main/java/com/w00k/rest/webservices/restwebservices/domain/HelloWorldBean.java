package com.w00k.rest.webservices.restwebservices.domain;

public class HelloWorldBean {
	
	private String Message;

	public HelloWorldBean(String message) {
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [Message=" + Message + "]";
	} 

}
