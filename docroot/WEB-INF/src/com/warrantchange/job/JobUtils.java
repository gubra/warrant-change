package com.warrantchange.job;

import java.util.Calendar;
import java.util.Date;

public class JobUtils {

	public static Date createDate(int daysAgo) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, -daysAgo);
		return cal.getTime();
	}

}
