package com.app.custom_exception;

public class CustomNoResultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2532224966732610841L;

	public CustomNoResultException(String msg) {
		super(msg);
	}
}
