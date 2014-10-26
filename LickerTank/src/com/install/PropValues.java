package com.install;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropValues {
	 
public static String[] getPropValues() throws IOException {
 

Properties prop = new Properties();
String propFileName = "properties.txt";
 
InputStream inputStream = new FileInputStream(propFileName);

prop.load(inputStream);


// get the property value and print it out
String TempProbe1 = prop.getProperty("TempProbe1");
String TempProbe2 = prop.getProperty("TempProbe2");
String TempProbe3 = prop.getProperty("TempProbe3");

 //get the full list and add to a result set.

	if (TempProbe1.equals("serialnumber")){
		String[] Config = {"Add you serial number to the config file"};
			return Config;		
			
		}

	else{
	
		String[] Config = {TempProbe1,TempProbe2,TempProbe3};
		
		//Testing Print to screen
		//System.out.println(result);
		
		return Config;
}

}
}