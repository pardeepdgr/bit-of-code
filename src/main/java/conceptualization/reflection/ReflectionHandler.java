package java_reflection;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionHandler {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, NoSuchFieldException {

		Class<Car> car = Car.class;
		System.out.println("Type: " + car.getName());

		/* implemented interfaces */
		Class<?>[] implementedInterfaces = car.getInterfaces();
		System.out.print("Implemented interfaces: ");
		for (Class<?> implementedInterface : implementedInterfaces)
			System.out.print(implementedInterface.getName() + ", ");

		/* super class */
		Class<?> superClass = car.getSuperclass();
		System.out.println("\n" + car.getName() + " is of type " + superClass.getName());

		/* class access specifier */
		if (Modifier.isPublic(car.getModifiers()))
			System.out.println(car.getName() + " has public access specifier");
		else if (Modifier.isPrivate(car.getModifiers()))
			System.out.println(car.getName() + " has private access specifier");

		/* default constructor */
		Object robotValet = car.getConstructor().newInstance();

		/* parameterized constructor */
		Object robotValet2 = car.getConstructor(String.class).newInstance("disel");

		/* public field */
		Field[] publicFields = car.getFields();
		for (Field publicField : publicFields) {
			System.out.println(publicField.getName() + " = " + publicField.get(robotValet));
		}

		/* public methods and their parameters */
		Method[] publicMethods = car.getMethods();
		for (Method publicMethod : publicMethods) {
			System.out.print(publicMethod.getName() + " has " + publicMethod.getReturnType() + " and parameter: ");

			Class<?>[] parameters = publicMethod.getParameterTypes();
			for (Class<?> parameter : parameters)
				System.out.print(parameter.getName());
			System.out.println();
		}

		/* get private field */
		Field[] privateFields = car.getDeclaredFields();
		for (Field privateField : privateFields) {
			privateField.setAccessible(true);
			System.out.println(privateField.getName() + " = " + privateField.get(robotValet));
		}

		/* set private field */
		Field privateField = car.getDeclaredField("maker");
		privateField.setAccessible(true);
		privateField.set(robotValet, "BMW");
		System.out.println(privateField.getName() + " = " + privateField.get(robotValet));

		/* private method with no parameters */
		Method privateMethod = car.getDeclaredMethod("startIgnition");
		privateMethod.setAccessible(true);
		System.out.println(privateMethod.getName() + " method has " + privateMethod.getReturnType() + " return type");
		privateMethod.invoke(robotValet);

		/* private method with a parameter */
		Class<?>[] arguments = new Class[] { Integer.TYPE };
		Object[] values = new Object[] { new Integer(80) };
		Method privateMethod2 = car.getDeclaredMethod("accelerate", arguments);
		privateMethod2.setAccessible(true);
		System.out.println(privateMethod2.getName() + " method has " + privateMethod2.getReturnType() + " return type");
		privateMethod2.invoke(robotValet2, values);
		
	}
	
}
