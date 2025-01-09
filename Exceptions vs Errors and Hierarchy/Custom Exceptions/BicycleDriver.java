// package com.exceptions.bicycle;

import java.io.IOException;

public class BicycleDriver {
	
	public static void main(String[] args) {
		
		System.out.println("This is the start of our program...");
		System.out.println("Stufffff......");
		
		try {
			Thread.sleep(1000);
//			throw new InterruptedException();	// we can throw exceptions ourselves
//			throw new OutOfMemoryError();		// we can also throw errors (but why?)
//			System.exit(0);	 // this will halt the app, nothing past this line will be executed
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			// will almost always be executed
			System.out.println("This is in the finally block!"); 
		}
		
		System.out.println("This is after the try/catch/finally blocks.");
		
		// Order of catch blocks matters! Catch exceptions starting with the most specific!
//		try {
//			throwSomething();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		Bicycle myBike = new Bicycle();
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(24);
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(2);
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		try {
			myBike.slowDown(26);
		} catch (NegativeSpeedException e) {
			myBike.speed = 0;
			myBike.gear = 1;
			e.printStackTrace();
		}
		System.out.println("gear: " + myBike.gear + ", speed:" + myBike.speed);
		
	}
	
	// Include a throws clause on a method's signature to force any calling method to handle it.
	// Also known as throwing or propagating.
	public static void throwSomething() throws IOException {
		System.out.println("This method might throw an exception");
	}
    
}