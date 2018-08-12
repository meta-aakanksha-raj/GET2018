package employee;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSortById {

	@Test
	public void testSortByIDInAscendingOrder() {
		Employee employeeFirst = new Employee("A", 221, "BakerStreet", "c", 5);
		Employee employeeSecond = new Employee("B", 221, "BakerStreet", "c", 7);
		Employee employeeThird = new Employee("C", 221, "BakerStreet", "c", 8);
		Employee employeeFourth = new Employee("D", 221, "BakerStreet", "c", 2);
		Employee employeeFifth = new Employee("E", 221, "BakerStreet", "c", 4);

		List<Employee> listOfEmployee = new ArrayList<Employee>();

		listOfEmployee.add(employeeFirst);
		listOfEmployee.add(employeeSecond);
		listOfEmployee.add(employeeThird);
		listOfEmployee.add(employeeFourth);
		listOfEmployee.add(employeeFifth);

		Collections.sort(listOfEmployee, new SortById());

		int arrayOfSortedId[] = new int[listOfEmployee.size()];
		int index = 0;
		for (Employee employee : listOfEmployee) {
			arrayOfSortedId[index] = employee.getId();
			index++;
		}
		int expectedResult[] = new int[] { 2, 4, 5, 7, 8 };
		assertArrayEquals("collection is sorting by the id of the employee",expectedResult, arrayOfSortedId);
	}
}