package problem.design.parkinglot.model;

import java.util.PriorityQueue;
import java.util.Queue;

import problem.design.parkinglot.model.Slot;
import problem.design.parkinglot.sort.SortBySlotNumber;

public class ParkingLot {
	private Queue<Slot> twoWheelersParkingSpace;
	private Queue<Slot> fourWheelersParkingSpace;
	private boolean isAvailable = true;

	public ParkingLot(int numberOfSlotsForTwoWheelers, int numberOfSlotsForFourWheelers) {
		twoWheelersParkingSpace = new PriorityQueue<Slot>(numberOfSlotsForTwoWheelers, new SortBySlotNumber());
		fourWheelersParkingSpace = new PriorityQueue<Slot>(numberOfSlotsForFourWheelers, new SortBySlotNumber());

		for (int slotNumber = 1; slotNumber <= numberOfSlotsForTwoWheelers; slotNumber++)
			twoWheelersParkingSpace.add(new Slot(slotNumber, isAvailable));

		for (int slotNumber = 1; slotNumber <= numberOfSlotsForFourWheelers; slotNumber++)
			fourWheelersParkingSpace.add(new Slot(slotNumber, isAvailable));
	}

	public Queue<Slot> getTwoWheelersParkingSpace() {
		return twoWheelersParkingSpace;
	}

	public Queue<Slot> getFourWheelersParkingSpace() {
		return fourWheelersParkingSpace;
	}

}