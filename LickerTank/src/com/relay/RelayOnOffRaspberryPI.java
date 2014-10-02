package com.relay;




import java.util.concurrent.TimeUnit;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class RelayOnOffRaspberryPI {

	
	/// Turn on pin
	public static void turnon() throws InterruptedException{
		
		System.out.println("<--Pi4J--> GPIO Control Example ... started.");
		
		// create gpio controller
        final GpioController gpio = GpioFactory.getInstance();
        
        // provision gpio pin #02 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.HIGH);
        System.out.println("--> GPIO 02 state should be: ON");
        gpio.unprovisionPin(pin);
        gpio.shutdown();
        
	

	}
	///Turn on for 30 seconds then off
public static void turnon30() throws InterruptedException{
		
		//System.out.println("<--Pi4J--> GPIO Control Example ... started.");
		
		// create gpio controller
        final GpioController gpio = GpioFactory.getInstance();
        
        // provision gpio pin #02 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.HIGH);
        System.out.println("--> GPIO state should be: ON for 30 seconds");
        TimeUnit.SECONDS.sleep(30);
        pin.toggle();
        System.out.println("--> GPIO 02 state now should be: OFF");
        gpio.unprovisionPin(pin);
        gpio.shutdown();
}
        
	///Turn off pin
public static void turnoff() throws InterruptedException{
		
		System.out.println("<--Pi4J--> GPIO Control Example ... started.");
		
		// create gpio controller
        final GpioController gpio = GpioFactory.getInstance();
        
        // provision gpio pin #02 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);
        System.out.println("--> GPIO 02 state should be: OFF");
        
        gpio.shutdown();
        

}
}
