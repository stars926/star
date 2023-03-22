package com.star.web.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author star926
 * @date 2022/6/13 16:50
 */
public class DateUtils {
	/**
	 * 得到几天前的时间
	 *
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 得到几天后的时间
	 *
	 * @param date 选定时间
	 * @param day 天数
	 * @return date+day天后的时间
	 */
	public static Date getDateAfter(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
}
