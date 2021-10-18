package com.vamc.myhib.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory
{
	private static SessionFactory hibernateSessionFactory;

	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}

	@SuppressWarnings("deprecation")
	public static synchronized SessionFactory getSessionFactory()
	{
		if(hibernateSessionFactory == null)
		{
			Configuration configuraton = new Configuration().configure();
			hibernateSessionFactory = configuraton.buildSessionFactory();
		}
		return hibernateSessionFactory;
	}
	
	
}
