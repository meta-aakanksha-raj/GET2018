package employee;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to test SortByName class 
 */
public class TestSortByName {

	/**
	 * To test whether the list has been sorted according to the name
	 */
	@Test
	public void testSortByNameTypeOne() {
		Employee empFirst = new Employee("GH", 232, "b", "c", 5);
		Employee empSecond = new Employee("B", 232, "b", "c", 7);
		Employee empThird = new Employee("AB", 232, "b", "c", 8);
		Employee empFourth = new Employee("BH", 232, "b", "c", 2);
		Employee empFifth = new Employee("AA", 232, "b", "c", 4);

		List<Employee> listOfEmployee = new ArrayList<Employee>();

		listOfEmployee.add(empFirst);
		listOfEmployee.add(empSecond);
		listOfEmployee.add(empThird);
		listOfEmployee.add(empFourth);
		listOfEmployee.add(empFifth);

		Collections.sort(listOfEmployee, new SortByName());

		String arrayOfSortedName[] = new String[listOfEmployee.size()];
		int index = 0;
		for (Employee emp : listOfEmployee) {
			arrayOfSortedName[index] = emp.getName();
			index++;
		}
		String expectedResult[] = new String[] { "AA", "AB", "B", "BH", "GH" };
		assertArrayEquals("collection is sorting by the id name the employee",
				expectedResult, arrayOfSortedName);
	}

	/**
	 * To test whether the list has been sorted according to the name
	 */
	@Test
	public void testSortByNameTypeTwoWhereDuplicateNamesHaveBeenTaken() {
		Employee emp1 = new Employee("A", 232, "b", "c", 5);
		Employee emp2 = new Employee("AA", 232, "b", "c", 7);
		Employee emp3 = new Employee("AA", 232, "b", "c", 8);
		Employee emp4 = new Employee("BB", 232, "b", "c", 2);
		Employee emp5 = new Employee("BB", 232, "b", "c", 4);

		List<Employee> listOfEmployee = new ArrayList<Employee>();

		listOfEmployee.add(emp1);
		listOfEmployee.add(emp2);
		listOfEmployee.add(emp3);
		listOfEmployee.add(emp4);
		listOfEmployee.add(emp5);

		Collections.sort(listOfEmployee, new SortByName());

		String arrayOfSortedName[] = new String[listOfEmployee.size()];
		int index = 0;
		for (Employee emp : listOfEmployee) {
			arrayOfSortedName[index] = emp.getName();
			index++;
		}
		String expectedResult[] = new String[] { "A", "AA", "AA", "BB", "BB" };
		assertArrayEquals("collection is sorting by the name of the employee",
				expectedResult, arrayOfSortedName);
	}
}
