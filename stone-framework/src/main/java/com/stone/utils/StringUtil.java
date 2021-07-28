package com.stone.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *String工具类
 */
public class StringUtil {
	
	  /** 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回 
	　　* @param sourceDate 
	　　* @param formatLength 
	　　* @return 重组后的数据 
	　　*/  
	public static String frontCompWithZore(int sourceDate,int formatLength) {
	  String formatString = String.format("%0"+formatLength+"d", sourceDate);  
	  return formatString;
	}


	/**
	 * 判断字符串是空
	 *
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return "".equals(str) || str == null;
	}

	/**
	 * 判断字符串不是空
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !"".equals(str) && str != null;
	}

	/**
	 * 判断某一个字符串数组中是否含有某一字符串
	 *
	 * @param str
	 * @param strArr
	 * @return
	 */
	public static boolean existStrArr(String str, String[] strArr) {
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

	//密码明文转MD5
	public static String getMD5(String instr) {
		String s = null;
		// 用来将字节转换成 16 进制表示的字
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(instr.getBytes());
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str); //.toUpperCase()
		} catch (Exception e) {
		}
		return s;
	}

	/**
	 * 将终端传来经过混合加密的md5解密
	 *
	 * @param p
	 * @return
	 */
	public static String decode(String p) {
		StringBuffer sb = new StringBuffer();
		if (p.length() == 32) {
			sb.append(p.charAt(p.length() - 1));
			sb.append(p.substring(1, 4));
			sb.append(p.charAt(p.length() - 5));
			sb.append(p.substring(5, p.length() - 5));
			sb.append(p.charAt(4));
			sb.append(p.substring(p.length() - 4, p.length() - 1));
			sb.append(p.charAt(0));
		}
		return sb.toString();
	}

	public static List<String> toList(String s) {
		if (s == null || s.isEmpty())
			return new ArrayList<String>();
		List<String> ids = new ArrayList<String>(Arrays.asList(s.split(",")));
		return ids;
	}

	public static List<String> toList(String s, String splitStr) {
		if (s == null || s.isEmpty())
			return new ArrayList<String>();
		List<String> ids = new ArrayList<String>(Arrays.asList(s.split(splitStr)));
		return ids;
	}

	public static String toLikeString(String s) {

		return "%" + s + "%";
	}

	public static String toSerialNumber(int number) {
		return String.format("%03d", number);
	}

	public static Set<String> toSet(String strs) {
		Set<String> set = new HashSet<String>();
		set.addAll(toList(strs));
		return set;
	}

	public static boolean hasRepeat(List<? extends Object> list) {
		if (null == list&&list.size()==0)
			return false;
		return list.size() != new HashSet<Object>(list).size();
	}

	public static boolean allSame(List<? extends Object> list) {
		if (null == list)
			return false;
		return 1 == new HashSet<Object>(list).size();
	}

	public static boolean hasSame(Collection<?> c1, Collection<?> c2) {
		return !Collections.disjoint(c1, c2);
	}

	public static String formatDistrict(String district) throws Exception {
		if (district == null) {
			return null;
		}

		if (district.substring(2, 6).equals("0000")) {//传入省,查市
			if(district.substring(0, 2).equals("11")
					|| district.substring(0, 2).equals("12")
					|| district.substring(0, 2).equals("31")
					|| district.substring(0, 2).equals("50")
					)
				return district.substring(0,2) + "01__";

			return district.substring(0, 2) + "__00";
		}

		if (district.substring(4, 6).equals("00")) {//传入市,查区
			return district.substring(0, 4) + "__";
		}

		return district;
	}

	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	public static String subStr(String str, int len) {
		if (isEmpty(str) || len <= 0)
			return "";
		StringBuffer stringBuffer = new StringBuffer();
		int sum = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (sum >= (len * 3)) {
				break;
			}
			char bt = chars[i];
			if (bt > 64 && bt < 123) {
				stringBuffer.append(String.valueOf(bt));
				sum += 2;
			} else {
				stringBuffer.append(String.valueOf(bt));
				sum += 3;
			}
		}
		return stringBuffer.toString()+"...";
	}

	public static boolean isNumber(String str){
		String reg = "^[0-9]+(.[0-9]+)?$";
		return str.matches(reg);
	}

	public static String getUUID(int length){
		Random random = new Random();
		Integer number = random.nextInt(20)+1;
		return UUID.randomUUID().toString().replace("-", "").substring(number,number + length);
	}

	/**
	 * 自动生成id
	 * @return
	 */
	public static synchronized String generateId(){
		Random random = new Random();
		Integer number = random.nextInt(90000)+10000;
		Date date = new Date();
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date) + number;
	}
}
