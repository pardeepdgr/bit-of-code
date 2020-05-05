package conceptualization.reflection;

import conceptualization.reflection.model.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Carjacker {

	public static void main(String[] args) throws Exception {
		Class<Car> car = Car.class;
		System.out.println("Type: " + car.getName());

		Object defaultConstructor = car.getConstructor().newInstance();
		Object parameterizedConstructor = car.getConstructor(String.class).newInstance("diesel");

		findImplementedInterfaces(car);

		findSuperClass(car);

		findAccessModifierForClass(car);

		findPublicVariablesWithValue(car, defaultConstructor);

		findAllPublicMethodSignature(car);

		findPrivateVariablesWithValue(car, defaultConstructor);

		setValueForPrivateVariable(car, defaultConstructor);

		callPrivateNoArgMethod(car, defaultConstructor);

		callPrivateMethod(car, parameterizedConstructor);
	}

	private static void findImplementedInterfaces(Class<Car> car) {
		Class<?>[] implementedInterfaces = car.getInterfaces();

		System.out.print("Implemented interfaces: ");
		for (Class<?> implementedInterface : implementedInterfaces)
			System.out.print(implementedInterface.getName() + ", ");
	}

	private static void findSuperClass(Class<Car> car) {
		Class<?> superClass = car.getSuperclass();
		System.out.println("\n" + car.getName() + " is of type " + superClass.getName());
	}

	private static void findAccessModifierForClass(Class<Car> car) {
		if (Modifier.isPublic(car.getModifiers()))
			System.out.println(car.getName() + " has public access specifier");
		else if (Modifier.isPrivate(car.getModifiers()))
			System.out.println(car.getName() + " has private access specifier");
	}

	private static void findPublicVariablesWithValue(Class<Car> car, Object petrolCarjacker) throws IllegalAccessException {
		Field[] publicFields = car.getFields();
		for (Field publicField : publicFields) {
			System.out.println(publicField.getName() + " = " + publicField.get(petrolCarjacker));
		}
	}

	private static void findAllPublicMethodSignature(Class<Car> car) {
		Method[] publicMethods = car.getMethods();
		for (Method publicMethod : publicMethods) {
			System.out.print(publicMethod.getName() + " returns " + publicMethod.getReturnType() + " and has ");

			Class<?>[] parameters = publicMethod.getParameterTypes();
			if(parameters.length == 0)
				System.out.print("no");
			for (Class<?> parameter : parameters)
				System.out.print(parameter.getName());
			System.out.println(" parameter");
		}
	}

	private static void findPrivateVariablesWithValue(Class<Car> car, Object petrolCarjacker) throws IllegalAccessException {
		Field[] privateFields = car.getDeclaredFields();

		for (Field privateField : privateFields) {
			privateField.setAccessible(true);
			System.out.println(privateField.getName() + " = " + privateField.get(petrolCarjacker));
		}
	}

	private static void setValueForPrivateVariable(Class<Car> car, Object petrolCarjacker)
			throws NoSuchFieldException, IllegalAccessException {
		Field privateField = car.getDeclaredField("maker");
		privateField.setAccessible(true);
		privateField.set(petrolCarjacker, "BMW");
		System.out.println(privateField.getName() + " = " + privateField.get(petrolCarjacker));
	}

	private static void callPrivateNoArgMethod(Class<Car> car, Object defaultConstructor)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = car.getDeclaredMethod("startIgnition");
		privateMethod.setAccessible(true);
		privateMethod.invoke(defaultConstructor);
	}

	private static void callPrivateMethod(Class<Car> car, Object parameterizedConstructor)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Class<?>[] arguments = new Class[] { Integer.TYPE };
		Method privateMethod = car.getDeclaredMethod("accelerate", arguments);
		privateMethod.setAccessible(true);
		Object[] values = new Object[] { new Integer(80) };
		privateMethod.invoke(parameterizedConstructor, values);
	}

}
