package org.myproject.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 * 
 * @author WANGWEI
 */
public class DateUtil {

	/**
	 * patterns describing the date and time format
	 *
	 * @author WANGWEI
	 */
	public interface DatePatterns {
		public static final String DEFAULT = "yyyyMMddHHmmss";

		public static final String YYYY = "yyyy";

		public static final String YYYYMM = "yyyyMM";

		public static final String YYYYMMDD = "yyyyMMdd";

		public static final String YYYYMMDDHH = "yyyyMMddHH";

		public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";

		public static final String ISO = "yyyy-MM-dd HH:mm:ss";

		public static final String YYYY_MM = "yyyy-MM";

		public static final String YYYY_MM_DD = "yyyy-MM-dd";

		public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

		public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	}

	/**
	 * get now date.
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getNow(String pattern) {
		return format(new Date(), pattern);
	}

	/**
	 * get now ISO date.
	 * 
	 * @return
	 */
	public static String getNowISO() {
		return format(new Date(), DatePatterns.ISO);
	}

	/**
	 * format date.
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * parse date.
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static Date parse(String source, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(source);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}