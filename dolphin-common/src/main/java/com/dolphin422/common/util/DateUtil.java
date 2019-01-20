package com.dolphin422.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
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
     * 时间格式
     * HH:mm:ss
     */
    public static final String DEFAULT_FORMAT_TIME = "HH:mm:ss";

    /**
     * 日期时间格式 带毫秒
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String FORMAT_DATE_TIME_SSS = "yyyy-MM-dd HH:mm:ss.SSS";


    /**
     * 时区
     */
    private static ZoneId zone = ZoneId.systemDefault();

    /**
     * 当前系统日期时间
     * String yyyy-MM-dd HH:mm:ss
     *
     * @return 当前日期时间的字符串，"yyyy-MM-dd HH:mm:ss"
     */
    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        return formatterLdt(now, DEFAULT_FORMAT_DATE_TIME);
    }

    /**
     * 当前系统日期
     * String  "yyyy-MM-dd"
     *
     * @return 当前系统日期的字符串 "yyyy-MM-dd"
     */
    public static String getCurrentDate() {
        LocalDate now = LocalDate.now();
        return formatterLdt(now, DEFAULT_FORMAT_DATE);
    }

    /**
     * 得到当前系统时间
     * String HH:mm:ss
     *
     * @return 当前系统时间的格式字符串
     */
    public static String getCurrentTime() {
        LocalTime now = LocalTime.now();
        return formatterLdt(now, DEFAULT_FORMAT_TIME);
    }

    /**
     * 当前系统日期时间
     *
     * @return java.util.Date
     */
    public static Date currentDateTime() {
        return localDateTime2Date(LocalDateTime.now());
    }

    /**
     * java.util.Date 转换为 java.time.LocalDateTime
     *
     * @param date java.util.Date
     * @return LocalDateTime
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * java.time.LocalDateTime 转换为 java.util.Date
     *
     * @param localDateTime java.time.LocalDateTime
     * @return java.util.Date
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
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
     * <br>Author:
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

    /**
     * 字符串转Date
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static Date convertToDate(String date) throws Exception {
        LocalDate localDate = null;
        if (null == date) {
            throw new NullPointerException("date isn't null");
        } else {
            localDate = LocalDate.parse(date);
            return convertToDate(localDate);
        }
    }

    /**
     * 字符串转LocalDateTime
     *
     * @param date
     * @return localDateTime
     */
    public static LocalDateTime convertToLocalDateTime(String date) {
        LocalDateTime localDateTime = null;
        if (null == date) {
            throw new NullPointerException("date isn't null");
        } else {
            localDateTime = LocalDateTime.parse(date);
            return localDateTime;
        }
    }

    /**
     * LocalDate转Date
     *
     * @param localDate
     * @return Date
     */
    public static Date convertToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalDate转Date
     *
     * @param localDateTime
     * @return Date
     */
    public static Date convertToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * Date转LocalDate
     *
     * @param date
     * @return localDate
     */
    public static LocalDate convertToLocalDate(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant).toLocalDate();
    }

    /**
     * Date转LocalTime
     *
     * @param date
     * @return localDate
     */
    public static LocalTime convertToLocalTime(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant).toLocalTime();
    }

    /**
     * Date转LocalDatetime
     *
     * @param date
     * @return localDate
     */
    public static LocalDateTime convertToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant);
    }

    /**
     * Instant转LocalDateTime
     *
     * @param instant
     * @return
     */
    public static LocalDateTime convertToLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * LocalDateTime转Instant
     *
     * @param localDateTime
     * @return
     */
    public static Instant convertToInstant(LocalDateTime localDateTime) {
        return localDateTime.atZone(zone).toInstant();
    }

    /**
     * LocalDate转Instant
     *
     * @param localDate
     * @return
     */
    public static Instant convertToInstant(LocalDate localDate) {
        return localDate.atStartOfDay(zone).toInstant();
    }

    /**
     * LocalDate转LocalDateTime
     *
     * @param localDate
     * @return LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    /**
     * 日周期格式化
     *
     * @param temporalAccessor
     * @param formatStyle
     * @return
     */
    public static String formatterLdt(TemporalAccessor temporalAccessor, String formatStyle) {
        return DateTimeFormatter.ofPattern(formatStyle).format(temporalAccessor);
    }

    /**
     * 设置年
     *
     * @param sourceDate
     * @param year
     * @return LocalDateTime
     */
    public static LocalDateTime setYear(LocalDateTime sourceDate, Integer year) {
        return sourceDate.withYear(year);
    }

    /**
     * 设置月
     *
     * @param sourceDate
     * @param month
     * @return LocalDateTime
     */
    public static LocalDateTime setMonth(LocalDateTime sourceDate, Integer month) {
        return sourceDate.withMonth(month);
    }

    /**
     * 设置天
     *
     * @param sourceDate
     * @param dayOfMonth
     * @return LocalDateTime
     */
    public static LocalDateTime setDayOfMonth(LocalDateTime sourceDate, Integer dayOfMonth) {
        return sourceDate.withDayOfMonth(dayOfMonth);
    }

    /**
     * 设置小时
     *
     * @param sourceDate
     * @param hour
     * @return
     */
    public static LocalDateTime setHour(LocalDateTime sourceDate, Integer hour) {
        return sourceDate.withHour(hour);

    }

    /**
     * 设置分钟
     *
     * @param sourceDate
     * @param minute
     * @return
     */
    public static LocalDateTime setMinute(LocalDateTime sourceDate, Integer minute) {
        return sourceDate.withMinute(minute);
    }

    /**
     * 设置秒
     *
     * @param sourceDate
     * @param second
     * @return
     */
    public static LocalDateTime setSecond(LocalDateTime sourceDate, Integer second) {
        return sourceDate.withSecond(second);
    }

    /**
     * 修改年月日
     *
     * @param sourceDate
     * @param year
     * @param month
     * @param dayOfMonth
     * @return
     */
    public static LocalDateTime setYMD(LocalDateTime sourceDate, Integer year, Integer month,
                                       Integer dayOfMonth) {
        return sourceDate.withYear(year).withMonth(month).withDayOfMonth(dayOfMonth);
    }

    /**
     * 修改时分秒
     *
     * @param sourceDate
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static LocalDateTime setHMS(LocalDateTime sourceDate, Integer hour, Integer minute,
                                       Integer second) {
        return sourceDate.withHour(hour).withMinute(minute).withSecond(second);
    }

    /**
     * 计算相差的天数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getInteverDays(LocalDate beginDate, LocalDate endDate) {
        Period period = Period.between(beginDate, endDate);
        return period.getDays();
    }

    /**
     * 传入日期 日期加减
     *
     * @param num  数量
     * @param unit 单位
     * @return LocalDate 增加后的日期
     */
    @SuppressWarnings("static-access")
    public static LocalDate addLocalDate(LocalDate localDate, ChronoUnit unit, long num) {
        LocalDate resultDate;
        if (num > 0) {
            resultDate = localDate.plus(num, unit);
        } else {
            resultDate = localDate.minus(Math.abs(num), unit);
        }
        return resultDate;
    }

    /**
     * 传入时间 时分秒加减
     *
     * @param num       数量
     * @param unit      单位
     * @param localTime 原时间
     * @return LocalDateTime 增加后的时间
     */
    @SuppressWarnings("static-access")
    public static LocalTime addLocalTime(LocalTime localTime, ChronoUnit unit, long num) {
        LocalTime resultTime;
        if (num > 0) {
            resultTime = localTime.plus(num, unit);
        } else {
            resultTime = localTime.minus(Math.abs(num), unit);
        }
        return resultTime;
    }

    /**
     * 传入日期时间  日期时间加减
     *
     * @param num           数量
     * @param unit          单位
     * @param localDateTime 原日期
     * @return LocalDateTime 增加后的日期
     */
    @SuppressWarnings("static-access")
    public static LocalDateTime addLocalDateTime(LocalDateTime localDateTime, ChronoUnit unit, long num) {
        LocalDateTime resultDateTime;
        if (num > 0) {
            resultDateTime = localDateTime.plus(num, unit);
        } else {
            resultDateTime = localDateTime.minus(Math.abs(num), unit);
        }
        return resultDateTime;
    }

}
