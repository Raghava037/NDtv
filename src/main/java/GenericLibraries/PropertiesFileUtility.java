package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility 
{
	private Properties property;
	
	public void propertiesFileInitialization(String filepath)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String featchproperties(String key)
	{
		return property.getProperty(key);
	}
}
