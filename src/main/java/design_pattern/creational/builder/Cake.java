package design_pattern.creational.builder;

/**
 *  
 */
public class Cake {

	private double flour;
	private double bakingPowder;
	private double sugar;
	private double butter;

	private int eggs;
	private String fruits;
	private String flavor;
	private int cherry;

	private Cake(CakeBuilder builder) {
		this.flour = builder.flour;
		this.bakingPowder = builder.bakingPowder;
		this.sugar = builder.sugar;
		this.butter = builder.butter;

		this.eggs = builder.eggs;
		this.fruits = builder.fruits;
		this.flavor = builder.flavor;
		this.cherry = builder.cherry;
	}

	public static class CakeBuilder {
		private double flour;
		private double bakingPowder;
		private double sugar;
		private double butter;

		private int eggs;
		private String fruits;
		private String flavor;
		private int cherry;

		public CakeBuilder flour(double cup) {
			this.flour = cup;
			return this;
		}

		public CakeBuilder bakingPowder(double cup) {
			this.bakingPowder = cup;
			return this;
		}

		public CakeBuilder sugar(double cup) {
			this.sugar = cup;
			return this;
		}

		public CakeBuilder butter(double cup) {
			this.butter = cup;
			return this;
		}

		public CakeBuilder eggs(int number) {
			this.eggs = number;
			return this;
		}

		public CakeBuilder fruits(String name) {
			this.fruits = name;
			return this;
		}

		public CakeBuilder flavor(String name) {
			this.flavor = name;
			return this;
		}

		public CakeBuilder cherry(int number) {
			this.cherry = number;
			return this;
		}

		public Cake build() {
			return new Cake(this);
		}
	}

	@Override
	public String toString() {
		return "Cake{" + "flour = " + flour + ", bakingpowder = " + bakingPowder + ", sugar = " + sugar + ", butter = "
				+ butter + ", eggs = " + eggs + ", fruits = " + fruits + ", flavor = " + flavor + ", cherry = " + cherry
				+ '}';
	}

}
