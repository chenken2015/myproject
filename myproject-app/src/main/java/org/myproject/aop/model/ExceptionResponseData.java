package org.myproject.aop.model;


import java.io.Serializable;
import java.util.List;

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
  	
  	private Object responseBody;
  	
  	private List<ErrorInfo> errorInfos;

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

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

	public List<ErrorInfo> getErrorInfos() {
		return errorInfos;
	}

	public void setErrorInfos(List<ErrorInfo> errorInfos) {
		this.errorInfos = errorInfos;
	}
	
}

