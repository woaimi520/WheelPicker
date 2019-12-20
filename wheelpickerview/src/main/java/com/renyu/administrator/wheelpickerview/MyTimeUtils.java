package com.renyu.administrator.wheelpickerview;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 作者：renyu
 * 注释：
 */
public class MyTimeUtils {

    /**
     * @return 1998年12月12日
     */
    public static String getDayTypeOne(){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
        return format.format(date);
    }

    /**
     * @return  1998年12月
     */
    public static String getDayTypeWwo(){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy 年 MM 月");
        return format.format(date);
    }
    public static String getDayTypeWwo( Long time){
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy 年 MM 月");
        return format.format(date);
    }

    /**
     * @return 20
     */
    public static String getDayTypeThree(){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("dd");
        return format.format(date);
    }
    public static String getDayTypeThree(Long time){
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("dd");
        return format.format(date);
    }


    /**
     * @return 星期几
     */
    public static String getDayOfTheWeek(){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        return format.format(date);
    }
    public static String getDayOfTheWeek(Long time){
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        return format.format(date);
    }


    /**
     * @return 返回上午好 下午好
     */
    public static String getDayPeriod(){
        Calendar calendar = Calendar.getInstance();
        Long time = System.currentTimeMillis();
        calendar.setTimeInMillis(time);
        String period;
        switch (calendar.get(Calendar.AM_PM)){
            case 0:
                period = "上午好";
                break;
            case 1:
                period = "下午好";
                break;
            default:
                period = "未获取";
        }
        return period;

    }


    /**
     * 获取设置天的起始的 单位毫秒
     * @return
     */
    public static Long getTodayStartTime(Calendar todayStart) {
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTimeInMillis();
    }

    /**
     * 获取设置天的结束的 单位毫秒
     * @return
     */
    public static Long getTodayEndTime(Calendar todayEnd ) {
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTimeInMillis();
    }


    /**
     * 判断是否是同一天
     * @param calendarA
     * @param calendarB
     * @return
     */
    public static boolean isSameDay(Calendar calendarA,Calendar calendarB){
        return calendarA.get(Calendar.YEAR) == calendarB.get(Calendar.YEAR)
                && calendarA.get(Calendar.MONTH) == calendarB.get(Calendar.MONTH)
                && calendarA.get(Calendar.DAY_OF_MONTH) == calendarB
                .get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 降选取的时间封装到 calendar 方便提取毫秒数
     * @param haibinCalendar 日历选取的时间
     * @return 返回包装类 calendar
     */
    public static Calendar getUtilCalendar(com.haibin.calendarview.Calendar haibinCalendar){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(haibinCalendar.getYear(), haibinCalendar.getMonth() - 1, haibinCalendar.getDay());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.format(calendar.getTimeInMillis());
        return calendar;
    }

    /**
     * 获取毫秒值
     *
     * @param calendar 日历自定义Calendar
     * @return 毫秒值
     */
    public static long getMillisecond(com.haibin.calendarview.Calendar calendar) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(System.currentTimeMillis());
        calendar1.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 23, 59, 59);
        return calendar1.getTimeInMillis();
    }


    /**
     * 获取毫秒值
     *
     * @param dateStr 日期格式 yyyy MM dd
     * @return 毫秒值
     */
    public static long getMillisecond(String dateStr) {
        long timeMillisecond = 0;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        Date d;
        try {
            d = sdf.parse(dateStr);
            timeMillisecond = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeMillisecond;
    }

    /**
     * 获取日期
     *
     * @return 毫秒值
     */
    public static String getDateString(long millisecond) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
        Date d1 = new Date(millisecond);
        return format.format(d1);
    }

    /**
     * 获取日期
     *
     * @return 毫秒值
     */
    public static String getReminderDateString(long millisecond) {
        SimpleDateFormat format = new SimpleDateFormat("HH：mm  yyyy MM dd");
        Date d1 = new Date(millisecond);
        return format.format(d1);
    }

    /**
     * time -》 java util calendar
     * @param time 当前时间毫秒
     * @return
     */
    public static Calendar getUtilCalendar(Long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }


    /**
     * 获取时间差
     *
     * @param startMillisecond 开始时间
     * @param endMillisecond   结束时间
     * @return 天数
     */
    public static int getTimeDifference(long startMillisecond, long endMillisecond) {
        long millisecond = endMillisecond - startMillisecond;
        return (int) (millisecond / (24 * 60 * 60 * 1000)) + 1;
    }
}
