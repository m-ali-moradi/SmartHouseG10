package com.fh.smarthouse.energy;

public class DieselGenerator implements EnergySource{
    private final double powerOutput;

    public DieselGenerator(double powerOutput) {
        this.powerOutput = powerOutput;
    }

    @Override
    public double getCapacity() {
        return powerOutput;
    }

    @Override
    public String getSourceName() {
        return "Diesel Generator (DG)";
    }
}
