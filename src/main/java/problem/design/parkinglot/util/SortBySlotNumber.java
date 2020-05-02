package problem.design.parkinglot.util;

import java.util.Comparator;

import problem.design.parkinglot.Slot;

public class SortBySlotNumber implements Comparator<Slot> {

	@Override
	public int compare(Slot first, Slot second) {
		if (first.getSlotNumber() < second.getSlotNumber())
			return -1;
		else if (first.getSlotNumber() > second.getSlotNumber())
			return 1;
		return 0;
	}

}