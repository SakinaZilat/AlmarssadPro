package com.marssadpro.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerNotFoundException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;
	private static String errorTemplate = "Could not find member with ID: %d";
	private Logger logger = LoggerFactory.getLogger(PlayerNotFoundException.class);
	
	public PlayerNotFoundException(Long memberId)
	{
		super(String.format(errorTemplate, memberId));
		logger.error(String.format(errorTemplate, memberId));
	}
	
	public PlayerNotFoundException(String message)
	{
		super(message);
		logger.error(message);
	}
}
