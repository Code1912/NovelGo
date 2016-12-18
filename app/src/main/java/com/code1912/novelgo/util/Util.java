package com.code1912.novelgo.util;

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
}
