package employee;

import java.util.Comparator;

/**
 * This class sorts the Employee object according to id in ascending order
 * This class has to implement the Comparator interface
 * Compare method returns -1, 0 or 1 to say if it is less than, equal, or greater to the other.
 * It uses this result to then determine if they should be swapped for its sort.
 */
class SortById implements Comparator<Employee>
{
	/**
	 * Here two objects of employee class are compared
	 * @param employeeFirst is the first object to compare
	 * @param employeesecond is the second object to compareS
	 * @return -1, 0 or 1 to say if it is less than, equal, or greater to the other
	 */
	@Override
	public int compare(Employee employeeFirst, Employee employeeSecond) {
	   return employeeFirst.getId()-employeeSecond.getId();
	}
}

