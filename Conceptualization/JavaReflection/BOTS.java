
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import bo.Su30MKI;
import factory.AircraftFactory;

public class BOTS {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class jet = Su30MKI.class;
		System.out.println("Alert!!!");
		System.out.println("Overridding the control of " + jet.getName());

		// Getting class modifier
		int accessType = jet.getModifiers();
		System.out.println("Access authenticated : " + Modifier.isPublic(accessType));

		// Getting implemented interface types
		Class[] interfaces = jet.getInterfaces();
		System.out.println("Interfaces Used:");
		for (Class interf : interfaces) {
			System.out.println(interf.getName());
		}

		// Getting superclass type
		Class parentType = jet.getSuperclass();
		System.out.println("Parent type of aircraft : " + parentType.getName());
		System.out.println();

		// Getting all methods and their parameter respectively
		Method[] opertionsOfAircraft = jet.getMethods();
		for (Method operation : opertionsOfAircraft) {
			System.out.println("Opertion of aircraft : " + operation.getName());
			System.out.println("Returns : " + operation.getReturnType());

			Class[] inputs = operation.getParameterTypes();
			System.out.print("Inputs required : ");
			for (Class input : inputs) {
				System.out.println(input.getName());
			}
			System.out.println();
		}

		// Creating constructor (way 1) 
		Constructor autoPilot = null;
		AircraftFactory factory = null;
		autoPilot = jet.getConstructor(new Class[] { AircraftFactory.class });
		Su30MKI a4 = (Su30MKI) autoPilot.newInstance(factory);
		a4.setType("A4");
		System.out.println(a4.getType());

		Class[] pilotAttributes = autoPilot.getParameterTypes();
		for (Class attribute : pilotAttributes) {
			System.out.println(attribute.getName());
		}

		// Creating constructor (way 2)
		Object anotherAutoPilot = null;
		anotherAutoPilot = jet.getConstructor(int.class, String.class).newInstance(1, "All A1 missile system");

		// Accessing private field
		Su30MKI mki = new Su30MKI(factory);
		Field missleSystem = null;
		missleSystem = jet.getDeclaredField("missileSystem");
		missleSystem.setAccessible(true);
		System.out.println("Missile system attached : " + missleSystem.get(mki));

		// Accessing private method
		Method classifiedOperation = jet.getDeclaredMethod("accessMissileSystem", null);
		classifiedOperation.setAccessible(true);
		System.out.println("Classified Operation : " + classifiedOperation.invoke(mki, null));

		Class[] params = new Class[] { Integer.TYPE, String.class };
		Object[] paramVal = new Object[] { new Integer(1), new String("12.345, 67.890") };
		Method anotherClassifiedOperation = jet.getDeclaredMethod("accessMissileSystem", params);
		anotherClassifiedOperation.setAccessible(true);
		System.out.println("Classified Operation : " + anotherClassifiedOperation.invoke(mki, paramVal));
	}
}
