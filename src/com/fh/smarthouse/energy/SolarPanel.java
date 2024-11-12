package com.fh.smarthouse.energy;

public class SolarPanel implements EnergySource {

	private double maxOutput;

	public SolarPanel(double maxOutput) {
		super();
		this.maxOutput = maxOutput;
	}

	@Override
	public double generateEnergy() {
		return maxOutput * Math.random();
	}

	@Override
	public double getMaxCapacity() {
		return maxOutput;
	}

}
