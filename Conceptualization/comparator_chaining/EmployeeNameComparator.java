package comparator_chaining;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{

	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}

}
