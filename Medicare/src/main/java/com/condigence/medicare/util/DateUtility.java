package com.condigence.medicare.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	private static final String DATE_FORMAT = "yyyy/MM/dd hh:mm";

	public static void main(String[] args) throws ParseException {
		String dateStr = "2017/12/06 04:00";

		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		Date date = formatter.parse(dateStr);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String yourDate = sdf.format(date);
		//System.out.println(yourDate);

	}
	
	
	

}
