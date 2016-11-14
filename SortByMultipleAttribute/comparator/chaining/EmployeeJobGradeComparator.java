package comparator.chaining;

import java.util.Comparator;

public class EmployeeJobGradeComparator implements Comparator<Employee>{

	public int compare(Employee emp1, Employee emp2) {
		return emp1.getJobGrade().compareTo(emp2.getJobGrade());
	}

}
