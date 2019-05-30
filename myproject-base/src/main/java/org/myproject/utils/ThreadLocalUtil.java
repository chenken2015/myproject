package org.myproject.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;

/**
 * 线程本地化工具
 *
 * @author WANGWEI
 */
public class ThreadLocalUtil {
	/**
	 * 属性注释
	 */
	private static final ThreadLocal<String> LOCAL_TRACE_ID = new ThreadLocal<String>() {
		@Override
		public String initialValue() {
			return null;
		}
	};

	/**
	 * 属性注释
	 */
	private static final ThreadLocal<Map<String, Object>> LOCAL_TRACE_MAP = new ThreadLocal<Map<String, Object>>() {
		@Override
		public Map<String, Object> initialValue() {
			return null;
		}
	};

	/**
	 * 重新初始化
	 *
	 * @author WANGWEI
	 * @return
	 */
	public static String next() {
		LOCAL_TRACE_MAP.set(null);
		String traceID = UUID.randomUUID().toString().replace("-", "");
		setTraceID(traceID);
		return traceID;
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @return
	 */
	public static String getTraceID() {
		String traceID = LOCAL_TRACE_ID.get();
		if (traceID == null) {
			traceID = next();
		} else {
			return traceID;
		}

		return traceID;
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param traceID
	 */
	public static void setTraceID(String traceID) {
		if (!(StringUtils.isNotBlank(traceID)))
			return;
		LOCAL_TRACE_ID.set(traceID);
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param key
	 * @param value
	 */
	public static void set(String key, Object value) {
		Map<String, Object> map = LOCAL_TRACE_MAP.get();

		if (null == map) {
			map = Maps.newHashMap();
			LOCAL_TRACE_MAP.set(map);
		}
		map.put(key, value);
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Map<String, Object> map = LOCAL_TRACE_MAP.get();
		if (null == map) {
			return null;
		}
		return map.get(key);
	}
}
