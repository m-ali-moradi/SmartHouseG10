package com.fh.smarthouse.management;
import java.util.List;
import com.fh.smarthouse.objects.SmartObject;
import com.fh.smarthouse.energy.EnergySource;


public class EnergyManager {
	private final List<SmartObject> smartObjects;
    private final List<EnergySource> energySources;
    private EnergySource activeSource;

    public EnergyManager(List<EnergySource> energySources, List<SmartObject> smartObjects) {
        //TODO try catch block 
    	if (energySources == null || energySources.isEmpty()) {
            throw new IllegalArgumentException("Energy sources list cannot be null or empty!");
        }
        this.smartObjects = smartObjects;
        this.energySources = energySources;
        this.activeSource = energySources.getFirst();
    }

    private SmartObject findSmartObject(String objectName) {
        return smartObjects.stream()
                .filter(obj -> obj.getName().equalsIgnoreCase(objectName))
                .findFirst()
                .orElse(null);
    }

    public EnergySource getActiveSource() {
        return activeSource;
    }

    // here switch the power sourece
    public void switchToBackup() {
        for (EnergySource source : energySources) {
            if (!source.equals(activeSource)) {
                activeSource = source;
                System.out.println("Switched to backup source: " + activeSource.getSourceName());
                return;
            }
        }
        System.err.println("Error: No backup sources available!");
        activeSource = null; // Mark as no source available
    }

    private double calculateTotalConsumption() {
//        System.out.println("Calculating total consumption:");
//        smartObjects.forEach(obj ->
//                System.out.println(obj.getName() + " - " + obj.getConsumption() + " W (isOn: " + obj.isOn() + ")")
//        );

        return smartObjects.stream()
                .mapToDouble(SmartObject::getConsumption)
                .sum();
    }


    public void manageEnergy() {
        if (activeSource == null) {
            System.err.println("Error: No active energy source available!");
            return;
        }

        double totalConsumption = calculateTotalConsumption();
        double maxCapacity = activeSource.getCapacity();

        System.out.println("Active Energy Source: " + activeSource.getSourceName());
        System.out.println("Total Energy Consumption: " + totalConsumption + " W");
        System.out.println("Max Capacity of Active Source: " + maxCapacity + " W");

        if (totalConsumption > maxCapacity) {
            System.out.println("WARNING: Total energy consumption exceeds the capacity of the active source!");
            switchToBackup();
            manageEnergy(); // Recursive call
        } else if (totalConsumption >= 0.9 * maxCapacity) {
            System.out.println("WARNING: Total energy consumption is nearing the maximum capacity of the active source!");
        } else {
            System.out.println("Energy supply is sufficient.");
        }
    }

    public void turnOnObject(String objectName) {
        SmartObject obj = findSmartObject(objectName);
        if (obj != null) {
            obj.turnOn();
            System.out.println(objectName + " is turned on, consuming "+obj.getConsumption() + "W");
        } else {
            System.out.println("Smart object not found: " + objectName);
        }
    }

    public void turnOffObject(String objectName) {
        SmartObject obj = findSmartObject(objectName);
        if (obj != null) {
            obj.turnOff();
            System.out.println(objectName + " is turned off!");
        } else {
            System.out.println("Smart object not found: " + objectName);
        }
    }
}
