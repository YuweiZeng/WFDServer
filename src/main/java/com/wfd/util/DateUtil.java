package com.wfd.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	public final static String SRC_PATTERN = "EEE MMM dd HH:mm:ss z yyyy";

	public final static String DST_PATTERN_WO_TZ = "yyyy-MM-dd'T'HH:mm:ss";

	public final static String DST_PATTERN_WITH_TZ = "yyyy-MM-dd'T'HH:mm:ssZ";

	public final static String DST_PATTERN_DATE_ONLY = "yyyy-MM-dd";
	public final static String DST_PATTERN_DATE = "dd-MMMM-yyyy";
	public final static String DST_PATTERN_DATE_NUM = "M/d/yy";
	public final static String DST_PATTERN_DATE_EN="MMMM d,yyyy";
	public final static String DST_PATTERN_DATE_SLASH="MM/dd/yyyy";

	public static Date parseDate(String dateStr, String pattern) {
		try {
			DateFormat srcFormatter = new SimpleDateFormat(pattern);
			return srcFormatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String formatDate(Date date, String pattern) {
		DateFormat dstFormatter = new SimpleDateFormat(pattern);
		dstFormatter.setTimeZone(TimeZone.getTimeZone(("America/Los_Angeles")));
		return dstFormatter.format(date);
	}

	public static String formatDateWithCalendar(Calendar cal, String pattern) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		return sdf.format(cal.getTime());

	}

	public static Date addMonths(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}
	
   public static Date addDays(Date date,int offset)
   {
	   Calendar cal = Calendar.getInstance();
	   cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) +offset);
		return cal.getTime();
   }

	public static String getCurrentDateString() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssZ");
		String dateStr = formatter.format(date);
		return dateStr;
	}
	
	public static String getCurrentDateShortString() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateStr = formatter.format(date);
		return dateStr;
	}

	public static Date parseDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HH:mm:ssZ");
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException("Failed to parse date, date format is yyyyMMdd-HH:mm:ssZ, "+e.getMessage());
		}
		return date;
	}
	
	public static Date parseDateWithoutTimeZone(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException("Failed to parse date, date format is yyyyMMdd-HH:mm:ss, "+e.getMessage());
		}
		return date;
	}
	
	
	public static TimeZone getTimeZone(String dateStr){
		return TimeZone.getTimeZone("GMT" + dateStr.substring(dateStr.length()-5));
	}
	
	public static Date getCurrentDate() {
		return new Date();
	}
	
	public static String formatDate(String timestamp, String formater){
		Date date = parseDate(timestamp);
		SimpleDateFormat formatter = new SimpleDateFormat(formater);
		String dateStr = formatter.format(date);
		return dateStr;
	}

	public static String getTimeBefore(String startTime, long timeInMillisecond) {
		Date date = new Date();
		date.setTime( DateUtil.parseDate(startTime).getTime() - timeInMillisecond ); // 60*1000 = 1 min
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HH:mm:ssZ");
		String dateStr = formatter.format(date);
		return dateStr;
	}
	
	public static String getWeekDay(){
		String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		Date dt=new Date(); 
		Calendar cal = Calendar.getInstance(); 
        cal.setTime(dt); 

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; 
        if (w < 0) 
            w = 0; 
        return weekDays[w];
	}
	
	//the return time format is yyyy-mm-dd
	public static String getPSTTime(){
		Date date = new Date();
		DateFormat dstFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dstFormatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return dstFormatter.format(date);
	}
	
	public static String getPSTTime_Yesterday(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date date = cal.getTime();
		DateFormat dstFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dstFormatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return dstFormatter.format(date);
	}
	
	public static Calendar getCalendar(int year, int month, int day) {
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.MONTH, month - 1);
	    c.set(Calendar.DAY_OF_MONTH, day);
	    return c;
	 }
	
	public static String getLastDayOfNextMonth(Calendar c){
		Calendar cal = (Calendar)c.clone();
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date date = cal.getTime();
		SimpleDateFormat dstFormatter = new SimpleDateFormat("MMMMM dd, yyyy");
        return dstFormatter.format(date);
	}
	
	public static String getNextMonth(Calendar c){
		Calendar cal = (Calendar)c.clone();
		cal.add(Calendar.MONTH, 1);
		Date date = cal.getTime();
		SimpleDateFormat dstFormatter = new SimpleDateFormat("MMMMM dd, yyyy");
        return dstFormatter.format(date);
	}
	
	public static String getLastDayOfNextYear(Calendar c){
		Calendar cal = (Calendar)c.clone();
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date date = cal.getTime();
		SimpleDateFormat dstFormatter = new SimpleDateFormat("MMMMM dd, yyyy");
		return dstFormatter.format(date);
	}
	
	public static String getNextYear(Calendar c){
		Calendar cal = (Calendar)c.clone();
		cal.add(Calendar.YEAR, 1);
		Date date = cal.getTime();
		SimpleDateFormat dstFormatter = new SimpleDateFormat("MMMMM dd, yyyy");
		return dstFormatter.format(date);
	}
}
