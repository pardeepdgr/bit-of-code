package bo;

import factory.AircraftFactory;

public class Su30MKI extends Aircraft {

	private String type;
	private String missileSystem;
	private AircraftFactory factory;

	public Su30MKI(AircraftFactory factory) {
		this.factory = factory;
		System.out.println("Aircraft is ready to takeoff.");
	}

	public Su30MKI(int type, String missileSystem) {
		System.out.println("Aircraft of " + type + " class equipped with "
				+ missileSystem + " is ready to takeoff.");
	}

	private String accessMissileSystem() {
		return "Needs launch code and coordinates to launch " + missileSystem;
	}

	private String accessMissileSystem(int code, String coordinates) {
		for (int countDown = 3; countDown > 0; countDown--) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(countDown);
		}
		return missileSystem + " has been fired to mentioned cordinates.";
	}

}
