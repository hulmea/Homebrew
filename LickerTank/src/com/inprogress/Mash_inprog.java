package com.inprogress;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



import com.install.PropValues;
import com.relay.DynamicRelayContolRaspberryPI;


public class Mash_inprog {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
			
			//Take the time set
			int runtime = Integer.parseInt(args[0]);
			//get the tmep
			double tempset = Double.parseDouble(args[1]);
			//Get the temp sensor id
			String[] Allserieals = PropValues.getPropValues();
			String Therm2Serial = Allserieals[2];
			
			
			
			
			System.out.println(runtime +" Mintues");
			
			
			//Find the current time
			// Set the date 24 hours format
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			
			
			
			Calendar now = Calendar.getInstance();
			
			System.out.println("The current time is "+df.format(now.getTime()));
							
			Calendar enddate = now;
			enddate.add(Calendar.MINUTE, runtime);
			
			
			System.out.println("The boil will end "+df.format(enddate.getTime()));
			
			System.out.println("The water target temp is: "+tempset);
			
				while ( Calendar.getInstance().before(enddate))
				
				
				
				///The timed section.  This will run until the current time is more than the end time.
				{
					
					
					
					
					double maxtemp = tempset;
					double  livetemp = TempReadTemp.temp(Therm2Serial);
					System.out.println("Water temp is "+livetemp);
					
					
						if  (livetemp < maxtemp)
						
							{
								
								
							
							
							//Turn Relay On
							//RelayOnOffRaspberryPI.turnon30();
							DynamicRelayContolRaspberryPI.turnonforXtime(livetemp,maxtemp);
							livetemp = TempReadTemp.temp(Therm2Serial);
							
							
							
							}
							else {
								
								//Sleep for 10 seconds as we are at the correct temp
								
								System.out.println("Current temp is over target temp, sleeping for 10 seconds and will check again");
								Thread.sleep(10000); 
								
							}
					
					
				}
				
				System.out.println("End of boil");
            
			
			
			
		}
		
		
		
		

	}


