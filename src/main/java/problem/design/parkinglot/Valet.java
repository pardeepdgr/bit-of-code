package problem.design.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import problem.design.parkinglot.model.ParkingLot;
import problem.design.parkinglot.model.Slot;
import problem.design.parkinglot.model.Vehicle;
import problem.design.parkinglot.type.VehicleType;

public class Valet {

	private Map<Vehicle, Slot> occupiedSpace = new HashMap<Vehicle, Slot>();

	public boolean park(ParkingLot lot, Vehicle vehicle) {
		if (VehicleType.TWOWHEELER == vehicle.getVehicleType())
			return parkIfSlotAvailable(vehicle, lot.getTwoWheelersParkingSpace());
		else if (VehicleType.FOURWHEELER == vehicle.getVehicleType())
			return parkIfSlotAvailable(vehicle, lot.getFourWheelersParkingSpace());
		return false;
	}

	private boolean parkIfSlotAvailable(Vehicle vehicle, Queue<Slot> parkingSpace) {
		if (!parkingSpace.isEmpty()) {
			Slot allotedSlot = parkingSpace.remove();
			if (allotedSlot.isAvailable()) {
				allotedSlot.setAvailable(false);
				allotedSlot.setVehicle(vehicle);
				occupiedSpace.put(vehicle, allotedSlot);
				System.out.println(
						"Valet has parked " + vehicle.getRegistrationNumber() + " at " + allotedSlot.getSlotNumber());
				return true;
			}
		}
		System.out.println("No Parking space available for " + vehicle.getVehicleType());
		return false;
	}

	public boolean unpark(ParkingLot lot, Vehicle vehicle) {
		if (!occupiedSpace.containsKey(vehicle))
			return false;
		else {
			Slot freeSlot = occupiedSpace.get(vehicle);
			freeSlot.setAvailable(true);
			freeSlot.setVehicle(null);

			if (vehicle.getVehicleType() == VehicleType.TWOWHEELER)
				lot.getTwoWheelersParkingSpace().add(freeSlot);
			else if (vehicle.getVehicleType() == VehicleType.FOURWHEELER)
				lot.getFourWheelersParkingSpace().add(freeSlot);
			System.out.println("Slot number " + freeSlot.getSlotNumber() + " has become free");
			return true;
		}
	}

}
