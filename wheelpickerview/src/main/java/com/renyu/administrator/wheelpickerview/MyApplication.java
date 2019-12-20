package com.renyu.administrator.wheelpickerview;
import android.app.Application;


/**
 * 作者：renyu
 * 注释：
 */
public class MyApplication extends Application {
    private static MyApplication mInstances;
//    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstances = this;
    }


    public static MyApplication getInstances() {
        return mInstances;
    }

}