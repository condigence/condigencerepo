package com.condigence.medicare.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	private static final String DATE_FORMAT = "yyyy/MM/dd hh:mm";

	public static void main(String[] args) throws ParseException {
		String dateStr = "2017/12/04 22:00";

		// java.util.Date uDate = new java.util.Date();
		// convertDateToStr(uDate);

		// convertStrToDate(dateStr);

		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		Date date = (Date) formatter.parse(dateStr);
		Timestamp t2 = getTimestamp(date);
		String S = new SimpleDateFormat(DATE_FORMAT).format(t2);
		System.out.println("timestamp2: " + S);

	}

	public static String convertDateToStr(Date uDate) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(uDate);
	}

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

	public static Timestamp getTimestamp(Date date) {
		return date == null ? null : new java.sql.Timestamp(date.getTime());
	}

}
