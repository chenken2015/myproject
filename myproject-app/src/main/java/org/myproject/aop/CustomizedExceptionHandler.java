package org.myproject.aop;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.myproject.aop.model.ErrorInfo;
import org.myproject.aop.model.ExceptionResponseData;
import org.myproject.exception.CustomerRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author ken.chen
 *
 */
@ControllerAdvice(basePackages = "org.myproject")
public class CustomizedExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomizedExceptionHandler.class); 
	
	@ExceptionHandler(CustomerRuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponseData handleException(HttpServletRequest request, Exception ex) throws Throwable {
		log.error("[HTTP-ERROR]",ex);
		Throwable throwable = ex.getCause();
		if(throwable instanceof CustomerRuntimeException) {
			CustomerRuntimeException customerRuntimeException = (CustomerRuntimeException)throwable;
			ExceptionResponseData exceptionResponseData = new ExceptionResponseData();
			exceptionResponseData.setResponseCode(customerRuntimeException.getErrorCode());
			exceptionResponseData.setErrorMsg(customerRuntimeException.getErrorResult());
			return exceptionResponseData;
		}else {
			ExceptionResponseData exceptionResponseData = new ExceptionResponseData();
	        exceptionResponseData.setResponseCode("E000");
	        exceptionResponseData.setErrorMsg("runtimeException");
	        return exceptionResponseData;
		}
		
	}
	
	/**
     * handle MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponseData bindException(MethodArgumentNotValidException ex) {
    	log.error("[HTTP-ERROR]", ex);
        BindingResult bindingResult = ex.getBindingResult();
        List<ErrorInfo> errorInfos = new ArrayList<ErrorInfo>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
        	ErrorInfo errorInfo = new ErrorInfo();
        	errorInfo.setMessage(fieldError.getDefaultMessage());
        	errorInfos.add(errorInfo);
        }
        ExceptionResponseData exceptionResponseData = new ExceptionResponseData();
        exceptionResponseData.setResponseCode("E000");
        exceptionResponseData.setErrorMsg("argument not valid exception");
        exceptionResponseData.setErrorInfos(errorInfos);
        return exceptionResponseData;
    }
    
    
}
