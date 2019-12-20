package com.renyu.administrator.wheelpickerview;

import android.content.Context;

/**
 * 作者：renyu
 * 注释：
 */
public class SpPxUtils {

    /**
     * +0.5f 是为了强制转换的时候 四舍五入
     * @param sp
     * @return
     */
    public static int sp2Px( float sp) {
        return (int) (sp * MyApplication.getInstances().getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }

   public static int px2Sp(float px){
       return (int) (px /MyApplication.getInstances().getResources().getDisplayMetrics().scaledDensity + 0.5f);
   }

    /**
     * 返回 dp和px 转换参数
     * @param context
     * @return
     */
   public static float getDensity(Context context){
       return context.getResources().getDisplayMetrics().density;
   }


}
