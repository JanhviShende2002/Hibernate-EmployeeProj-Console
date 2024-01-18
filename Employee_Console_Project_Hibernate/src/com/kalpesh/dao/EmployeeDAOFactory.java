package com.kalpesh.dao;


public class EmployeeDAOFactory {
	
	public EmployeeDAO getEmployeeDAO()
	{
		return new EmployeeDAOImpl();
	}

}
