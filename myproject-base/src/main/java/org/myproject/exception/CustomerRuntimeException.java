package org.myproject.exception;

public class CustomerRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4649457643715550657L;
	
	private String errorCode;
	
	private String errorResult;

	public CustomerRuntimeException(String errorResult) {
		super(errorResult);
	}
	
	public CustomerRuntimeException(String errorCode,String errorResult) {
		this.errorCode = errorCode;
		this.errorResult = errorResult;
	}
	
	public CustomerRuntimeException(Throwable e) {
		super(e);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(String errorResult) {
		this.errorResult = errorResult;
	}
	
}
