package Monitoring;

import java.util.Random;

public class DummyTempData {
	
	
	public static double Dummytemp() {
		
		
	
	
	Random rand = new Random();
	int randomNum = rand.nextInt((100 - 0) + 1) + 0;
	
	return randomNum;

}
}