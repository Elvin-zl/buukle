package top.buukle.util;

import org.apache.commons.lang.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@SuppressWarnings({ "deprecation", "unused", "static-access" })
public class DateUtil {

	/** 毫秒 */
	public static final long MILLISECOND = 1;
	
	/** 秒 */
	public static final long SECOND = 1000 * MILLISECOND;
	
	/** 分 */
	public static final long MINUTE = 60 * SECOND;
	
	/** 时 */
	public static final long HOUR = 60 * MINUTE;
	
	/** 天 */
	public static final long DAY = 24 * HOUR;
	
	
	public static final String YYYYMMDD = "yyyy-MM-dd";
	
	public static final String START_SECONED = " 00:00:00";
	
	public static final String END_SECONED 	= " 23:59:59";
	
	/**
	 * yyyy-MM-dd格式的日期格式化类
	 */
	public static final SimpleDateFormat YMD = new SimpleDateFormat(
			"yyyy-MM-dd");

	/**
	 * 把java.util.Date对象格式化成指定格式的string类型
	 * 
	 * @param patternStr
	 *            格式化后的格式
	 * 
	 * @return
	 */
	public static String formatDate(String patternStr, Date date) {
		try {
			if (date == null) {
				return "";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(patternStr);
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * String
	 *            20060100,20051231,20060101 yyyy-MM-dd/yyyyMMdd/yyyyMM
	 * @return
	 */
	public static Date parse(String dateString) {
		try {
			if (dateString == null || dateString.length() == 0) {
				return null;
			}else{
				dateString=dateString.trim();
				if (dateString.length() == 19) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
				}else if (dateString.length() == 17) {
					return new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(dateString);
				}else if (dateString.length() == 14) {
					return new SimpleDateFormat("yyyyMMddHHmmss").parse(dateString);
				} else if (dateString.length() <= 6) {
					return new SimpleDateFormat("yyyyMM").parse(dateString);
				} else if (dateString.indexOf("-") < 0) {
					return new SimpleDateFormat("yyyyMMdd").parse(dateString);
				} else if (dateString.length() == 7 && dateString.indexOf("-") > 0) {
					return new SimpleDateFormat("yyyy-MM").parse(dateString);
					
				} else {
					return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
				}
			} 
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * 请保证传入字符串格式为 yyyy-MM-dd HH:mm:ss 如 2008-10-12 00:00:00 否则抛异常 return null
	 */
	public static Date parseWholeDate(String dateString) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 得到月份的第几天
	 */
	public static String parseDayOnMonth(Date date) {
		java.text.DateFormat format = new SimpleDateFormat("dd");
		return format.format(date);

	}

	/** 13FEB[07] default year:new date.year */
	public static Date dateParse(String dayString) {
		try {
			if (dayString.length() > 5) {
				return new SimpleDateFormat("ddMMMyy", Locale.ENGLISH)
						.parse(dayString);
			} else {
				final String str = new StringBuffer(dayString).append(
						String.valueOf(
								Calendar.getInstance().get(Calendar.YEAR))
								.substring(2)).toString();
				return new SimpleDateFormat("ddMMMyy", Locale.ENGLISH)
						.parse(str);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 返回当天日期加上或减去（-1）指定天数的日期
	 * 
	 * @param day
	 * @return
	 */
	public static Date getCurDateByDay(int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	public static Date getCurDateByDay(int day, Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	/**
	 * 13FEB[07] default year:date before now, year is next year,otherwise this
	 * year 返回时间在现有时间之前，则返回下一年
	 * */
	public static Date dateParseForEterm(String dayString) {
		try {
			if (dayString.length() > 5) {
				return new SimpleDateFormat("ddMMMyy", Locale.ENGLISH)
						.parse(dayString);
			} else {
				final String str = new StringBuffer(dayString).append(
						String.valueOf(
								Calendar.getInstance().get(Calendar.YEAR))
								.substring(2)).toString();

				Date parsedDate = new SimpleDateFormat("ddMMMyy",
						Locale.ENGLISH).parse(str);
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTime(parsedDate);
				if (tempCal.before(Calendar.getInstance())) {
					tempCal.setTime(dateParse(new StringBuffer(dayString)
							.append(String
									.valueOf(
											Calendar.getInstance().get(
													Calendar.YEAR) + 1)
									.substring(2)).toString()));
				}
				return tempCal.getTime();
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/** to ddMMMyy String */
	public static String crsDate(Date date) {
		return FastDateFormat.getInstance("ddMMMyy", Locale.ENGLISH)
				.format(date).toUpperCase();
	}

	/** to ddMMMyy String */
	public static String parseToCRSDate(String date) {
		return crsDate(parse(date)).toUpperCase();
	}

	/**
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String wholeDate(Date date) {
		return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/** YYYYMMDD */
	public static String shortDate(Date date) {
		return FastDateFormat.getInstance("yyyyMMdd").format(date);
	}

	/**
	 * 
	 * @return YYYY-MM
	 */
	public static String shortMonth(Date date) {
		return FastDateFormat.getInstance("yyyy-MM").format(date);
	}

	/**
	 * 
	 * @return YYYY-MM
	 */
	public static String shortMonthMM(Date date) {
		return FastDateFormat.getInstance("yyyyMM").format(date);
	}

	/** YYYY-MM-DD */
	public static String longDate(Date date) {
		return FastDateFormat.getInstance("yyyy-MM-dd").format(date);
	}

	/** MMdd-MMdd */
	public static String tinyDates(Date from, Date to) {
		String fromstr = "";
		if (from != null) {
			try {
				fromstr = FastDateFormat.getInstance("MMdd").format(from);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		String tostr = "";
		if (to != null) {
			try {
				tostr = FastDateFormat.getInstance("MMdd").format(to);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return fromstr + "-" + tostr;
	}

	/**
	 * str
	 *            12DEC
	 * @param timeStr
	 *            1111
	 * @return Date ,12/dec 11:11
	 */
	public static Date parseDateTime(String datestr, String timeStr) {
		Calendar date = Calendar.getInstance();
		date.setTime(dateParse(datestr));
		final int time = Integer.parseInt(timeStr);
		date.set(Calendar.HOUR_OF_DAY, time / 100);
		date.set(Calendar.MINUTE, time % 100);
		date.set(Calendar.MINUTE, 31);
		return date.getTime();
	}

	public static String pnrWeek4XE(Date date) {
		return FastDateFormat.getInstance("EE", Locale.ENGLISH)
				.format(date.getTime()).substring(0, 2);
	}

	/** used on page */
	public static boolean compareSameDate(Date dateFrom, Date dateTo) {
		if (dateFrom != null && dateTo != null) {
			if (dateFrom.getYear() == dateTo.getYear()
					&& dateFrom.getMonth() == dateTo.getMonth()
					&& dateFrom.getDate() == dateTo.getDate()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return if 0:00-8:00
	 */
	public static boolean isWorkTimeNow() {
		Calendar now = Calendar.getInstance(Locale.CHINA);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		if (hour <= 7 && hour >= 0) {
			return false;
		}
		return true;
	}

	/**
	 * compare when set as 00:00:00
	 * 
	 * @see Date#compareTo(Date)
	 */
	public static int compareDateWithin(Date first, Date second) {
		Date firstD;
		Date secondD;
		try {
			if (compareSameDate(first, second)) {
				return 0;
			}
			firstD = parse(shortDate(first));
			secondD = parse(shortDate(second));
			return firstD.compareTo(secondD);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return -1;
		}

	}

	/**
	 * compare when set as 00:00:00
	 * 
	 * @see Date#compareTo(Date)
	 */
	public static int compareDate(Date first, Date second) {
		Date firstD;
		Date secondD;
		try {
			firstD = parse(shortDate(first));
			secondD = parse(shortDate(second));
			return firstD.compareTo(secondD);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return -1;
		}

	}

	/**
	 * 删除时间的时分秒(毫秒没有清零clearHHmmssms 方法替换)
	 * 
	 * 
	 * @return
	 */
	@Deprecated
	public static Date clearHHmmss(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 删除时间的时分秒毫秒
	 */
	public static Date clearHHmmssms(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date fullHHmmss(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/** yyMMddhhmmss */
	public static String fullTime(Date date) {
		return FastDateFormat.getInstance("yyMMddHHmmss").format(date);
	}

	/**
	 * 得到某天 00:00:00时刻的date实例
	 * 
	 * 
	 *            如果date==null 返回 得到当天 00:00:00时刻的date实例
	 * @return
	 * @author dixingxing
	 * @since 2008-9-5 下午03:43:22
	 */
	public static Date dayBegin(Date date) {

		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到某天 23:59:59时刻的date实例
	 * 
	 * 
	 *            如果date==null 返回 得到当天 23:59:59时刻的date实例
	 * @return
	 * @author dixingxing
	 * @since 2008-9-5 下午03:51:50
	 */
	public static Date dayEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 今天加上天数 dayAmount 后的日期
	 * 
	 * @param dayAmount
	 * @return
	 * @author zhouruixing
	 * @since 2008-10-31 03:30:50
	 */
	public static Date addDayOnToday(int dayAmount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, dayAmount);
		return calendar.getTime();
	}

	/**
	 * 指定日期 加上小时后的日期
	 * 
	 */
	public static Date addHouse(int houseAmount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY, -houseAmount);
		return calendar.getTime();
	}

	/**
	 * 指定日期 加上天数 dayAmount 后的日期
	 * 
	 * @param dayAmount
	 * 
	 * @return
	 * @author zhouruixing
	 * @since 2009-4-14 11:45:50
	 */
	public static Date addDayOnDate(Date date, int dayAmount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dayAmount);
		return calendar.getTime();
	}

	/**
	 * 指定日期 加上小时 后的日期
	 * 
	 * 
	 * @param hour
	 * @return
	 * @author
	 */
	public static Date addHourOnDate(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}

	/**
	 * 指定日期 加上分钟 后的日期
	 * 
	 * 
	 * @return
	 * @author
	 */
	public static Date addMinuteOnDate(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	/**
	 * 指定日期 加上月数 monthAmount 后的日期 *
	 * 
	 * @param monthAmount
	 * 
	 * @return
	 * @author zhouruixing
	 * @since 2009-4-14 上午12:03:50
	 */
	public static Date addMonthOnDate(Date date, int monthAmount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, monthAmount);
		return calendar.getTime();
	}

	/**
	 * 指定日期 加上年数 monthAmount 后的日期 *
	 * 
	 * @param yearAmount
	 * 
	 * @return
	 * @author zhouruixing
	 * @since 2009-4-14 上午12:03:50
	 */
	public static Date addYearOnDate(Date date, int yearAmount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, yearAmount);
		return calendar.getTime();
	}

	/**
	 * 判断某日期是否为今天
	 * 
	 * 
	 * @return
	 * @author dixingxing
	 * @since 2008-9-23 下午06:00:39
	 */
	public static boolean isToday(Date date) {
		if (date == null) {
			return false;
		}
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		b.setTime(date);
		return a.get(Calendar.DAY_OF_MONTH) == b.get(Calendar.DAY_OF_MONTH)
				&& a.get(Calendar.MONTH) == b.get(Calendar.MONTH)
				&& a.get(Calendar.YEAR) == b.get(Calendar.YEAR);
	}

	/**
	 * 判断某日期是否为今天
	 * 
	 * @return
	 * @author gaoxinzhan
	 * @since 2010-04-13 下午06:00:39
	 */
	public static boolean isToday(String dateStr) {

		return isToday(parse(dateStr));
	}

	public static Date getFirstDayofMonth(Date date) {
		Calendar cDay1 = Calendar.getInstance();
		cDay1.setTime(date);
		cDay1.set(Calendar.DAY_OF_MONTH, 1);
		return cDay1.getTime();
	}

	public static Date getLastDayofMonth(Date date) {
		Calendar cDay1 = Calendar.getInstance();
		cDay1.setTime(date);
		cDay1.set(Calendar.DAY_OF_MONTH,
				cDay1.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cDay1.getTime();
	}

	/**
	 * @param str
	 *            yyMMddHHmmss
	 * @return
	 * @throws ParseException
	 */
	public static Date parseFullTime(String str) {
		try {
			return new SimpleDateFormat("yyMMddHHmmss").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * @param str
	 *            yyMMddHHmmss
	 * @return
	 * @throws ParseException
	 */
	public static Date parseLongTime(String str) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 将ddMMMyy 转换成 yyyy-MM-dd
	 * 
	 * StrSev
	 * @return
	 */
	public static String parseTen(String dateStrSev) {
		try {
			StringBuilder dateRe = new StringBuilder();
			dateRe.append(dateStrSev.substring(0, 2));
			if (dateStrSev.substring(2, 5).equalsIgnoreCase("JAN")) {
				dateRe.append("01");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("FEB")) {
				dateRe.append("02");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("MAR")) {
				dateRe.append("03");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("APR")) {
				dateRe.append("04");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("MAY")) {
				dateRe.append("05");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("JUN")) {
				dateRe.append("06");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("JUL")) {
				dateRe.append("07");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("AUG")) {
				dateRe.append("08");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("SEP")) {
				dateRe.append("09");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("OCT")) {
				dateRe.append("10");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("NOV")) {
				dateRe.append("11");
			} else if (dateStrSev.substring(2, 5).equalsIgnoreCase("DEC")) {
				dateRe.append("12");
			}
			if (dateRe.toString().length() == 4) {
				dateRe.append(dateStrSev.substring(5, 7));
			}
			if (dateRe.toString().length() == 6) {
				SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
				Date date = sdf.parse(dateRe.toString());

				return FastDateFormat.getInstance("yyyy-MM-dd").format(date);
			}
			return null;
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 *            date 返回指定时间后一天的时间
	 */
	public static Date parseNextDayTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 
	 *            date 返回指定时间前一天的时间
	 */
	public static Date parsePreDayTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 
	 *            date 返回指定时间后指定天数的时间
	 */
	public static Date parseNextDayTime(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, i);
		return cal.getTime();
	}

	/**
	 * 
	 *            date 返回指定时间上星期同一天的时间
	 */
	public static Date parsePreDayTimeLastWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -7);
		return cal.getTime();

	}

	/**
	 * 
	 *            date 返回指定时间上年的同一天的时间
	 */
	public static Date parsePreDayTimeLastYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -1);
		return cal.getTime();

	}

	/**
	 * 
	 *            date 返回指定时间前一个月的时间
	 */
	public static Date parsePreMonthTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 
	 *            date 返回指定时间前一个月的时间
	 */
	public static Date parsePre3MonthTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -3);
		return cal.getTime();
	}

	/**
	 * 
	 * 
	 * @return Date 返回下个某个小时
	 */
	public static Date parseNextHourTime(Date date, Integer hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hour);
		return cal.getTime();
	}

	/**
	 * 
	 *            date 返回指定时间下一个月的时间
	 */
	public static Date parseNextMonthTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 
	 *            date yyyymm 返回指定月的第一天
	 */
	public static String parseFirstDayOfMonth(String date) {

		Date date1 = parse(date);
		date1.setDate(1);
		return longDate(date1);
	}

	/**
	 * 
	 *            date yyyymm 返回指定月的最后一天
	 */
	public static String parseLastDayOfMonth(String date) {

		Date date1 = parse(date);

		String s = longDate(date1);
		String ss[] = s.split("-");
		StringBuilder sb = new StringBuilder();
		sb.append(ss[0]).append("-").append(ss[1]).append("-").append("31");

		return sb.toString();
	}

	/**
	 * 
	 *            date yyyymm 返回指定当前月的上一月的第一天
	 */
	public static String parseFirstDayOfLastMonth() {

		return parseFirstDayOfMonth(shortMonth(parsePreMonthTime(new Date())));
	}

	/**
	 * 
	 *            date yyyymm 返回指定当前月的上一月的最后一天
	 */
	public static String parseLastDayOfLastMonth() {

		return parseLastDayOfMonth(shortMonth(parsePreMonthTime(new Date())));
	}

	/**
	 * 
	 *            date yyyymm 返回指定月的上一月的第一天
	 */
	public static String parseFirstDayOfLastMonth(Date date) {

		return parseFirstDayOfMonth(shortMonth(parsePreMonthTime(date)));
	}

	/**
	 * 
	 *            date yyyymm 返回指定月的上一月的最后一天
	 */
	public static String parseLastDayOfLastMonth(Date date) {

		return parseLastDayOfMonth(shortMonth(parsePreMonthTime(date)));
	}

	public static List<String> initMonthList(int count, String selectedMonth) {
		boolean isMatched = false;
		List<String> shortMonthList = new ArrayList<String>();
		Date now = new Date();
		for (int i = 0; i < count; i++) {
			if (shortMonth(now).equals(selectedMonth)) {
				isMatched = true;
			}
			shortMonthList.add(shortMonth(now));
			now = parsePreMonthTime(now);
		}
		if (!isMatched) {
			shortMonthList.add(selectedMonth);
		}
		return shortMonthList;
	}
	/**
	 * 
	 *            date 返回当天的前四天的时间
	 */
	public static Date parseLastDayTime(int internal) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -internal);
		return cal.getTime();

	}
	/**
	 * 
	 *            date 返回当天的前四天的时间
	 */
	public static Date parseLastFourDayTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -4);
		return cal.getTime();

	}

	/**
	 * 
	 *            date 返回当天的前三天的时间
	 */
	public static Date parseLastThreeDayTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -3);
		return cal.getTime();

	}

	/**
	 * 
	 *            date 返回当天的前一天的时间
	 */
	public static Date parseNextLastDay() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 
	 *            date 返回可申请行程单时间的时间
	 */
	public static Date parseApplyInvoiceDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -6);
		return cal.getTime();
	}

	/**
	 * 
	 *            date 返回现在24小时前的时间
	 */
	public static Date parseLast24Hour() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR, -24);
		return cal.getTime();
	}

	/**
	 * 
	 * 
	 * @return String 返回指定日所在周的最后一天
	 */
	public static String getLastDayOfWeek(Date targetDate) {
		Calendar target = GregorianCalendar.getInstance();
		target.setTime(targetDate);
		int day = target.get(Calendar.DAY_OF_WEEK) - 1;
		target.add(Calendar.DATE, 7 - day);
		return longDate(target.getTime());
	}

	/**
	 * 
	 * 
	 * @return String 返回指定日所在周的第一天
	 */
	public static String getFirstDayOfWeek(Date targetDate) {
		Calendar target = GregorianCalendar.getInstance();
		target.setTime(targetDate);
		int day = target.get(Calendar.DAY_OF_WEEK) - 1;
		target.add(Calendar.DATE, 1 - day);
		return longDate(target.getTime());
	}

	/**
	 * 
	 * 
	 * @return Date 返回指定日前一周的一个日期
	 */
	public static Date parsePreWeek(Date targetDay) {
		Calendar target = GregorianCalendar.getInstance();
		target.setTime(targetDay);
		target.add(Calendar.DATE, -7);
		return target.getTime();
	}

	/**
	 * 
	 * 
	 * @return Date 返回指定日前月的一个日期
	 */
	public static Date parsePreMonth(Date targetDay) {
		Calendar target = GregorianCalendar.getInstance();
		target.setTime(targetDay);
		target.add(Calendar.DATE, -28);
		return target.getTime();
	}

	/**
	 * 
	 * 
	 * @return Date 返回指定日后一周的一个日期
	 */
	public static Date parseNextWeek(Date targetDay) {
		Calendar target = GregorianCalendar.getInstance();
		target.setTime(targetDay);
		target.add(Calendar.DATE, 7);
		return target.getTime();
	}

	/**
	 * 
	 * 
	 * @return string 返回指定日期所在的周
	 */
	public static String getWeekDispalyInfo(String targetWeek) {
		Calendar target = GregorianCalendar.getInstance();
		target.setFirstDayOfWeek(Calendar.MONDAY);
		target.setTime(parse(targetWeek));
		int year = target.get(Calendar.YEAR);
		int week = target.get(Calendar.WEEK_OF_YEAR);
		String displayInfo = year + "年第" + week + "周";
		return displayInfo;
	}
	/**
	 * 
	 * 
	 * @return string 返回指定日期所在的周
	 */
	public static int getWeek(String targetWeek) {
		Calendar target = GregorianCalendar.getInstance();
		target.setFirstDayOfWeek(Calendar.MONDAY);
		target.setTime(parse(targetWeek));
		int week = target.get(Calendar.WEEK_OF_YEAR);
		return week;
	}

	/*
	 * 将时间转换成星期
	 * 
	 * 
	 * 
	 * @return
	 */
	public static String parseWeek(Date date) {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayNames[dayOfWeek - 1];
	}

	/*
	 * 将时间转换成星期
	 * 
	 * 
	 * 
	 * @return
	 */
	public static String parseWeekend(Date date) {
		final String dayNames[] = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayNames[dayOfWeek - 1];
	}

	/**
	 * 计算某一天在某一周里的某一天（Locale.US格式）周日=1 周一=2.....周五=6、周六=7
	 */
	public static int getDayOfWeekByLocaleUS(Date date) {
		Calendar calendar = Calendar.getInstance(Locale.US);
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);

	}

	/**
	 * 
	 * 
	 * @return 返回月份和天
	 */
	public static String getMonday(Date date) {
		return FastDateFormat.getInstance("MM-dd").format(date);
	}

	/**
	 * 
	 * 
	 * @return string 返回指定日期所在的周第一天
	 */
	public static Date getWeekFirstDay(String targetWeek) {
		Calendar target = GregorianCalendar.getInstance();
		target.setFirstDayOfWeek(Calendar.WEDNESDAY);
		target.setTime(parse(targetWeek));
		int day = target.get(Calendar.DAY_OF_WEEK);
		if (day == 7) {
			day = 0;
		}
		target.add(Calendar.DATE, -day);

		return dayBegin(target.getTime());
	}

	/**
	 * 
	 * 
	 * @return string 返回指定日期所在的周最后第一天
	 */
	public static Date getWeekLastDay(String targetWeek) {
		Calendar target = GregorianCalendar.getInstance();
		target.setFirstDayOfWeek(Calendar.WEDNESDAY);
		target.setTime(parse(targetWeek));
		int day = target.get(Calendar.DAY_OF_WEEK);
		if (day == 7) {
			day = 0;
		}

		target.add(Calendar.DATE, 6 - day);

		return dayEnd(target.getTime());
	}

	/**
	 * *
	 * 
	 * @param count
	 *            下拉列表的个数 selectedWeek 选中的周的最后一天
	 * 
	 * @return Date 初始化页面周选择下拉列表
	 */
	public static List<String> initWeekList(int count, String selectedWeek) {
		boolean isMatched = false;
		List<String> shortMonthList = new ArrayList<String>();
		Date now = new Date();
		for (int i = 0; i < count; i++) {
			if (getLastDayOfWeek(now).equals(selectedWeek)) {
				isMatched = true;
			}
			shortMonthList.add(getLastDayOfWeek(now));
			now = parsePreWeek(now);
		}
		if (!isMatched) {
			shortMonthList.add(selectedWeek);
		}
		return shortMonthList;
	}

	/**
	 * 将日期转换为航信中的日期格式
	 * 
	 * 
	 * @return String 12DEC
	 * @author gaoxinzhan
	 * 
	 */
	public static String parseHamDate(Date date) {
		String month[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
				"AUG", "SEP", "OCT", "NOV", "DEC" };
		StringBuffer dateBuffer = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		dateBuffer.append(cal.get(cal.DATE)).append(month[cal.get(cal.MONTH)]);
		return dateBuffer.toString();

	}

	/**
	 * 将日期串转换为航信中的日期格式
	 * 
	 * @return String DEC11
	 * @author gaoxinzhan
	 * 
	 */
	public static String parseHamInfantDate(String chdBirthday) {
		return FastDateFormat.getInstance("MMMyy", Locale.ENGLISH)
				.format(parse(chdBirthday)).toUpperCase();
	}

	public static List<String> dateWeekList(String startDateStr,
			String endDateStr) {
		Date startDate = parse(startDateStr);
		Date endDate = parse(endDateStr);
		List<String> shortMonthList = new ArrayList<String>();

		Calendar target = GregorianCalendar.getInstance();
		target.setFirstDayOfWeek(Calendar.MONDAY);
		target.setTime(startDate);
		int year = target.get(Calendar.YEAR);
		int week = target.get(Calendar.WEEK_OF_YEAR);
		String displayInfo = year + "年第" + week + "周";

		return null;
	}

	@SuppressWarnings("null")
	public static List<String> dateMonthList(String startDateStr,
			String endDateStr) {
		try {
			Date startDate = parse(startDateStr);
			Date endDate = parse(endDateStr);
			int months = dispersionMonth(startDate, endDate);
			List<String> shortMonthList = new ArrayList<String>();
			String data[] = null;
			for (int i = 0; i < months; i++) {
				if (i == 0) {
					shortMonthList.add(startDateStr);
					data[i] = startDateStr;
				} else {
					shortMonthList.add(data[i]);
				}
				data[i + 1] = parseNextMonthTime(parse(data[i])).toString();
			}
			return shortMonthList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}

	public static int dispersionMonth(Date s, Date e) {
		if (s.after(e)) {
			Date t = s;
			s = e;
			e = t;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(s);
		Calendar end = Calendar.getInstance();
		end.setTime(e);
		Calendar temp = Calendar.getInstance();
		temp.setTime(e);
		temp.add(Calendar.DATE, 1);

		int y = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int m = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);

		if ((start.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {// 前后都不破月
			return y * 12 + m + 1;
		} else if ((start.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {// 前破月后不破月
			return y * 12 + m;
		} else if ((start.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {// 前不破月后破月
			return y * 12 + m;
		} else {// 前破月后破月
			return (y * 12 + m - 1) < 0 ? 0 : (y * 12 + m - 1);
		}

	}

	public static int dispersionDay(Date s, Date e) {
		if (s.after(e)) {
			Date t = s;
			s = e;
			e = t;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(s);
		Calendar end = Calendar.getInstance();
		end.setTime(e);
		Calendar temp = Calendar.getInstance();
		temp.setTime(e);
		temp.add(Calendar.DATE, 1);

		if ((start.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {// 前后都不破月
			return 0;
		} else if ((start.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {// 前破月后不破月
			return getDayP(start);
		} else if ((start.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {// 前不破月后破月
			return end.get(Calendar.DATE);
		} else {// 前破月后破月
			if (start.get(Calendar.MONTH) == end.get(Calendar.MONTH)
					&& start.get(Calendar.YEAR) == end.get(Calendar.YEAR)) {
				return end.get(Calendar.DATE) - start.get(Calendar.DATE) + 1;
			} else {
				return getDayP(start) + end.get(Calendar.DATE);
			}
		}
	}

	public static int getDayP(Calendar s) {
		int d;
		if (s.get(Calendar.MONTH) == 1 && s.get(Calendar.YEAR) % 4 == 0
				&& s.get(Calendar.YEAR) % 100 != 0) {// 闰年2月
			d = 29;
		} else {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			m.clear();
			m.put(1, 31);
			m.put(3, 31);
			m.put(5, 31);
			m.put(7, 31);
			m.put(8, 31);
			m.put(10, 31);
			m.put(12, 31);
			m.put(4, 30);
			m.put(6, 30);
			m.put(9, 30);
			m.put(11, 30);
			m.put(2, 28);
			d = m.get(s.get(Calendar.MONTH) + 1);
		}
		return d - s.get(Calendar.DATE) + 1;
	}

	/** 求两个日期之间的相隔天数 */
	public static int daysBetween(Date data1, Date data2) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.getTimeInMillis();
		if (data1.after(data2)) {
			cNow.setTime(data1);
			cReturnDate.setTime(data2);
		} else {
			cNow.setTime(data2);
			cReturnDate.setTime(data1);
		}

		setTimeToMidnight(cNow);
		setTimeToMidnight(cReturnDate);
		long todayMs = cNow.getTimeInMillis();
		long returnMs = cReturnDate.getTimeInMillis();
		long intervalMs = todayMs - returnMs;
		return millisecondsToDays(intervalMs);
	}

	private static int millisecondsToDays(long intervalMs) {
		return (int) (intervalMs / (1000 * 86400));
	}

	private static void setTimeToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	}

	public static long secobdsBetween(Date data1, Date data2) {
		Calendar cBefore = Calendar.getInstance();
		Calendar cAfter = Calendar.getInstance();
		if (data1.after(data2)) {
			cAfter.setTime(data1);
			cBefore.setTime(data2);
		} else {
			cAfter.setTime(data2);
			cBefore.setTime(data1);
		}
		long beforeMs = cBefore.getTimeInMillis();
		long afterMs = cAfter.getTimeInMillis();
		long intervalMs = afterMs - beforeMs;
		return (intervalMs / 1000);
	}

	public static long hoursBetween(Date data1, Date data2) {
		Calendar cBefore = Calendar.getInstance();
		Calendar cAfter = Calendar.getInstance();
		if (data1.after(data2)) {
			cAfter.setTime(data1);
			cBefore.setTime(data2);
		} else {
			cAfter.setTime(data2);
			cBefore.setTime(data1);
		}
		long beforeMs = cBefore.getTimeInMillis();
		long afterMs = cAfter.getTimeInMillis();
		long intervalMs = afterMs - beforeMs;
		return (intervalMs / (1000 * 60 * 60));
	}

	/**
	 * 判断是否是有效的一个yyyy-MM-dd格式的日期
	 * 
	 * 
	 * @return
	 */
	public static boolean isValidDate(String value) {
		String patternStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?"
				+ "[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))"
				+ "|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|"
				+ "(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12"
				+ "35679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))"
				+ "[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))"
				+ "[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?["
				+ "1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern pattern = Pattern.compile(patternStr);
		return pattern.matcher(value).matches();
	}

	public static int compareToday(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Long now = Long.valueOf(sdf.format(new Date()));
			Date date = parseWholeDate(dateStr);
			Long dateInt = Long.valueOf(sdf.format(date));
			if (now > dateInt) {
				return -1;
			} else if (now.equals(dateInt.intValue())) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}

	}

	/**
	 * 给定一个日期，一个时间字符串，返回时间
	 * 
	 * 
	 * @return
	 */
	public static Date parseTime(Date avResultDate, String orgTimeStr) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(avResultDate);
		calendar.set(Calendar.HOUR_OF_DAY,
				Integer.parseInt(orgTimeStr.substring(0, 2)));
		calendar.set(Calendar.MINUTE, Integer.parseInt(orgTimeStr.substring(2)));
		return calendar.getTime();
	}

	/**
	 * 判定报表下载的日期是否在换支付宝接口之后
	 * 
	 * @return
	 */
	public static boolean isNewReportAble(Date startDate) {
		Date changeInterfaceDate = parse("2009-03-01");
		return startDate.after(changeInterfaceDate);
	}

	/**
	 * 给定一个时间串 9:00-12:00 ,判定给定的时间是否在指定的时间段内
	 * 
	 * 
	 * @return
	 */
	public static boolean isInTimeSegment(String timeSegment, Date specifyDate) {
		Calendar specifyTime = Calendar.getInstance();
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();

		String startTimeStr = timeSegment.split("-")[0];
		String endTimeStr = timeSegment.split("-")[1];

		specifyTime.setTime(specifyDate);

		startTime.setTime(specifyDate);
		startTime.set(Calendar.HOUR_OF_DAY,
				Integer.parseInt(startTimeStr.split(":")[0]));
		startTime.set(Calendar.MINUTE,
				Integer.parseInt(startTimeStr.split(":")[1]));

		endTime.setTime(specifyDate);
		endTime.set(Calendar.HOUR_OF_DAY,
				Integer.parseInt(endTimeStr.split(":")[0]));
		endTime.set(Calendar.MINUTE, Integer.parseInt(endTimeStr.split(":")[1]));

		return specifyTime.before(endTime) && specifyTime.after(startTime);
	}

	public static String getUseTime(java.sql.Timestamp gmtUpdateLase) {
		String str = "";
		Long currentDate = new Date().getTime();
		Long lastDate = gmtUpdateLase.getTime();
		long resultDate = (currentDate - lastDate) / 1000;

		if (resultDate >= (60 * 60)) {
			String test = String.valueOf(resultDate);
			long dd = resultDate / (60 * 60);

			str = str + (Math.floor(resultDate / (60 * 60))) + "小时";
			resultDate = resultDate % (60 * 60);
		}
		if (resultDate >= 60) {
			str = str + (Math.floor(resultDate / (60))) + "分钟";
		}
		return str + "前";
	}

	public static Date parseDateStr(String dateStr) {
		// 20100629083234
		try {
			String year = dateStr.substring(0, 4);
			String month = dateStr.substring(4, 4 + 2);
			String day = dateStr.substring(6, 6 + 2);
			String h = dateStr.substring(8, 8 + 2);
			String m = dateStr.substring(10, 10 + 2);
			String s = dateStr.substring(12, 12 + 2);
			Calendar c = Calendar.getInstance();
			c.set(Integer.valueOf(year), Integer.valueOf(month),
					Integer.valueOf(day), Integer.valueOf(h),
					Integer.valueOf(m), Integer.valueOf(s));
			return c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取当前时间月底
	 * 
	 * @return
	 */
	public static String thisMonthEnd() {
		Calendar localTime = Calendar.getInstance();
		String strY = null;
		String strZ = null;
		boolean leap = false;
		int x = localTime.get(Calendar.YEAR);
		int y = localTime.get(Calendar.MONTH) + 1;
		if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10
				|| y == 12) {
			strZ = "31";
		}
		if (y == 4 || y == 6 || y == 9 || y == 11) {
			strZ = "30";
		}
		if (y == 2) {
			leap = leapYear(x);
			if (leap) {
				strZ = "29";
			} else {
				strZ = "28";
			}
		}
		strY = y >= 10 ? String.valueOf(y) : ("0" + y);
		return x + "-" + strY + "-" + strZ;
	}

	public static boolean leapYear(int year) {
		boolean leap;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					leap = true;
				} else {
					leap = false;
				}
			} else {
				leap = true;
			}
		} else {
			leap = false;
		}
		return leap;
	}

	/**
	 * 判断旧有效期和新有效期是否有日期冲突 。 注：新开始有效期不能为空
	 * 
	 * @param oldStartDate
	 * @param oldEndDate
	 * @param newStartDate
	 * @param newEndDate
	 * @return
	 */
	public static boolean compare4Date(Date oldStartDate, Date oldEndDate,
			Date newStartDate, Date newEndDate) {
		boolean isCompare = false;
		Long oldS = oldStartDate == null ? null : oldStartDate.getTime();
		Long oldE = oldEndDate == null ? null : oldEndDate.getTime();
		Long newS = newStartDate == null ? null : newStartDate.getTime();
		Long newE = newEndDate == null ? null : newEndDate.getTime();

		if (oldS == null && oldE != null) {
			if (newS <= oldE || (newE != null && newE <= oldE)) {
				isCompare = true;
			}
		} else if (oldE != null) {
			if ((newS >= oldS && newS <= oldE)
					|| (newE != null && newE >= oldS && newE <= oldE)
					|| (newE == null && newS <= oldS)) {
				isCompare = true;
			}
			if (newE != null && newS <= oldS && newE >= oldE) {
				isCompare = true;
			}
			if (newE != null && newS >= oldS && newE <= oldE) {
				isCompare = true;
			}
		} else if (oldE == null) {
			if (newS >= oldS || (newE == null && newS <= oldS)
					|| (newE != null && newE >= oldS)) {
				isCompare = true;
			}
		}
		return isCompare;
	}

	public static String buildDateStr(Date date) {
		String dateStr = "";
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		dateStr += c.get(Calendar.YEAR);
		dateStr += appendStr(String.valueOf(c.get(Calendar.MONTH) + 1), 2, "0");
		dateStr += appendStr(String.valueOf(c.get(Calendar.DATE)), 2, "0");
		dateStr += appendStr(String.valueOf(c.get(Calendar.HOUR_OF_DAY)), 2,
				"0");
		dateStr += appendStr(String.valueOf(c.get(Calendar.MINUTE)), 2, "0");
		dateStr += appendStr(String.valueOf(c.get(Calendar.SECOND)), 2, "0");
		return dateStr;
	}

	public static String appendStr(String txt, int len, String appstr) {
		txt = appstr + txt;
		if (txt.length() > len) {
			txt = txt.substring(txt.length() - len, txt.length());
		}
		return txt;
	}

	public static Date toDate(String dateStr, String format) {
		Date todate = null;
		try {
			todate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(
					format);
			todate = sdf.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("String to Date error");
		}
		return todate;
	}
	/**
	 * 获取当前日期前一天的开始时间（0时0分0秒）
	 * @return
	 */
	public static String getPreDateStart(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	/**
	 * 获取当前日期前一天的结束时间（23时59分59秒）
	 * @return
	 */
	public static String getPreDateEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	/**
	 * 获取当前日期的开始时间（0时0分0秒）
	 * @return
	 */
	public static String getDateStart(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) );
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	/**
	 * 获取当前日期前一天的结束时间（23时59分59秒）
	 * @return
	 */
	public static String getDateEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) );
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	/**
	 * 获取当前日期前一天的开始时间（0时0分0秒）
	 * @return
	 */
	public static String getPreDateStart(){
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date.getTime());
	}
	/**
	 * 获取当前日期前一天的结束时间（23时59分59秒）
	 * @return
	 */
	public static String getPreDateEnd() {
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
		date.set(Calendar.HOUR_OF_DAY, 23);
		date.set(Calendar.MINUTE, 59);
		date.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date.getTime());
	}
	
	/**
	 * 获取当前时间前五分钟的时间
	 * @return
	 */
	public static String getPreFiveMinutesTime() {
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.add(Calendar.MINUTE, -5);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date.getTime());
	}
	
	/**
	 * 获取当前日期前一天的开始时间（0时0分0秒）
	 * @return
	 */
	public static String getPreDateStart(Integer day){
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date.getTime());
	}
	/**
	 * 获取当前日期前一天的结束时间（23时59分59秒）
	 * @return
	 */
	public static String getPreDateEnd(Integer day) {
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
		date.set(Calendar.HOUR_OF_DAY, 23);
		date.set(Calendar.MINUTE, 59);
		date.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date.getTime());
	}
	
	/**
	 * 获取当前日期前一天的开始时间（0时0分0秒）
	 * @return
	 */
	public static String getAfterDateStart(Integer day){
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) + day);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date.getTime());
	}
	/**
	 * 获取当前日期前一天的结束时间（23时59分59秒）
	 * @return
	 */
	public static String getAfterDateEnd(Integer day) {
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) + day);
		date.set(Calendar.HOUR_OF_DAY, 23);
		date.set(Calendar.MINUTE, 59);
		date.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date.getTime());
	}
	
