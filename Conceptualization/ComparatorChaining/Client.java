package comparator_chaining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Tom", 45, 9, 80000));
		empList.add(new Employee("Sam", 30, 8, 75000));
		empList.add(new Employee("Bob", 45, 9, 134000));
		empList.add(new Employee("Peter", 25, 5, 60000));
		empList.add(new Employee("Tim", 45, 9, 130000));
		empList.add(new Employee("Craig", 30, 8, 52000));
		empList.add(new Employee("Anne", 25, 7, 51000));
		empList.add(new Employee("Alex", 30, 8, 120000));
		empList.add(new Employee("Bill", 22, 5, 30000));
		empList.add(new Employee("Samuel", 28, 7, 80000));
		empList.add(new Employee("John", 35, 8, 67000));
		empList.add(new Employee("Patrick", 35, 8, 140000));
		empList.add(new Employee("Alice", 35, 8, 80000));
		empList.add(new Employee("David", 35, 7, 99000));
		empList.add(new Employee("Jane", 30, 7, 82000));

		System.out.println("*** Before sorting:");
		for (Employee emp : empList) {
			System.out.println(emp.getName() + " : " + emp.getAge() + " : "
					+ emp.getJobGrade() + " : " + emp.getSalary());
		}

		Collections.sort(empList, new EmployeeChainedComparator(
				new EmployeeAgeComparator(), new EmployeeJobGradeComparator(),
				new EmployeeSalaryComparator()));

		System.out.println("\n*** After sorting:");

		for (Employee emp : empList) {
			System.out.println(emp.getName() + " : " + emp.getAge() + " : "
					+ emp.getJobGrade() + " : " + emp.getSalary());
		}
	}
}
