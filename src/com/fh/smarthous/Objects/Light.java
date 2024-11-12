package com.fh.smarthous.Objects;

public class Light extends SmartObject {
	
	 public Light(String id, double powerConsumption) {
	        super(id, powerConsumption);
	    }

	    @Override
	    public void turnOn() {
	        isOn = true;
	        System.out.println("Light " + id + " turned on.");
	    }

	    @Override
	    public void turnOff() {
	        isOn = false;
	        System.out.println("Light " + id + " turned off.");
	    }

}
