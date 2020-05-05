package problem.design.parkinglot.model;

import problem.design.parkinglot.model.Vehicle;

public class Slot {
	private int slotNumber;
	private boolean isAvailable;
	private Vehicle vehicle;

	public Slot(int slotNumber, boolean isAvailable) {
		this.slotNumber = slotNumber;
		this.isAvailable = isAvailable;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

}
