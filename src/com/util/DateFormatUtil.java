package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {

	private static final String formatType24 = "yyyy-MM-dd HH:mm:ss";//24小时制
	private static final String formatType12 = "yyyy-MM-dd hh:mm:ss";//12小时制
	
	public static Date strToDate(String str) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(formatType24);
		return format.parse(str);
	}
	
	public static Date shortStrToDate(String str) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT_NUM);
		return format.parse(str);
	}
	
	public static String dateToTime(Date date){
		SimpleDateFormat format = new SimpleDateFormat(formatType24);
		return format.format(date);
	}
	
	
    public static final String DATE_FORMAT_TEMPLATE_1 = "%s月%s日 %d:%d";

    public static final String DEFAULT_DATE_FORMAT_NUM = "yyyyMMdd";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_FORMAT_DETAIL = "yyyy-MM-dd hh:mm";
    public static final String DEFAULT_DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat DEFAULT_DATE_FORMATER = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

    public static final String DEFAULT_SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_SHORT_DATE_FORMAT2 = "yyyy/MM/dd";
    public static final SimpleDateFormat DEFAULT_SHORT_DATE_FORMATER = new SimpleDateFormat(DEFAULT_SHORT_DATE_FORMAT);

    /**
     * 前后N天的时间0点
     * 
     * @param calendar
     * @param days
     *            -n:向前n天 n:往后后n天 0:今天
     * @return
     */
    public static Date getDayClockZero(int days) {
    	Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    
    /**
     * 获取某周第一天0点 
     *  -n:向前n周 n:往后后n周 0:本周
     * @param days
     * @return
     */
    public static Date getWeekFirstDayClockZero(int week) {
    	Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, week);
        calendar.add(Calendar.DAY_OF_WEEK, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    

    /**
     * 获取每月第一天0点 
     *  -n:向前n月 n:往后后n月 0:本月
     * 
     * @author Administrator Date:2013-11-26下午5:04:48
     * 
     * @return
     */
    public static Date getMonthFirstDay(int month) {

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, month);
        lastDate.set(Calendar.DAY_OF_MONTH, 1);
        lastDate.set(Calendar.HOUR_OF_DAY, 0);
        lastDate.set(Calendar.MINUTE, 0);
        lastDate.set(Calendar.SECOND, 0);

        return lastDate.getTime();
    }

    /**
     * 获取每月最后一天23:59:59 
     *  -n:向前n月 n:往后后n月 0:本月
     * 
     * @author Administrator Date:2013-11-26下午5:04:27
     * 
     * @return
     */
    public static Date getMonthLastDay(int month) {

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, month);
        lastDate.set(Calendar.DAY_OF_MONTH, 1);
        lastDate.roll(Calendar.DAY_OF_MONTH, -1);
        lastDate.set(Calendar.HOUR_OF_DAY, 23);
        lastDate.set(Calendar.MINUTE, 59);
        lastDate.set(Calendar.SECOND, 59);

        return lastDate.getTime();
    }

    

//-----------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     * 计算两个日期之间相差的秒
     * 
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int secondBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_FULL);
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_second = (time2 - time1) / (1000); // 共计秒数

        return Integer.parseInt(String.valueOf(between_second));
    }


    /**
     * 返回当前日期的星期几
     * 
     * @param date
     * @return
     */
    public static String dayOfWeek(Date date) {
        String week = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
        case 1:
            week = "星期日";
            break;
        case 2:
            week = "星期一";
            break;
        case 3:
            week = "星期二";
            break;
        case 4:
            week = "星期三";
            break;
        case 5:
            week = "星期四";
            break;
        case 6:
            week = "星期五";
            break;
        case 7:
            week = "星期六";
            break;
        }
        return week;
    }
    
    public static final String formatDateClient(Date postDate) {

        if (postDate == null) {
            return null;
        }
        String time = null;
        long todayTime = System.currentTimeMillis();
        long date = postDate.getTime();
        long diffTime = todayTime - date;

        long hours = diffTime / (60 * 60 * 1000);
        if (hours > 96) {
            time = DEFAULT_SHORT_DATE_FORMATER.format(postDate);
        } else if (hours >= 72) {
            time = "3天前";
        } else if (hours >= 48) {
            time = "2天前";
        } else if (hours >= 24) {
            time = "1天前";
        } else if (hours >= 1) {
            time = hours + "小时前";
        } else {
            long minutes = diffTime / (60 * 1000);
            if (minutes > 1) {
                time = minutes + "分钟前";
            } else {
                time = "1分钟前";
            }
        }
        return time;
    }

    public static final String getTimeCeilClient(Date postDate, int limitDay) {
        if (postDate == null) {
            return null;
        }
        String time = null;
        long todayTime = System.currentTimeMillis();
        long curTime = postDate.getTime();
        long diffTime = curTime + limitDay * 24 * 60 * 60 * 1000 - todayTime;

        long hours = diffTime / (60 * 60 * 1000);
        if (hours > 96) {
            time = ((hours + 23) / 24) + "天内";
        } else if (hours >= 72) {
            time = "4天内";
        } else if (hours >= 48) {
            time = "3天内";
        } else if (hours >= 24) {
            time = "2天内";
        } else if (hours / 24 >= 1) {
            time = hours / 24 + "天内";
        } else if (hours >= 1) {
            time = hours + "小时内";
        } else {
            long minutes = diffTime / (60 * 1000);
            if (minutes > 1) {
                time = minutes + "分钟内";
            } else {
                time = "1分钟内";
            }
        }
        return time;
    }

    /**
     * 判断时间是否大于或者小于今天，精确到天
     * 
     * @param date
     * @return
     */
    public static boolean isLargeToday(Date date) {

        Calendar toDay = Calendar.getInstance();
        Calendar deDay = Calendar.getInstance();
        deDay.setTime(date);
        if (deDay.get(Calendar.YEAR) <= toDay.get(Calendar.YEAR) && deDay.get(Calendar.MONTH) <= toDay.get(Calendar.MONTH) && deDay.get(Calendar.DATE) <= toDay.get(Calendar.DATE)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
    	System.out.println(System.currentTimeMillis());
    	DEFAULT_SHORT_DATE_FORMATER.format("1397740948");
    	System.out.println(dateToTime(getMonthFirstDay(0)));
    	System.out.println(dateToTime(getMonthLastDay(0)));
//    	System.out.println(dateToTime(d));
    	
    }
	
}
