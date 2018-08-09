import static org.junit.Assert.assertEquals;
import org.junit.Test;

import employee.Employee;

/**
 * to test the duplicacy of ID in List
 */
public class TestEmployeeCollectionDuplicateHandling {

	/**
	 * To test addition of one employee in list
	 */
	@Test
	public void testAddWhenAddingOnlyOneEmployee() {
		EmployeeCollectionDuplicateHandling newSetCollectionOfEmployee = new EmployeeCollectionDuplicateHandling();
		Employee empFirst = new Employee("A", 232, "b", "c", 5);
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(empFirst));
	}
	
	/**
	 * To test addition of same object twice in list
	 */
	@Test
	public void testAddWhenAddingSameObjectTwiceReturnsFalse() {
		EmployeeCollectionDuplicateHandling newSetCollectionOfEmployee = new EmployeeCollectionDuplicateHandling();
		Employee empFirst = new Employee("A", 232, "b", "c", 5);
		Employee empSecond = new Employee("B", 232, "b", "c", 7);
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(empFirst));
		assertEquals(false, newSetCollectionOfEmployee.addEmployee(empFirst));
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(empSecond));
	}

	/**
	 * To test addition of another employee with duplicate ID
	 */
	@Test
	public void testAddWhenAddingDifferentObjectWithDuplicateID() {
		EmployeeCollectionDuplicateHandling newSetCollectionOfEmployee = new EmployeeCollectionDuplicateHandling();
		Employee empThird = new Employee("C", 232, "b", "c", 8);
		Employee empFourth = new Employee("D", 231, "M", "G", 8);
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(empThird));
		assertEquals(false, newSetCollectionOfEmployee.addEmployee(empFourth));
	}
}
