package com.ven.ctci.chapter7.oodesign.parkinglot.model;

public abstract class Vehicle {
	private final String registrationNumber;
	private final Color color;
	private final VehicleType type;
	
	public Vehicle(String registrationNumber, Color color, VehicleType type) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public Color getColor() {
		return color;
	}

	public VehicleType getType() {
		return type;
	}
	
	

}
