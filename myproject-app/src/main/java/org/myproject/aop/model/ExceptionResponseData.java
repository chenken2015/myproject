package org.myproject.aop.model;


import java.io.Serializable;

/**
 * ResponseData
 */
public class ExceptionResponseData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6157324790083385606L;

	private String responseCode = null;

  	private String errorMsg = null;

	public String getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}

