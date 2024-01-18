package com.kalpesh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kalpesh.entity.Employee;
import com.kalpesh.utility.HibernateUtility;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public boolean saveEmployee(Employee employee) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Employee getEmployeeById(int id) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee employee=(Employee)session.get(Employee.class, id);
		if(employee!=null)
		{
			return employee;
		}
		session.close();
		return null;
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee employee=new Employee();
		employee.setId(id);
		session.delete(employee);
		tx.commit();
		session.close();
		return true;
	}

}
