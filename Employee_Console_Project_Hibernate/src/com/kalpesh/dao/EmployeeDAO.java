package com.kalpesh.dao;

import com.kalpesh.entity.Employee;

public interface EmployeeDAO {
	//in interface by default all methods are abstract
	boolean saveEmployee(Employee employee); 
	boolean updateEmployee(Employee employee);
	Employee getEmployeeById(int id);
	boolean deleteEmployeeById(int id);
	

}
