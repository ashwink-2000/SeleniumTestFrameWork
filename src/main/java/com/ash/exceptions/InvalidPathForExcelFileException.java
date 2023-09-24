package com.ash.exceptions;


public class InvalidPathForExcelFileException  extends FrameworkException{

	public InvalidPathForExcelFileException(String message)
	{
		super(message);
	}
	
	public InvalidPathForExcelFileException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
