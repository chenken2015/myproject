package org.myproject.utils;

import java.util.List;

/**
 *
 * @author WANGWEI
 */
public class StringUtil {

	/**
	 * 是否是ACSII码组成的字符串
	 *
	 * @author WANGWEI
	 * @param s
	 * @return
	 */
	public static boolean isAscString(String s) {
		char[] arr = s.toCharArray();
		for (char c : arr) {
			if (c < 0 || c > 127) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Example: subString("12345","1","4")=23
	 * 
	 * @param src
	 * @param start
	 * @param to
	 * @return
	 */
	public static Integer subStringToInteger(String src, String start, String to) {
		return stringToInteger(subString(src, start, to));
	}

	/**
	 * Example: subString("abcd","a","c")="b"
	 * 
	 * @param src
	 * @param start
	 *            null while start from index=0
	 * @param to
	 *            null while to index=src.length
	 * @return
	 */
	public static String subString(String src, String start, String to) {
		int indexFrom = start == null ? 0 : src.indexOf(start);
		int indexTo = to == null ? src.length() : src.indexOf(to);
		if (indexFrom < 0 || indexTo < 0 || indexFrom > indexTo) {
			return null;
		}

		if (null != start) {
			indexFrom += start.length();
		}

		return src.substring(indexFrom, indexTo);

	}

	/**
	 * Example: subString("abcdc","a","c",true)="bcd"
	 * 
	 * @param src
	 * @param start
	 *            null while start from index=0
	 * @param to
	 *            null while to index=src.length
	 * @param toLast
	 *            true while to index=src.lastIndexOf(to)
	 * @return
	 */
	public static String subString(String src, String start, String to, boolean toLast) {
		if (!toLast) {
			return subString(src, start, to);
		}
		int indexFrom = start == null ? 0 : src.indexOf(start);
		int indexTo = to == null ? src.length() : src.lastIndexOf(to);
		if (indexFrom < 0 || indexTo < 0 || indexFrom > indexTo) {
			return null;
		}

		if (null != start) {
			indexFrom += start.length();
		}

		return src.substring(indexFrom, indexTo);

	}

	/**
	 * @param in
	 * @return
	 */
	public static Integer stringToInteger(String in) {
		if (in == null) {
			return null;
		}
		in = in.trim();
		if (in.length() == 0) {
			return null;
		}

		try {
			return Integer.parseInt(in);
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equals(String a, String b) {
		if (a == null) {
			return b == null;
		}
		return a.equals(b);
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equalsIgnoreCase(String a, String b) {
		if (a == null) {
			return b == null;
		}
		return a.equalsIgnoreCase(b);
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		if (str.length() == 0) {
			return false;
		}
		int sz = str.length();
		boolean hasExp = false;
		boolean hasDecPoint = false;
		boolean allowSigns = false;
		boolean foundDigit = false;
		int start = (str.charAt(0) == '-') ? 1 : 0;
		if (sz > start + 1) {
			if (str.charAt(start) == '0' && str.charAt(start + 1) == 'x') {
				int i = start + 2;
				if (i == sz) {
					return false;
				}
				for (; i < str.length(); i++) {
					char ch = str.charAt(i);
					if ((ch < '0' || ch > '9') && (ch < 'a' || ch > 'f')
							&& (ch < 'A' || ch > 'F')) {
						return false;
					}
				}
				return true;
			}
		}
		sz--;
		int i = start;
		while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				foundDigit = true;
				allowSigns = false;

			} else if (ch == '.') {
				if (hasDecPoint || hasExp) {
					return false;
				}
				hasDecPoint = true;
			} else if (ch == 'e' || ch == 'E') {
				if (hasExp) {
					return false;
				}
				if (!foundDigit) {
					return false;
				}
				hasExp = true;
				allowSigns = true;
			} else if (ch == '+' || ch == '-') {
				if (!allowSigns) {
					return false;
				}
				allowSigns = false;
				foundDigit = false;
			} else {
				return false;
			}
			i++;
		}
		if (i < str.length()) {
			char ch = str.charAt(i);

			if (ch >= '0' && ch <= '9') {
				return true;
			}
			if (ch == 'e' || ch == 'E') {
				return false;
			}
			if (!allowSigns && (ch == 'd' || ch == 'D' || ch == 'f' || ch == 'F')) {
				return foundDigit;
			}
			if (ch == 'l' || ch == 'L') {
				return foundDigit && !hasExp;
			}
			return false;
		}

		return !allowSigns && foundDigit;
	}

	/**
	 * 拼接
	 * 
	 * @param elements
	 * @return
	 */
	public static String join(Object... elements) {
		StringBuilder sb = new StringBuilder();
		for (Object e : elements) {
			if (e == null) {
				e = "null";
			}
			sb.append(e.toString());
		}
		return sb.toString();
	}

	/**
	 * 拼接
	 * 
	 * @param elements
	 * @return
	 */
	public static String join(List<Object> elements) {
		StringBuilder sb = new StringBuilder();
		for (Object e : elements) {
			if (e == null) {
				e = "null";
			}
			sb.append(e.toString());
		}
		return sb.toString();
	}

	/**
	 * 拼接
	 * 
	 * @param sep
	 * @param elements
	 * @return
	 */
	public static String joinWithSep(String sep, Object... elements) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Object e : elements) {
			if (e == null) {
				e = "null";
			}
			if (first) {
				sb.append(e.toString());
				first = false;
			} else {
				sb.append(sep).append(e.toString());
			}
		}
		return sb.toString();
	}

	/**
	 * 拼接
	 * 
	 * @param sep
	 * @param elements
	 * @return
	 */
	public static String joinWithSep(String sep, List<Object> elements) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Object e : elements) {
			if (e == null) {
				e = "null";
			}
			if (first) {
				sb.append(e.toString());
				first = false;
			} else {
				sb.append(sep).append(e.toString());
			}
		}
		return sb.toString();
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param s
	 * @return
	 */
	public static Boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 方法注释
	 *
	 * @author WANGWEI
	 * @param s
	 * @return
	 */
	public static Boolean isLong(String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}