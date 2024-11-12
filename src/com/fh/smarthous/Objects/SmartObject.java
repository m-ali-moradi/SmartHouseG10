package com.fh.smarthous.Objects;

public abstract class SmartObject {
	
	   protected String id;
	    protected double powerConsumption;
	    protected boolean isOn;

	    public SmartObject(String id, double powerConsumption) {
	        this.id = id;
	        this.powerConsumption = powerConsumption;
	        this.isOn = false;
	    }

	    public abstract void turnOn();
	    public abstract void turnOff();
	    public double getConsumption() {
	        return isOn ? powerConsumption : 0;
	    }

	    public String getId() {
	        return id;
	    }

}
