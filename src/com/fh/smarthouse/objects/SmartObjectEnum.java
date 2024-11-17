package com.fh.smarthouse.objects;

public enum SmartObjectEnum {

	Fridge("Refrigerator", 300, false), AC("Air Conditioner", 450, false), TV("Television", 500, false),
	Lamp("Lamp", 200, false);

	public String name;

	public Integer power;

	public Boolean state;

	SmartObjectEnum(String name, Integer power, Boolean state) {
		this.name = name;
		this.power = power;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}
