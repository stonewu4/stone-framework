package com.stone.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static String createDate()
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	String date = sdf.format(new Date());
    	return date;
    }

    public static String getNow() {
		Calendar calendar = Calendar.getInstance();
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(calendar.getTime());
		return now;
	}

	public static String getToday()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		return date;
	}

	public static Date getTime()
	{
		return new Date();
	}

	public static String getYesterday()
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		Date time = cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}

	/*
	 * 将时间转换为时间戳
	 */
	public static String dateToStamp(String s) throws ParseException {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static String date2String(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}

	public static String date2LongString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return simpleDateFormat.format(date);
	}

	// 获得本月第一天0点时间
	public static Date getTimesMonthmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return  cal.getTime();
	}

	// 获得本月最后一天23:59:59时间
	public static Date getTimesMonthnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//		cal.set(Calendar.HOUR_OF_DAY, 24);
		return cal.getTime();
	}
	// 获得本月第一天0点时间
	public static Date getTimesTodayMorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return  cal.getTime();
	}

	// 获得本月最后一天23:59:59时间
	public static Date getTimesTodayNight() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		return cal.getTime();
	}
//	public static void main(String[] args) {
//		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
//		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//		System.out.println(sdf.format(getTimesTodayMorning()));
//		System.out.println(sdf.format(getTimesTodayNight()));
//	}

}
