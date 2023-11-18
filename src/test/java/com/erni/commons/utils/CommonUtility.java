package com.erni.commons.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * Common utilities
 * 
 * @author faju
 *
 */
public class CommonUtility {
	
	
	/**
	 * Load configurations stored in Properties file
	 * 
	 * @return props configurations for the test executions
	 * @throws IOException
	 */
	public static Properties loadProperties() throws IOException
	{
		FileReader reader=new FileReader("src/test/resources/config.properties");
        Properties props=new Properties();
        props.load(reader);
        
        return props;
	}

}
