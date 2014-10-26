package Monitoring;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;



import au.com.bytecode.opencsv.CSVWriter;

public class MonitorUsingDummyData {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		while (true){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		
		
		double temp = TempReadTemp1.temp();
		String tempexport = Double.toString(temp);
		
		
		System.out.println(temp + "C "+df.format(date));
		
		FileWriter pw = new FileWriter("/home/pi/Homebre/tempdata.csv",true); 
		CSVWriter writer = new CSVWriter(pw);
		
		String [] temps = {tempexport,  df.format(date)};
			
		writer.writeNext(temps); 
		writer.close();
		TimeUnit.SECONDS.sleep(5);
		
		}

	}

}
