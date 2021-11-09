package katas.streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class StreamAPITest {

	List<Employee> employees = Employee.employees;

	@Test
	public void testSum(){

		Double salarySum = StreamAPI.getSalarySum(employees);
		assertThat(salarySum).isEqualTo(800000);
	}

	@Test
	public void testPartioningBy(){
		Map<Boolean,List<Employee>> isGreaterThan= StreamAPI.getIsSalaryGreaterThan(Employee.employees, 200000);

		assertThat(isGreaterThan.get(true).size()).isEqualTo(1);
		assertThat(isGreaterThan.get(false).size()).isEqualTo(3);
	}

	@Test
	public void testGroupingBy(){
		Map<Character,List<Employee>> nameFirstLetterGroup= StreamAPI.groupEmployeeByNameFirstLetter(Employee.employees);

		System.out.println(employees);

		assertThat(nameFirstLetterGroup.get('B').size()).isEqualTo(2);

		System.out.println(nameFirstLetterGroup);
	}

	@Test
	public void testListToMap(){
		Map<String, Double > salaryMap=StreamAPI.createMapFromList(employees);
		assertThat(salaryMap.get("Bob Dylan")).isEqualTo(200000);

	}

}