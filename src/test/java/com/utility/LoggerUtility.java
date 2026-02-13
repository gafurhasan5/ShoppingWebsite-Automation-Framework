package com.utility;

import org.apache.logging.log4j.*;


public  class LoggerUtility {
	private static Logger logger;

	public  LoggerUtility() {

	}
	public static Logger getLogger(Class<?>clazz)
	{
		if(logger==null)
	    {logger=LogManager.getLogger(clazz);}
		return logger;
	}
}
