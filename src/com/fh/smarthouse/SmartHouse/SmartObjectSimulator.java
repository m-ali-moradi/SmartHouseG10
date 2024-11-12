package com.fh.smarthouse.SmartHouse;

import com.fh.smarthouse.energy.CityPower;
import com.fh.smarthouse.energy.DieselGenerator;
import com.fh.smarthouse.energy.EnergySource;
import com.fh.smarthouse.management.EnergyManager;
import com.fh.smarthouse.energy.SolarPanel;
import com.fh.smarthouse.objects.SmartObject;

import java.util.ArrayList;
import java.util.List;

public class SmartObjectSimulator {

	public static void main(String[] args) {


		EnergySource solarPanel = new SolarPanel(500);
		EnergySource cityPower = new CityPower(1000);
		EnergySource dieselGenerator = new DieselGenerator(750);


		List<EnergySource> energySources = new ArrayList<>();
		energySources.add(solarPanel);
		energySources.add(cityPower);
		energySources.add(dieselGenerator);


		List<SmartObject> smartObjects = new ArrayList<>();


		smartObjects.add(new SmartObject("Refrigerator", 300));
		smartObjects.add(new SmartObject("Air Conditioner", 400));







		EnergyManager energyManager = new EnergyManager(energySources, smartObjects);


//		energyManager.turnOnObject("refrigerator");
		energyManager.turnOnObject("Air conditioner");
		energyManager.turnOffObject("refrigerator");


		energyManager.manageEnergy();

	}

}
