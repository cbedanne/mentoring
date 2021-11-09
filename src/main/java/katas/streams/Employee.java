package katas.streams;

import java.util.Arrays;
import java.util.List;

public class Employee {

	private int id;
	private String name;
	private double salary;

	public static List<Employee> employees = Arrays.asList(
			new Employee(1, "Jeff Bezos", 100000.0),
			new Employee(2, "Bill Gates", 200000.0),
			new Employee(3, "Mark Zuckerberg", 300000.0),
			new Employee(4,"Bob Dylan",200000)
	);

	public Employee(int id, String name, double salary) {

		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString(){
		return this.getName();
	}
}
