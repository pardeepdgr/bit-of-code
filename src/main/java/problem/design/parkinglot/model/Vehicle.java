package problem.design.parkinglot.model;

import problem.design.parkinglot.type.VehicleType;

public class Vehicle {
	private String registrationNumber;
	private VehicleType type;

	public Vehicle(String registrationNumber, VehicleType type) {
		this.registrationNumber = registrationNumber;
		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public VehicleType getVehicleType() {
		return type;
	}
}