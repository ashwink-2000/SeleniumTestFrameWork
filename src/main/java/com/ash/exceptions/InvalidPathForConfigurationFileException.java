package com.ash.exceptions;


public class InvalidPathForConfigurationFileException  extends FrameworkException{

	public InvalidPathForConfigurationFileException(String message)
	{
		super(message);
	}
	
	public InvalidPathForConfigurationFileException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
