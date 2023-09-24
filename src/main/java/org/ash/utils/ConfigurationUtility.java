package org.ash.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.ash.enums.ConfigurationEnum;
import org.ash.frameworkconstants.FrameworkConstants;

import com.ash.exceptions.ConfiguragtionFileUsageException;
public final class  ConfigurationUtility {

	public ConfigurationUtility()
	{

	}

	private  static Properties properties= new Properties();
	private static Map<String,String> configurationMap = new HashMap<String,String>();
	static 
	{
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigurationFilePath())) {
			properties.load(fis);
			for(Map.Entry<Object,Object> entry:properties.entrySet())
			{
				configurationMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static String getValue(ConfigurationEnum key)
	{
		if(Objects.isNull(key) || Objects.isNull(configurationMap.get(key.name().toLowerCase())))
			throw new ConfiguragtionFileUsageException("value for "+key+" is not found");
		return configurationMap.get(key.name().toLowerCase());
	}
}
