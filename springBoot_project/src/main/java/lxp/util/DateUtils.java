package lxp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	
	/**
	 * 按照  yyyy-MM-dd 
	 */
	public static String  yyyyMMdd = "yyyy-MM-dd";
	
	/**
	 * 按照 yyyy-MM-dd HH:mm:ss
	 */
	public static String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 按照yyyy-MM-dd HH:mm
	 */
	public static String yyyyMMddHHmm = "yyyy-MM-dd HH:mm";

	
	/**
	 * 获取时间戳 1414561699
	 */
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

	public static String getYearTimeStamp() {
		return String.valueOf((System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 30 * 12)) / 1000);
	}

	/**
	 * 获取时间 Date-->String yyyyMMddHHmmss
	 */
	public static String getDateTimeLong(Date currentTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static long get2Month() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + 1);
		Date date = curr.getTime();
		return date.getTime();
	}

	public static long getHalfYear() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + 6);
		Date date = curr.getTime();
		return date.getTime();
	}

	/**
	 * 获取时间 Date-->String yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTimeLo(Date currentTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 22 * 日期格式字符串转换成时间戳 23 * @param date 字符串日期 24 * @param format 如：yyyy-MM-dd
	 * HH:mm:ss 25 * @return 26
	 */
	public static String date2TimeStamp(String date_str, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return String.valueOf(sdf.parse(date_str).getTime() / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	
	/**
	 * 字符串转date
	 * @author tanxin
	 * @param dateStr 字符串
	 * @param format  时间格式
	 * @return
	 */
	public static Date getDate(String dateStr,String format){
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前日期
	 */
	public static String getMonth(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 获得开始时间
	 * @param date
	 * @return
	 */
	public static Date getDayStartTime(Date date) {
		Date start = null;
		try {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			start = formater2.parse(formater.format(date) + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return start;
	}
	
	/**
	 * 获得结束时间
	 * @param date
	 * @return
	 */
	public static Date getDayEndTime(Date date){
		Date end = null;
		try {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			end = formater2.parse(formater.format(date) + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return end;
	}
	
	
	public static Date getDayFormat(Date date) throws ParseException {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateRes = formater.parse(formater.format(date));
		return dateRes;
	}

	/**
	 * 时间戳转换为日期对象
	 */
	public static Date timeStampToDate(String times) {
		Date date = new Date(Long.parseLong(times));
		return date;
	}

	/**
	 * 比较2个 date类型日期
	 * 
	 * @param times
	 * @param endTime
	 * @return
	 */
	public static boolean dateIsFlag(String endTime) {
		return timeStampToDate(getTimeStamp()).compareTo(timeStampToDate(endTime)) < 0 ? true : false;
	}

	public static long get2Year() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
		Date date = curr.getTime();
		long time = date.getTime();
		return time;
	}
		
	
}