	/**
	 * 获取当前日期前一天的结束时间（23时59分59秒）
	 * @return
	 */
	public static String getPreDateEnd(Date date, Integer day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) - day);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	/**
	 * 获取当前日期的开始时间（0时0分0秒）
	 * @return
	 */
	public static String getPreDateStart(Date date, Integer day){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) - day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	
	/**
	 * 获取当前日期前一天的结束时间（23时59分59秒）
	 * @return
	 */
	public static String getAfterDateEnd(Date date, Integer day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) + day);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	/**
	 * 获取当前日期的开始时间（0时0分0秒）
	 * @return
	 */
	public static String getAfterDateStart(Date date, Integer day){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) + day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	
	public static Date AddDayDate(Date oldDate,int addAmount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(oldDate);
		calendar.add(Calendar.DATE, addAmount);
		return calendar.getTime();
	}
	
	/**
	 * 获取当前时间的前一天，format="yyyy-MM-dd"
	 */
	public static String getPreDate(){
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return  sdf.format(date.getTime());
	}
	
	public static String getDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return  sdf.format(date.getTime());
	} 
	
	/**
	 * 获取当前时间的前一天，format="yyyy-MM-dd"
	 */
	public static String getPreDate(Date beginDate){
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return  sdf.format(date.getTime());
	}
	
	/**
	 * @Description 按照yyMMddHHmmssSSS格式返回时间字符串
	 * @throws
	 * 
	 * @return String
	 * @Author 王琳
	 * @Date 2016-3-21
	 */
	public static String shortYearWholeDate(Date date) {
		return FastDateFormat.getInstance("yyMMddHHmmssSSS").format(date);
	}
	
	/**
	 * @Description 按照yyyyMMddHHmmss格式返回时间字符串
	 * @throws
	 * 
	 * @return String
	 * @Author 王琳
	 * @Date 2016-6-12
	 */
	public static String longWholeDate(Date date) {
		return FastDateFormat.getInstance("yyyyMMddHHmmss").format(date);
	}
	
	/**
	 * @Description 按照yyyyMM格式返回时间字符串
	 * @throws
	 * 
	 * @return String
	 * @Author 王琳
	 * @Date 2017-8-25
	 */
	public static String shortYearMonthDate(Date date) {
		return FastDateFormat.getInstance("yyyyMM").format(date);
	}
	
	/**
	 * @Description 比较时间
	 * @throws
	 * 
	 * @param anotherDate
	 * @return int
	 * @Author 王琳
	 * @Date 2016-6-22
	 */
	public static int compareToDate(Date date, Date anotherDate) {
		if (date == null) {
			return -2;
		}
		if(anotherDate == null) {
			anotherDate = date;
		}
		return date.compareTo(anotherDate);
	}
	
	/**
	 * @Description 获取当前日期前几天的日期
	 * @throws
	 * @param day
	 * @return String
	 * @Author 王琳
	 * @Date 2017-6-27
	 */
	public static String getPreDate(int day) {
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return  sdf.format(date.getTime());
	}
	
	/**
	 * @Description 获取某个日期某几天前的日期
	 * @throws
	 * @param beginDate
	 * @param day
	 * @return String
	 * @Author 王琳
	 * @Date 2017-8-10
	 */
	public static String getPreDate(Date beginDate, int day) {
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return  sdf.format(date.getTime());
	}
	
	/**
	 * @Description 获取上一个月第一天
	 * @throws
	 * 
	 * @return String
	 * @Author 王琳
	 * @Date 2017-8-28
	 */
	public static String getLastFirstDayOfMonth(Date date) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	/**
	 * @Description 获取上一个月最后一天
	 * @throws
	 * 
	 * @return String
	 * @Author 王琳
	 * @Date 2017-8-28
	 */
	public static String getLastMaxMonthDate(Date date) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}	
	
	/**
	 * @Description 获取两个日期之间的日期字符串(包含start与end)
	 * @throws
	 * @param start
	 * @param end
	 * @return List<String>
	 * @Author 王琳
	 * @Date 2017-10-12
	 */
	public static Set<String> getBetweenDates(Date start, Date end) {
		Set<String> result = new HashSet<String>();
		result.add(shortDate(start));
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);
		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd)) {
			result.add(shortDate(tempStart.getTime()));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(shortDate(end));
		return result;
	}
	
	/**
	 * @Description 获取两个日期之间的日期字符串(包含start与end)
	 * @throws
	 * @param start
	 * @param end
	 * @return List<String>
	 * @Author 王琳
	 * @Date 2017-10-12
	 */
	public static Set<String> getBetweenLongDates(Date start, Date end) {
		Set<String> result = new HashSet<String>();
		result.add(longDate(start));
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);
		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd)) {
			result.add(longDate(tempStart.getTime()));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(longDate(end));
		return result;
	}
	
	/**
	 * 获取距离明天23点59分59秒的秒数
	 * 
	 * @return
	 */
	public static int getTomorrowSeconds(Date date){
		Date tom = fullHHmmss(date);
		long time = tom.getTime()-date.getTime();
		return (int) (time/1000);
	}
	
	/**
	 * @Description 获取传入日期的起始日期
	 * @param startTime
	 * @return String
	 * @Author 王琳
	 * @Date 2017-12-22
	 */
	public static String getDateStart(String startTime) {
		Calendar c = Calendar.getInstance();
		c.setTime(parse(startTime));
		c.set(Calendar.DATE, c.get(Calendar.DATE) );
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	
	/**
	 * @Description 获取传入日期的结束日期
	 * @param endTime
	 * @return String
	 * @Author 王琳
	 * @Date 2017-12-22
	 */
	public static String getDateEnd(String endTime) {
		Calendar c = Calendar.getInstance();
		c.setTime(parse(endTime));
		c.set(Calendar.DATE, c.get(Calendar.DATE) );
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(c.getTime());
	}
	
	public static void main(String args[]) {
// 		System.out.println(parseLast24Hour().toString());
//
//
// 		System.out.println(DateUtil.getBetweenDates(DateUtil.addDayOnDate(parse("2017-01-07 00:00:00"), NumberUtil.INTEGER_ONE), DateUtil.addDayOnDate(parse("2017-01-07 23:59:59"), NumberUtil.INTEGER_ONE)));
// 		System.out.println(DateUtil.getBetweenDates(DateUtil.addDayOnDate(parse("2017-01-07 00:00:00"), NumberUtil.INTEGER_ONE), DateUtil.addDayOnDate(parse("2017-01-08 23:59:59"), NumberUtil.INTEGER_ONE)));
// 		System.out.println(shortDate(addDayOnDate(parse("2017-01-07 13:22:13"), 1)));
// 		System.out.println(shortDate(addDayOnDate(parse("2017-01-07"), 1)));
// 		System.out.println(getDateStart("2017-09-10"));
// 		System.out.println(getDateEnd("2017-09-10"));
//
// 		System.out.println(getTomorrowSeconds(new Date()));
// 		System.out.println(DateUtil.getPreDateStart(DateUtil.parse("20171027"), 5));
// 		System.out.println(DateUtil.getAfterDateEnd(DateUtil.parse("20171027"), 3));
// 		System.out.println(DateUtil.getPreDateStart(DateUtil.parse("20171026 23:23:23"), 5));
// 		System.out.println(DateUtil.getAfterDateEnd(DateUtil.parse("20171026 23:23:23"), 3));
// 		Calendar dateCalendar = Calendar.getInstance();
// 		int conditionYear = dateCalendar.get(Calendar.YEAR);
// 		dateCalendar.setTime(DateUtil.parse("20170909"));
// 		// 获取传入时间的年与月
// 		System.out.println(dateCalendar.get(Calendar.YEAR));
// 		System.out.println(dateCalendar.get(Calendar.MONTH) + 1);
//
//
//
// 		System.out.println(DateUtil.longDate(new Date()) + "dd");
// 		System.out.println(DateUtil.getPreDate(new Date(), 2) + "dd");
// 		System.out.println(getLastFirstDayOfMonth(new Date()));
// 		System.out.println(getLastMaxMonthDate(new Date()));
//
//
// 		System.out.println(DateUtil.getBetweenDates(DateUtil.parse("2017-09-10 23:23:23"), DateUtil.parse("2017-10-06 10:09:09")));
// 		System.out.println(DateUtil.longDate(DateUtil.parse(DateUtil.getPreDate(new Date()))));
// 		System.out.println(DateUtil.getPreDate(new Date()));
// 		System.out.println(shortMonth(addMonthOnDate(new Date(), 1)));
// 		Date date = DateUtil.AddDayDate(new Date(), 1);
// 		System.out.println(date);
// 		System.out.println(DateUtil.formatDate("yyyy-MM-dd", date));
// 		System.out.println(new Date(1490856684180l));
// 		System.out.println(parseLastDayTime(7));
//
// 		System.out.println(parse("20170322 15:37:38  ")+"  ---");
		
		// System.out.println(">>>>" + parseTime(new Date(), "1610"));
		// System.out.println(">>>>" + hoursBetween(new Date(), parseTime(new
		// Date(), "1800")));
		// System.out.println(">>>>" + isInTimeSegment("12:00-15:11", new Date()));

		// System.out.println(">>>>" + compareToday("2009-10-20 16:46:55"));

		// System.out.println(parseFirstDayOfMonth(shortMonth(parsePreMonthTime(
		// new
		// Date()))));
		// System.out.println(parseLastDayOfMonth(shortMonth(parsePreMonthTime(new
		// Date()))));

		// Date date = parse("200902");
		//
		// String s = longDate(date);
		// String ss[] = s.split("-");
		// StringBuilder sb = new StringBuilder();
		// sb.append(ss[0]).append("-").append(ss[1]).append("-").append("31");
		// String sb = parseLastDayOfMonth("20096");
		// System.out.println(sb);
		// SimpleDateFormat aa = new SimpleDateFormat("ddMMM");
		// Date date = new Date();
		// System.out.println(date);
		// System.out.println(aa.format(date));
		// // System.out.println(clearHHmmss(new Date()));
		// compareDate(new Date(), new Date());
		// compareSameDate(date, date);
		// crsDate(date);
		// System.out.println(dateParse("22jul"));
		// ;
		// isWorkTimeNow();
		// longDate(date);
		// shortDate(date);
		// tinyDates(date, date);
		// System.out.println(parseTen("11OCT80"));
		// List<String> shortMonthList = initMonthList(5,"2008-01");
		// for (String str : shortMonthList) {
		// System.out.println(str);
		// }
		// String shortMonth = "2008-10";
		// Date tempDate = parse(shortMonth);
		// System.out.println(shortMonth(tempDate));

		// Calendar now = GregorianCalendar.getInstance();
		//
		// int week = now.get(Calendar.WEEK_OF_YEAR);
		//
		//
		// System.out.println("开始");
		// System.out.println(getFirstDayOfWeek(now.getTime()));
		// System.out.println("结束");
		// System.out.println(getLastDayOfWeek(now.getTime()));
		// System.out.println("今天");
		// System.out.println(longDate(now.getTime()));
		// System.out.println("年的第几周");
		// System.out.println(week);
		//
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		// String datestr = sdf.format(now.getTime());
		// System.out.println(datestr);
		// Calendar now = GregorianCalendar.getInstance();
		//
		// List<String> initWeekList = initWeekList(5,
		// getLastDayOfWeek(now.getTime()));
		// for (String str : initWeekList) {
		// System.out.println(getWeekDispalyInfo(str));
		// System.out.println(str);
		// }
		// Calendar aCalendar = Calendar.getInstance();
		// // 里面野可以直接插入date类型
		// aCalendar.setTime(parse("2005-02-01"));
		// // 计算此日期是一年中的哪一天
		// int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		// aCalendar.setTime(parse("2006-03-01"));
		// int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		// // 求出两日期相隔天数
		// Date date1 = new Date();
		//
		// Calendar cNow = Calendar.getInstance();
		// cNow.set(2009, 10, 26, 13, 50, 0);
		// Date date2 = cNow.getTime();
// 		System.out.println(parseHamInfantDate("2006-03-01"));
		// Calendar aCalendar = Calendar.getInstance();
		// // 里面野可以直接插入date类型
		// aCalendar.setTime(parse("2005-02-01"));
		// // 计算此日期是一年中的哪一天
		// int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		// aCalendar.setTime(parse("2006-03-01"));
		// int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		// // 求出两日期相隔天数
		// Date date1 = new Date();
		// Calendar cNow = Calendar.getInstance();
		// cNow.set(2009, 10, 26, 13, 50, 0);
		// Date date2 = cNow.getTime();
		// long days = date2.getTime() - date1.getTime();
		// days = days / 1000 / 60 / 60 / 24;
		// System.out.println(days + "========" +
		// dispersionMonth(parse("2005-02-01"),
		// parse("2006-03-01")));
		// System.out.println("=====SSSSSSSSSSS====" +
		// dateMonthList("2005-02-01",
		// "2006-03-01").size());
		// for (int i = 0; i < dateMonthList("2005-02-01", "2006-03-01").size();
		// i++) {
		// System.out.println(parse(dateMonthList("2005-02-01",
		// "2006-03-01").get(i)) +
		// "===================");
		// }
		// try {
		// Date dt = pnrSegDate("SU02MAY0801", "1100");
		// } catch (DateFormatException e) {
		// e.printStackTrace();
		// }
		// String str = "-40%";
		// System.out.println(Double.valueOf(str.replace("%", "").replace(",",
		// "")) / 100);
		// System.out.println(Double.valueOf(str.replace("%", "").replace(",",
		// "")) >= (0.3));
		// System.out.println(getFirstDayofMonth(new Date()));
		// System.out.println(date1);
		// System.out.println(date2);
		// System.out.println(secobdsBetween(date2, date1));
// 		System.out.println(longWholeDate(new Date()));
// 		System.out.println(getPreDateStart(new Date()));
// 		System.out.println(getPreDateEnd(new Date()));
// 		System.out.println(getDate(new Date()));
// 		System.out.println(addDayOnToday(-1));
// 		System.out.println(addHourOnDate(new Date(), -24));
		String formatDate = formatDate("yyyy-MM-dd HH:mm:ss", addHourOnDate(new Date(), -24));
		System.out.println(formatDate);
	}

}
