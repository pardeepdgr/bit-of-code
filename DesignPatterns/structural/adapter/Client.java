package adapter;

/**
 * The adapter pattern convert the interface of a class into another interface clients expect.
 * This adapter pattern is called Object Adapter Pattern because the adapter holds an instance of adaptee.
 * There is also another type called Class Adapter Pattern which use inheritance instead of composition 
 * but you require multiple inheritance to implement it.
 * 
 *  Client class is not complicated by having to use a different interface 
 *  and can use polymorphism to swap between different implementations of adapters.
 *  
 *  But sometimes many adaptations are required along an adapter chain to reach the type which is required.
 */
public class Client {

	public static void main(String[] args) {
		Adaptee adaptee = new AdapteeImpl();
		Target adaptedTarget = new Adapter(adaptee);

		adaptedTarget.bBehavior();
	}
}
