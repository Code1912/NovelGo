package com.code1912.novelgo.util;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Code1912 on 2016/12/18.
 */

public class Util {
	public static String getStrTime(long cc_time, String format) {
		String re_StrTime;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// eg：cc_time=1291778220
		re_StrTime = sdf.format(new Date(cc_time * 1000L));
		return re_StrTime;
	}
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

}
