package com.ash.exceptions;

public class ConfiguragtionFileUsageException extends FrameworkException{
// custom exception 
	public ConfiguragtionFileUsageException(String message)
	{
		super(message);
	}
	public ConfiguragtionFileUsageException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
