package conceptualization.comparator_chaining;

import conceptualization.comparator_chaining.chain.EmployeeChainedComparator;
import conceptualization.comparator_chaining.comparator.EmployeeAgeComparator;
import conceptualization.comparator_chaining.comparator.EmployeeJobGradeComparator;
import conceptualization.comparator_chaining.comparator.EmployeeSalaryComparator;
import conceptualization.comparator_chaining.model.Employee;

import java.util.Collections;
import java.util.List;

public class MultipleSort {

	public static void sort(List<Employee> employees) {
		Collections.sort(employees, new EmployeeChainedComparator(
				new EmployeeAgeComparator(), new EmployeeJobGradeComparator(),
				new EmployeeSalaryComparator()));
	}

}
