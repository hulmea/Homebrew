package testing;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.relay.RelayOnOffRaspberryPI;
import com.relay.TempRead;

public class CopyOfTurnOn_backup {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		for (String s: args) {
			
			//Take the time set
			int runtime = Integer.parseInt(s);
			System.out.println(runtime +" Mintues");
			
			
			//Find the current time
			// Set the date 24 hours format
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			
			
			
			Calendar now = Calendar.getInstance();
			
			System.out.println("The current time is "+df.format(now.getTime()));
							
			Calendar enddate = now;
			enddate.add(Calendar.MINUTE, runtime);
			
			
			System.out.println("The boil will end "+df.format(enddate.getTime()));
			
				while ( Calendar.getInstance().before(enddate));
				
				
				
				///The timed section.  This will run until the current time is more than the end time.
				{
					
					
					
					
					double maxtemp = 70;
					double  livetemp = TempRead.temp();
					
						if  (livetemp < maxtemp)
						
							{
								
								
							System.out.println(livetemp);
							
							//Turn Relay On
							RelayOnOffRaspberryPI.turnon();
							Thread.sleep(10000); 
							
							//Turn replay off
							RelayOnOffRaspberryPI.turnoff();
							
							}
							else {
								
								//Sleep for 10 seconds as we are at the correct temp
								
								Thread.sleep(10000); 
								
							}
					
					
				}
				
				System.out.println("End of boil");
            
			
			
			
		}
		
		
		
		

	}

}
