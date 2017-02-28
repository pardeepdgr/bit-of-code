package java_reflection;
import java.io.Serializable;

public class Car extends Vehicle implements Serializable, Cloneable {

	private static final long serialVersionUID = -1321720391517124036L;

	private String maker;
	private String model;
	private String technicalSpecification;
	private int price;

	public Car() {
		technicalSpecification = "petrol";
		System.out.println("Car is of petrol version");
	}

	public Car(String disel) {
		if ("disel".equals(disel)) {
			technicalSpecification = disel;
			System.out.println("Car is of disel version");
		} else {
			technicalSpecification = "petrol";
			System.out.println("Car is of petrol version");
		}
	}

	private boolean startIgnition() {
		System.out.println("Engine has started");
		return true;
	}

	private boolean accelerate(int speed) {
		System.out.println("Car speed is " + speed + " Kmph");
		return true;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTechnicalSpecification() {
		return technicalSpecification;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
