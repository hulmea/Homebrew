package com.relay;




import java.util.concurrent.TimeUnit;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class DynamicRelayContolRaspberryPI {

	      
	

	
	///Turn on for 30 seconds then off
public static void turnonforXtime(double watertempt, double settemp) throws InterruptedException{
		
		//System.out.println("<--Pi4J--> GPIO Control Example ... started.");
		// Find the temp diffrence
	
		double tempdiff = settemp-watertempt;
		System.out.println("The current water temp is "+watertempt+"C The Desired temp is "+settemp+"C The temp diffrence is " + tempdiff+"C" );
		
		long temptime = TimeRelayon(tempdiff);
	
	
		// create gpio controller
        final GpioController gpio = GpioFactory.getInstance();
        
        // provision gpio pin #02 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.HIGH);
        System.out.println("--> GPIO state should be: ON for " +temptime+" seconds");
        TimeUnit.SECONDS.sleep(temptime);
        pin.toggle();
        System.out.println("--> GPIO 02 state now should be: OFF");
        gpio.unprovisionPin(pin);
        gpio.shutdown();
}
        
public static long TimeRelayon(double tdiff) {
	
		
	//convert double to int.
	
	int tdiffint = (int) tdiff;
	//System.out.println("Debuging "+tdiffint);
	
	//Set the time for the heater to be on per cycle depending on the temp difference
	
	if (tdiffint > 50){
		return 100;}
	else if (tdiffint > 40){
		return 90;	}
	else if (tdiffint > 30 ){ 
		return 85;	}
	else if (tdiffint > 20 ) {
		return 60;}
	else if (tdiffint > 10 ){
		return 40;}
	else if (tdiffint > 5 ){
		return 30;}
	else if (tdiffint > 2 ){
		return 10;}
	return 30;
	

}

}
