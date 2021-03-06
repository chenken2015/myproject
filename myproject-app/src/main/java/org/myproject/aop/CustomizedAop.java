package org.myproject.aop;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.myproject.exception.CustomerRuntimeException;
import org.myproject.utils.JsonUtil;
import org.myproject.utils.ObjectUtil;
import org.myproject.utils.ServletUtil;
import org.myproject.utils.StringUtil;
import org.myproject.utils.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * 
 * @author ken.chen
 *
 */
@Component
@Aspect
public class CustomizedAop {
	
	private static final Logger log = LoggerFactory.getLogger(CustomizedAop.class); 

	@Pointcut("execution(public * org.myproject.controller..*.*(..))")
	public void handlerMethods() {}

	@Around("handlerMethods()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		String threadId = "Thread-"+ThreadLocalUtil.getTraceID();
		long startTime = System.currentTimeMillis();
		// 获取request对象
		HttpServletRequest request = ServletUtil.getRequest();
		String path = request.getServletPath();
		String method = request.getMethod();
		
		beforeProcessLog(joinPoint,path,method,threadId);
		
		Object result = null;
		try {
			result = joinPoint.proceed();
			long cost = System.currentTimeMillis() - startTime;
			String outMsg = StringUtil.join("[",threadId,"][HTTP-RESP].path=\"", path, "\", method=[", method,"] ; cost ", cost, " ms");
			afterProcessLog(path,method,outMsg,result,cost);
		}catch (Throwable e) {
			String exceptionMsg = StringUtil.join("[",threadId,"][HTTP-REQ-FAIL]. path=\"", path, "\", method=[",method, "] ; cost ", System.currentTimeMillis() - startTime, " ms.");
			log.error(exceptionMsg);
			throw new CustomerRuntimeException(e);
		}
		return result;
	}
	
	private void beforeProcessLog(ProceedingJoinPoint joinPoint,String path,String method,String threadId) {
		Object[] args = joinPoint.getArgs();
		if (!log.isInfoEnabled()) {
			log.info(StringUtil.join("[",threadId,"][HTTP-REQ]. path=/",path,"method=[",method,"]"));
		}else {
			if (null != args) {
				if (args.length == 1 && args[0] instanceof Serializable) {
					log.info(StringUtil.join("[",threadId,"][HTTP-REQ].path=\"",path,"\", method=[",method,"]. args={",JsonUtil.toJson(args[0]),"}"));
				} else if (args.length >= 1) {
					StringBuilder sb = new StringBuilder();
					sb.append(StringUtil.join("[",threadId,"][HTTP-REQ].path=\"",path,"\", method=[",method,"]. args={"));
					for (int i = 0; i < args.length; i++) {
						Object curArg = args[i];
						if(null == curArg) {
							sb.append("null");
						}else {
							sb.append("\"args[").append(i).append("]\":");
							if (curArg instanceof Serializable) {
								sb.append(JsonUtil.toJson(curArg));
							} else if (ObjectUtil.isBaseDataType(curArg.getClass())) {
								sb.append(curArg);
							}
							sb.append(",");
						}
					}
					sb.append("}");
					log.info(sb.toString());
				}
			}else {
				log.info(StringUtil.join("[",threadId,"][HTTP-REQ]. path=/",path,"method=[",method,"]"));
			}
		}
	}
	
	private void afterProcessLog(String path,String method,String outMsg,Object result,long cost) {
		if(!log.isInfoEnabled()) {
			log.info(outMsg);
		}else {
			boolean jsonSerializable = false;
			if (null == result) {
				log.info(StringUtil.join(outMsg,";[http-response-status-code]=" , HttpStatus.OK,". response=void\""));
			}else {
				if (result instanceof Serializable) {
					jsonSerializable = true;
				} else if (result instanceof Collection) {
					jsonSerializable = true;
				} else if (result instanceof Map) {
					jsonSerializable = true;
				} else if (result instanceof String) {
					jsonSerializable = true;
				}
				if (jsonSerializable) {
					log.info(StringUtil.join(outMsg,";[http-response-status-code]=" ,HttpStatus.OK.value() ,",response=" , JsonUtil.toJson(result)));
				}else {
					log.info(StringUtil.join(outMsg,";[http-response-status-code]=" , HttpStatus.OK.value()));
				}
			}
		}
	}

}
