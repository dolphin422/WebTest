package com.dolphin422.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间日期工具类
 * @author: DamonJT WIN
 * @createDate: 2018.12.12 21:06
 */
public class DateUtil {

    /**
     * 日期时间格式
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式
     * yyyy-MM-dd
     */
    public static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd";

    /**
     * HH:mm:ss
     */
    private static final String FORMAT_TIME = "HH:mm:ss";

    /**
     * 日期时间格式 带毫秒
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String FORMAT_DATE_TIME_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * HHmmss
     */
    private static final String FORMAT_TIME_6 = "HHmmss";

    /**
     * yyyyMMdd
     */
    public static final String FORMAT_DATE_8 = "yyyyMMdd";

    /**
     * MM/dd/yyyy
     */
    public static final String FORMAT_DATE_10 = "MM/dd/yyyy";

    /**
     * yyyyMMddHHmmss
     */
    public static final String FORMAT_DATETIME_14 = "yyyyMMddHHmmss";

    /**
     * 当前系统日期时间
     * String yyyy-MM-dd HH:mm:ss
     *
     * @return 当前时间的字符串，"yyyy-MM-dd HH:mm:ss"
     */
    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_FORMAT_DATE_TIME);
        return df.format(new Date());
    }

    /**
     * 当前系统日期
     * String  "yyyy-MM-dd"
     *
     * @return 当前系统日期字符串 "yyyy-MM-dd"
     */
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_FORMAT_DATE);
        return df.format(new Date());
    }

    /**
     * 得到当前系统日期时间
     *
     * @return 当前时间的格式字符串
     * @throws ParseException
     */
    public static Date getCurrentDateAndTime() {
        Date date = null;
        try {
            date = parseDate(getCurrentDateTime(), DEFAULT_FORMAT_DATE_TIME);
        } catch (ParseException px) {
            px.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转字符串格式 yyyy-MM-dd
     *
     * @param date the date
     * @return string
     */
    public static String formatDateYmd(Date date) {
        DateFormat format1 = new SimpleDateFormat(DEFAULT_FORMAT_DATE);
        return format1.format(date);
    }

    /**
     * 日期转字符串格式
     *
     * @param date    the date
     * @param pattern the pattern
     * @return string
     */
    public static String formatDate(Date date, String pattern) {
        DateFormat format1 = new SimpleDateFormat(pattern);
        return format1.format(date);
    }

    /**
     * 日期字符(必须是"yyyy-MM-dd HH:mm:ss"格式)串转成Date
     *
     * @param dateStr the date str
     * @return date
     * @throws ParseException the parse exception
     */
    public static Date parseDate(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(dateStr);
    }

    /**
     * 日期字符(MM/dd/yyyy或yyyy-MM-dd)串转成Date
     *
     * @param dateStr the date str
     * @return date
     */
    public static Date formatDate(String dateStr) {
        if (dateStr.indexOf("-") != -1) {
            return formatDate(dateStr, DEFAULT_FORMAT_DATE);
        }
        if (dateStr.indexOf("/") != -1) {
            return formatYMDToDate(dateStr);
        }
        return formatYMdToDate(dateStr);
    }

    /**
     * 日期字符(yyyy-MM-dd)串转成Date
     *
     * @param dateStr the date str
     * @return date
     */
    public static Date formatYmdStringToDate(String dateStr) {
        return formatDate(dateStr, DEFAULT_FORMAT_DATE);
    }

    /**
     * 日期字符(MM/dd/yyyy)串转成Date
     *
     * @param dateStr the date str
     * @return date
     */
    public static Date formatYMDToDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT_DATE);
        Date initDate = null;
        try {
            initDate = format.parse(dateStr);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return initDate;
    }

    /**
     * 日期字符(yyyyMMdd)串转成Date
     *
     * @param dateStr the date str
     * @return date
     */
    public static Date formatYMdToDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date initDate = null;
        try {
            initDate = format.parse(dateStr);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return initDate;
    }

    /**
     * 日期字符串转成Date
     *
     * @param dateStr the date str
     * @return date
     * @throws ParseException the parse exception
     */
    public static Date formatDate(String dateStr, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算日期加上年之后的日期
     *
     * @param sourceDate the source date
     * @param year       the year
     * @return date
     */
    public static Date addYear(Date sourceDate, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 计算日期加上月份之后的日期
     *
     * @param sourceDate the source date
     * @param month      the month
     * @return date
     */
    public static Date addMonth(Date sourceDate, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 计算日期加上日之后的日期
     *
     * @param sourceDate the source date
     * @param day        the day
     * @return date
     */
    public static Date addDay(Date sourceDate, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 计算日期加上小时之后的日期
     *
     * @param sourceDate the source date
     * @param hour       the hour
     * @return date
     */
    public static Date addHour(Date sourceDate, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    /**
     * 计算日期加上分钟之后的日期
     *
     * @param sourceDate the source date
     * @param minute     the minute
     * @return date
     */
    public static Date addMinute(Date sourceDate, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * <br>Description:传入日期减少天数
     * <br>Author:刘爽
     * <br>Date:2016年9月5日
     *
     * @param dateStr     日期
     * @param format      日期格式
     * @param decreaseNum 减少天数
     * @return
     */
    public static String decreaseDays(String dateStr, String format, int decreaseNum) {

        SimpleDateFormat dft = new SimpleDateFormat(format);
        Date beginDate = null;
        beginDate = DateUtil.formatDate(dateStr);
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - decreaseNum);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dft.format(endDate);
    }

    /**
     * 比较按年月比较两日期的先后顺序
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return 第一个日期晚于第二个日期 返回正整数  ,相等返回0 , 第一个日期早于第二个 返回负整数
     */
    public static int compareMonthOfDate(Date firstDate, Date secondDate) {
        int date1 = getYearMonth(firstDate);
        int date2 = getYearMonth(secondDate);
        return date1 - date2;
    }

    private static Integer getYearMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置时间
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH);//获取月份
        return year * 100 + month;
    }

    /**
     * 比较按年月日比较两日期的先后顺序
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return 第一个日期晚于第二个日期 返回正整数  ,相等返回0 , 第一个日期早于第二个 返回负整数
     */
    public static int compareDayOfDate(Date firstDate, Date secondDate) {
        int date1 = getMonthAndDay(firstDate);
        int date2 = getMonthAndDay(secondDate);
        return date1 - date2;
    }

    private static Integer getMonthAndDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置时间
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH);//获取月份
        int day = cal.get(Calendar.DAY_OF_MONTH);//获取日期
        return year * 10000 + month * 100 + day;
    }

}
