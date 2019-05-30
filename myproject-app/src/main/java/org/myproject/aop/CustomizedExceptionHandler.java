package org.myproject.aop;


import javax.servlet.http.HttpServletRequest;

import org.myproject.aop.model.ExceptionResponseData;
import org.myproject.exception.CustomerRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author ken.chen
 *
 */
@ControllerAdvice(basePackages = "org.myproject")
public class CustomizedExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomizedExceptionHandler.class); 
	
	@ExceptionHandler
    @ResponseBody
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception e) {
		log.error("[HTTP-ERROR]",e);
		if(e instanceof CustomerRuntimeException){
			CustomerRuntimeException customerRuntimeException = (CustomerRuntimeException)e;
			String message = customerRuntimeException.getMessage();
			ExceptionResponseData exceptionResponseData = new ExceptionResponseData();
			exceptionResponseData.setResponseCode("E000");
			exceptionResponseData.setErrorMsg(message);
			return new ResponseEntity<ExceptionResponseData>(exceptionResponseData,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
