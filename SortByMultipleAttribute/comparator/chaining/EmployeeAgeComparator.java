package comparator.chaining;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee>{

	public int compare(Employee emp1, Employee emp2){
		return emp1.getAge().compareTo(emp2.getAge());
	}
}
