package com.renyu.administrator.wheelpickerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

import com.renyu.administrator.lib.MyClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者：renyu
 * 注释：日期选择器
 */
public class DatePicker extends WheelPicker<String> {

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DatePicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置日期
     */
    public void setDate(long endTime) {
        long currentMillis = System.currentTimeMillis();
        int listSize = MyTimeUtils.getTimeDifference(currentMillis, endTime);
        List<String> data = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
        Date d1 = new Date();
        for (int i = 0; i < listSize; i++) {
            d1.setTime(currentMillis + i * 24 * 60 * 60 * 1000L);
            data.add(format.format(d1));
        }
        setDataList(data);
    }

    /**
     * 设置小时
     */
    public void setHour() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            data.add(String.valueOf(i));
        }
        setDataList(data);
    }


    /**
     * 设置分钟
     */
    public void setMinute() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            data.add(String.valueOf(i));
        }
        setDataList(data);
    }

    /**
     * 设置提醒时间
     */
    public void setReminder() {
        List<String> data = new ArrayList<>();
        data.add("不提醒");
        data.add("5分钟");
        data.add("10分钟");
        data.add("15分钟");
        data.add("30分钟");
        data.add("1小时");
        data.add("1天");
        data.add("2天");
        data.add("1周");
        setDataList(data);
    }

    /**
     * 设置重复频率
     */
    public void setFrequency() {
        String a = MyClass.a;
        List<String> data = new ArrayList<>();
        data.add("无");
        data.add("天");
        data.add("周");
        data.add("月");
        setDataList(data);
    }

    /**
     * 设置重复日期
     */
    public void setRepeatDate(int frequency) {
        List<String> data = new ArrayList<>();
        switch (frequency) {
            case 0:
                data.add("无");
                break;
            case 1:
                for (int i = 1; i <= 10; i++) {
                    data.add( i + "天");
                }
                break;
            case 2:
                for (int i = 1; i <= 10; i++) {
                    data.add( i + "周");
                }
                break;
            case 3:
                for (int i = 1; i <= 10; i++) {
                    data.add( i + "月");
                }
                break;
        }
        setDataList(data);
    }
}
