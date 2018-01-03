package com.marssadpro.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;
	private static String errorTemplate = "Date format: %s" + " is invalid. Please use: %s";
	private Logger logger = LoggerFactory.getLogger(DateFormatException.class);
	
	public DateFormatException(String dateValue, String dateFormat)
	{
		super(String.format(errorTemplate, dateValue, dateFormat));
		logger.error(String.format(errorTemplate, dateValue, dateFormat));
	}
}
