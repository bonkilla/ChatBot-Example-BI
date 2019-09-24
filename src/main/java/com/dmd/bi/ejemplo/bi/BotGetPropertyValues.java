package com.dmd.bi.ejemplo.bi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BotGetPropertyValues {

	String result = "";
	InputStream inputStream;
 
	private Map<String, String> caches;
	
	private static BotGetPropertyValues instance;
	//private DbInfo mysql;
	
	private BotGetPropertyValues(){
		this.caches=new HashMap<String, String>();
	}
	
	public static BotGetPropertyValues getInstance(){
		if(instance ==null){
			instance = new BotGetPropertyValues();
		}
		return instance;
	}
	
	public String getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
 
			// get the property value and print it out
			String botid = prop.getProperty("botid");
			
 
			result = "BodId = " + botid;			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
	
	public String getPropValues(String key) throws IOException {
		 
		try {
			String ret;
			ret=caches.get(key);
			if(ret!=null){
				return ret;
			}
			else{
				Properties prop = new Properties();
				String propFileName = "config.properties";
 
				inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
				if (inputStream != null) {
					prop.load(inputStream);
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
 
				// get the property value and print it out
				caches.put(key,prop.getProperty(key));
				return prop.getProperty(key);
			}			 
		} catch (Exception e) {
			System.out.println("Exception no me jodas: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
	
}