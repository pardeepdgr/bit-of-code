package comparator_chaining;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeChainedComparator implements Comparator<Employee>{
	private List<Comparator<Employee>> comparatorList;
	
	public EmployeeChainedComparator(Comparator<Employee>... comparator){
		comparatorList = Arrays.asList(comparator);
	}

	public int compare(Employee emp1, Employee emp2) {
		for(Comparator<Employee> comparator : comparatorList){
			int result = comparator.compare(emp1, emp2);
			return result;
		}
		return 0;
	}
}
