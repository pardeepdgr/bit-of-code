package conceptualization.comparator_chaining;

import conceptualization.comparator_chaining.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MultipleSortTest {

    @Test
    public void should_perform_multiple_sort_using_comparator_chaining() {
        List<Employee> employees = unsortedEmployees();

        MultipleSort.sort(employees);

        assertEquals(sortedEmployees(), employees);
    }

    private static List<Employee> unsortedEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Tom", 45, 9, 80000));
        employees.add(new Employee("Sam", 30, 8, 75000));
        employees.add(new Employee("Bob", 45, 9, 134000));
        employees.add(new Employee("Peter", 25, 5, 60000));
        employees.add(new Employee("Tim", 45, 9, 130000));
        employees.add(new Employee("Craig", 30, 8, 52000));
        employees.add(new Employee("Anne", 25, 7, 51000));
        employees.add(new Employee("Alex", 30, 8, 120000));
        employees.add(new Employee("Bill", 22, 5, 30000));
        employees.add(new Employee("Samuel", 28, 7, 80000));
        employees.add(new Employee("John", 35, 8, 67000));
        employees.add(new Employee("Patrick", 35, 8, 140000));
        employees.add(new Employee("Alice", 35, 8, 80000));
        employees.add(new Employee("David", 35, 7, 99000));
        employees.add(new Employee("Jane", 30, 7, 82000));
        return employees;
    }

    private static List<Employee> sortedEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Bill", 22, 5, 30000));
        employees.add(new Employee("Peter", 25, 5, 60000));
        employees.add(new Employee("Anne", 25, 7, 51000));
        employees.add(new Employee("Samuel", 28, 7, 80000));
        employees.add(new Employee("Sam", 30, 8, 75000));
        employees.add(new Employee("Craig", 30, 8, 52000));
        employees.add(new Employee("Alex", 30, 8, 120000));
        employees.add(new Employee("Jane", 30, 7, 82000));
        employees.add(new Employee("John", 35, 8, 67000));
        employees.add(new Employee("Patrick", 35, 8, 140000));
        employees.add(new Employee("Alice", 35, 8, 80000));
        employees.add(new Employee("David", 35, 7, 99000));
        employees.add(new Employee("Tom", 45, 9, 80000));
        employees.add(new Employee("Bob", 45, 9, 134000));
        employees.add(new Employee("Tim", 45, 9, 130000));
        return employees;
    }

}