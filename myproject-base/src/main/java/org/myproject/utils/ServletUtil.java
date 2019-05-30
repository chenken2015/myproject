package org.myproject.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * servlet 工具
 *
 * @author WANGWEI
 * @date 2018年5月24日
 * @Copyright (c) 2018-? http://qmth.com.cn All Rights Reserved.
 */
public class ServletUtil {

	/**
	 * 接口日志
	 */
	//protected static final ExamCloudLog INTERFACE_LOG = ExamCloudLogFactory.getLog("INTERFACE_LOGGER");
	private static final Logger INTERFACE_LOG = LoggerFactory.getLogger(ServletUtil.class);

	/**
	 * 获取request对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request;
	}

	/**
	 * 获取response对象
	 * 
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletResponse response = requestAttributes.getResponse();
		return response;
	}

	/**
	 * 输出响应流
	 *
	 * @author WANGWEI
	 * @param respEntity
	 * @param response
	 */
	public static void returnJson(Object body, HttpServletResponse response) {

		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			String json = "{}";
			if (null != body) {
				json = JsonUtil.toJson(body);
			}
			writer.write(json);

			if (INTERFACE_LOG.isDebugEnabled()) {
				INTERFACE_LOG.debug("[HTTP-RESP]. Response=" + json);
			}
		} catch (IOException e) {
			INTERFACE_LOG.error("fail to write json", e);
		} finally {
			IOUtils.closeQuietly(writer);
		}
	}

	/**
	 * 输出响应流(无日志)
	 *
	 * @author WANGWEI
	 * @param respEntity
	 * @param response
	 */
	public static void returnJsonWithoutLog(Object body, HttpServletResponse response) {

		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			String json = "{}";
			if (null != body) {
				json = JsonUtil.toJson(body);
			}
			writer.write(json);
		} catch (IOException e) {
			// ignore
		} finally {
			IOUtils.closeQuietly(writer);
		}
	}

}
