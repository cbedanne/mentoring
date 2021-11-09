package katas.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {

	public static Double getSalarySum(List<Employee> employees){
		return employees.stream()
				.map(Employee::getSalary)
				.reduce(0.0, Double::sum);
	}

	/**
	 * PartitioningBy only allows two partitions
	 *
	 */
	public static Map<Boolean, List<Employee>> getIsSalaryGreaterThan(List<Employee> employees,int i) {
		return employees.stream()
				.collect(Collectors.partitioningBy(e->e.getSalary()>i));
	}

	public static Map<Boolean, List<Employee>> getIsSalaryGreaterThanUsingGroupBy(List<Employee> employees,int i) {
		return employees.stream()
				.collect(Collectors.groupingBy(e->e.getSalary()>i));
	}

	public static Map<Character, List<Employee>> groupEmployeeByNameFirstLetter(List<Employee> employees) {
		return employees.stream()
				.collect(Collectors.groupingBy(employee-> employee.getName().charAt(0)));
	}

	public static Map<String,Double> createMapFromList(List<Employee> employees) {
		return employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));
	}
}
