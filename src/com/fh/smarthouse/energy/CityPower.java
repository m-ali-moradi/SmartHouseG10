package com.fh.smarthouse.energy;

public class CityPower implements EnergySource {
    private final double powerLimit;
    public CityPower(double powerLimit) {
        this.powerLimit = powerLimit;
    }

    @Override
    public double getCapacity() {
        return powerLimit;
    }

    @Override
    public String getSourceName() {
        return "City Power";
    }
}
