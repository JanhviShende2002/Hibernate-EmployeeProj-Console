package com.kalpesh.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
	private static SessionFactory factory;
	
	private HibernateUtility()//used singleton design pattern i.e A class having only one object
	{
		
	}
	public static SessionFactory getSessionFactory()
	{
		if(factory==null)
		{
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		}
		else {
		return factory;
		
	}
	
	}
}
