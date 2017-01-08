package com.code1912.novelgo.util;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	public static <T> T deepClone(T object) {
		String str = JSON.toJSONString(object);
		return JSON.parseObject(str, (Class<T>) object.getClass());
	}

	public static <T> List<T> deepCloneArray(List<T> object)  {
		String str = JSON.toJSONString(object);

		return JSON.parseArray(str,(Class<T>)object.get(0).getClass());
	}

	public static boolean isNullOrEmpty(String str) {
		if (str == null) {
			return true;
		}
		return str.isEmpty();
	}
}
