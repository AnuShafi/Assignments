package com.example.customer_reward.utils;



public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	String message;
	
	String error;
	
	StatusCode statusCode;
	
	public ServiceException() {
		
	}
	
	public ServiceException(StatusCode code) {
	this.statusCode = code;	
	}
	
	

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	public StatusCode getStatusCode() {
		return statusCode;
	}



	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
	 
	@Override
	    public synchronized Throwable fillInStackTrace() {
	        return this;
	    }


	public enum StatusCode{
		
		SYSTEM_ERROR,INVALID_REQUEST,INTERNAL_ERROR
	}
}

