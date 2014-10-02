/////////  Run Via sudo java -jar RelayOnForXtime1.jar watertemp set test
///// i.e. sudo java -jar RelayOnForXtime1.jar 20 41

package testing;
import com.relay.*;

public class RaplyonforXtime {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		String Watertemp =  (args[0]);
		String Settempt = (args[1]);
		
	
		long waterlong = Long.parseLong(Watertemp);
		long Setlong = Long.parseLong(Settempt);
		
		DynamicRelayContolRaspberryPI.turnonforXtime(waterlong,Setlong);
				
		
		
		

	}

}
