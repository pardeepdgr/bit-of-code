package conceptualization.comparator_chaining.model;

import java.util.Objects;

public class Employee {
	private String name;
	private Integer age;
	private Integer jobGrade;
	private Integer salary;
	
	public Employee(String name, Integer age, Integer jobGrade, Integer salary){
		this.name = name;
		this.age = age;
		this.jobGrade = jobGrade;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getJobGrade() {
		return jobGrade;
	}

	public void setJobGrade(Integer jobGrade) {
		this.jobGrade = jobGrade;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee employee = (Employee) o;
		return name.equals(employee.name) &&
				age.equals(employee.age) &&
				jobGrade.equals(employee.jobGrade) &&
				salary.equals(employee.salary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, jobGrade, salary);
	}

}
