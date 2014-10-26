/// Write to CSV and to screen the temp and date every 5 seonds.  use the Argument for what probe as set inthe config file.
/// To run this user the argument of what probe you are using.
///Example : sudo java -jar Mtempt1.jar 1  This will use the serial number found  in the properties.txt file for the temp probe 1. Run the installer jar if this has not been created.

package com.inprogress;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.install.PropValues;
import com.relay.*;
import com.tempprobes.TempReadTemp1;

import au.com.bytecode.opencsv.CSVWriter;

public class MonitorTempProbe {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		int Probe1to3 = Integer.parseInt(args[0])-1;
		
		
		String[] Allserieals = PropValues.getPropValues();
		String Therm2Serial = Allserieals[Probe1to3];
		
		while (true){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		double temp = TempReadTemp.temp(Therm2Serial);
		String tempexport = Double.toString(temp);
		
		System.out.println(temp + "C "+df.format(date));
		
		FileWriter pw = new FileWriter("data.csv",true); 
		CSVWriter writer = new CSVWriter(pw);
		
		String [] temps = {tempexport,  df.format(date)};
			
		writer.writeNext(temps); 
		writer.close();
		TimeUnit.SECONDS.sleep(5);
		
		}

	}

}
