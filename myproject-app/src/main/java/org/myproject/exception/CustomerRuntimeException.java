package org.myproject.exception;

public class CustomerRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4649457643715550657L;

	public CustomerRuntimeException(String errorResult) {
		super(errorResult);
	}
	
	public CustomerRuntimeException(Throwable e) {
		super(e);
	}
}
