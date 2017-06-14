package builder;

/*
 * Separate the construction of a complex object from its representation so that the same 
 * construction process can create different representations
 */
public class CakeClient {

	public static void main(String[] args) {
		Cake fruitCake = new Cake.CakeBuilder().flour(1).bakingPowder(.25).sugar(1).butter(2)
				.fruits("Kiwi, Orange, Grapes").flavor("Rasphberry").cherry(6).build();
		System.out.println(fruitCake);
	}
}
