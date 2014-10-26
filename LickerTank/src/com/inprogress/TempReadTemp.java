package com.inprogress;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TempReadTemp {
	
	
	///Methods
	
public static String readFile(String path, Charset encoding) 
				  throws IOException 
					  {
					    byte[] encoded = Files.readAllBytes(Paths.get(path));
					    return encoding.decode(ByteBuffer.wrap(encoded)).toString();
					  }
		

public static double temp(String serial) throws IOException{
	
		
		String allfile = TempReadTemp.readFile("/sys/bus/w1/devices/"+serial+"/w1_slave", StandardCharsets.UTF_8);
		String[] lnallfile  = allfile.split("\n");
		String line2 = lnallfile[1];
		String temperaturedata = line2.split(" ")[9] ;
		temperaturedata = temperaturedata.substring(2);
		double temperaturedataInt = Double.parseDouble(temperaturedata);
		temperaturedataInt = temperaturedataInt /1000;
		
		return temperaturedataInt;
	}
			

public static void StringWrite (String tempnumber) {
				try {
		 
						//String content = "This is the content to write into file";
			 
						File file = new File("/home/pi/TempRecord");
			 
						// if file doesnt exists, then create it
						if (!file.exists()) {
							file.createNewFile();
					}
					
					//Write temp and date to file with Line feed.  The true will append to the text file.
					FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(tempnumber);
					bw.write(",");
					//Add date to the temp reading.
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					bw.write(sdf.format(date));
					//add line feed
					bw.write("\r\n");
					bw.close();
		 
					//System.out.println("Done");
		 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

}
