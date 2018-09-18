package com.metacube.training.dao.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

public interface EmployeeDAO {
	
	List<Employee> getAllEmployee();

	boolean toggleActivation();

	boolean createEmployee(Employee employee);

	Employee getLastAddedEmployee();

	List<Employee> getTeamLeaders();

	List<Employee> getManagers();
	boolean addJobDetails(JobDetails jobDetails);

	Employee getEmployeeById(Employee employee);

	boolean updateEmployee(Employee employee);


}
