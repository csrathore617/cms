package com.pytosoft.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum DatePattern
{
	INDIAN_SHORT("dd-MM-yyyy"), INDIAN_DATE_TIME("dd-MM-yyyy HH:mm"), INDIAN_DATE_TIME_LONG_MONTH(
			"dd MMMM yyyy, hh:mm a"), ONLY_TIME("hh:mm a"), ONLY_TIME_WITHOUT_AM_PM("hh:mm:ss"),ONLY_TIME_IN_24_HOURS_FORMAT("HH:mm:ss");

	private String pattern;

	private DatePattern(String pattern)
	{
		this.pattern = pattern;
	}

	public String getPattern()
	{
		return pattern;
	}

	public String format(Date date)
	{
		DateFormat dateFormat = new SimpleDateFormat(this.pattern);
		return dateFormat.format(date);
	}
}
