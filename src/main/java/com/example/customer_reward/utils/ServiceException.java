package com.example.customer_reward.utils;



public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	StatusCode statusCode;
	
	public ServiceException(StatusCode code) {
	this.statusCode = code;	
	}

	public enum StatusCode{
		
		SYSTEM_ERROR,INVALID_REQUEST,INTERNAL_ERROR
	}
}

