package com.fh.smarthouse.SmartHouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.fh.smarthouse.energy.CityPower;
import com.fh.smarthouse.energy.DieselGenerator;
import com.fh.smarthouse.energy.EnergySource;
import com.fh.smarthouse.energy.SolarPanel;
import com.fh.smarthouse.management.EnergyManager;
import com.fh.smarthouse.objects.SmartObject;
import com.fh.smarthouse.objects.SmartObjectEnum;

public class SmartObjectSimulator {
	public static final Logger logger = Logger.getLogger(SmartObjectSimulator.class.getName());

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		logger.info("Welcome to the Smart House Management System!");
		logger.info("Please enter your name: ");
		String name = scanner.nextLine();

		logger.info("Hello " + name + "!\n----Main menu----\n");
		logger.info("1. Energy sources\n2.Smart Objects\n");
		Integer choice = scanner.nextInt();
		List<EnergySource> energySources = new ArrayList<>();
		List<SmartObject> smartObjects = new ArrayList<>();

		switch (choice) {
		case 1:
			energySources = getEnergySources(scanner);
//			break;
		case 2:
			smartObjects = getSmartObjects(scanner);
		default:
			logger.warning("Invalid input. Please enter a valid number (0/1)");
		}

		EnergyManager energyManager = new EnergyManager(energySources, smartObjects);

		energyManager.turnOnObject("refrigerator");
//		energyManager.turnOnObject("Air conditioner");
//		energyManager.turnOffObject("refrigerator");

		energyManager.manageEnergy();

		scanner.close();
	}

	private static List<SmartObject> getSmartObjects(Scanner scanner) {
		List<SmartObject> smartObjects = new ArrayList<>();

		logger.info("Please choose from the following smart object(s):");

		logger.info("1. Refrigerator\n2.Air Conditioner\n3.Television\n4.Lamp\n0.Back\nQ.Quit\n");

		String smartObjectStr = "";
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			smartObjectStr = sc.nextLine();
		} else {
			logger.warning("No input was entered.");
		}
		String[] smartObjectArr = smartObjectStr.split(",");

		for (String smartObject : smartObjectArr) {
			switch (smartObject) {
			case "1":
				smartObjects.add(new SmartObject(SmartObjectEnum.Fridge.getName(), SmartObjectEnum.Fridge.getPower()));
				modifyState(smartObjects);
				break;
			case "2":
				smartObjects.add(new SmartObject(SmartObjectEnum.AC.getName(), SmartObjectEnum.AC.getPower()));
				modifyState(smartObjects);
				break;
			case "3":
				smartObjects.add(new SmartObject(SmartObjectEnum.TV.getName(), SmartObjectEnum.TV.getPower()));
				modifyState(smartObjects);
				break;
			case "4":
				smartObjects.add(new SmartObject(SmartObjectEnum.Lamp.getName(), SmartObjectEnum.Lamp.getPower()));
				modifyState(smartObjects);
				break;
			case "Q":
				logger.warning("Exiting the system...");
				System.exit(0);
			default:
				logger.warning("Unexpected value. Please enter a valid number");
				sc.close();
				System.exit(0);
			}
			sc.close();
		}
		return smartObjects;
	}

	private static void modifyState(List<SmartObject> smartObjects) {
		for (SmartObject smartObj : smartObjects) {
			smartObj.turnOn();
			logger.info("The " + smartObj.getName() + " is turned " + smartObj.isOn() != null && smartObj.isOn() ? "On"
					: "Off");
		}
	}

	private static List<EnergySource> getEnergySources(Scanner scanner) {
		logger.info("Please choose from the following energy source(s):");
		logger.info("1. Solar energy\n2.City Power\n3.Diesel Generator\n4.Main Menu");
		Scanner sc = new Scanner(System.in);
		String energySourceStr = sc.nextLine();
		String[] energySourcesArr = energySourceStr.split(",");
		EnergySource solarPanel = new SolarPanel(500);
		EnergySource cityPower = new CityPower(1000);
		EnergySource dieselGenerator = new DieselGenerator(750);
		List<EnergySource> energySources = new ArrayList<>();

		for (String energySource : energySourcesArr) {
			switch (energySource) {
			case "1":
				energySources.add(solarPanel);
				break;
			case "2":
				energySources.add(cityPower);
				break;
			case "3":
				energySources.add(dieselGenerator);
				break;
			default:
				logger.info("energySource--->" + energySource);
				logger.warning("Unexpected value. Please enter a valid number");
				scanner.close();
				System.exit(0);
			}
			sc.close();
		}

		return energySources;
	}

}
