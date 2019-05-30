package org.myproject.utils;

import java.lang.reflect.Type;

import org.myproject.utils.DateUtil.DatePatterns;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 类注释
 *
 * @author WANGWEI
 */
public class JsonUtil {
	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat(DatePatterns.ISO)
				.create();
		return gson.toJson(obj);
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param obj
	 * @return
	 */
	public static String toPrettyJson(Object obj) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting()
				.setDateFormat(DatePatterns.ISO).create();
		return gson.toJson(obj);
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param json
	 * @param c
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> c) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat(DatePatterns.ISO)
				.create();
		return gson.fromJson(json, c);
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param json
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String json, Type type) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat(DatePatterns.ISO)
				.create();
		return gson.fromJson(json, type);
	}

}