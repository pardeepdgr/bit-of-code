package problem.design.parkinglot;

import org.junit.Test;

import problem.design.parkinglot.model.ParkingLot;
import problem.design.parkinglot.model.Vehicle;
import problem.design.parkinglot.type.VehicleType;

public class ParkingLotTest {
	private final int TWO_WHEELER_PARKING_SPACE = 2;
	private final int FOUR_WHEELER_PARKING_SPACE = 2;

	private Vehicle activa = new Vehicle("KA-01-HM-1234", VehicleType.TWOWHEELER);
	private Vehicle jupiter = new Vehicle("KA-01-HM-4567", VehicleType.TWOWHEELER);
	private Vehicle access = new Vehicle("KA-01-HM-7890", VehicleType.TWOWHEELER);
	private Vehicle baleno = new Vehicle("HR-10-AA-1234", VehicleType.FOURWHEELER);
	private Vehicle swift = new Vehicle("HR-10-AA-4567", VehicleType.FOURWHEELER);
	private Vehicle i20 = new Vehicle("HR-10-AA-7890", VehicleType.FOURWHEELER);

	@Test
	public void should_park_to_max_capacity_of_lot() {
		ParkingLot lot = new ParkingLot(TWO_WHEELER_PARKING_SPACE, FOUR_WHEELER_PARKING_SPACE);
		Valet valet = new Valet();

		valet.park(lot, activa);
		valet.park(lot, jupiter);
		valet.park(lot, baleno);
		valet.park(lot, swift);
	}

	@Test
	public void should_wait_for_empty_slot_to_park() {
		ParkingLot lot = new ParkingLot(TWO_WHEELER_PARKING_SPACE, FOUR_WHEELER_PARKING_SPACE);
		Valet valet = new Valet();
		valet.park(lot, activa);
		valet.park(lot, jupiter);
		valet.park(lot, access);
		valet.unpark(lot, activa);
		valet.park(lot, access);

		valet.park(lot, baleno);
		valet.park(lot, swift);
		valet.park(lot, i20);
		valet.unpark(lot, baleno);
		valet.park(lot, i20);
	}

}
