package com.vamc.myhib.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class HibernateTransaction<T> 
{

	protected Session hibernateSession;

	public abstract T execute(Session session);
	
	public T getResult()
	{
		Transaction transaction = null;
		try
		{
		hibernateSession = HibernateSessionFactory.getSession();
		transaction = hibernateSession.beginTransaction();
		T result = execute(hibernateSession);
		transaction.commit();
		return result;
		}
		catch(RuntimeException ex)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			System.out.println("Exception is : "+ex.getMessage());
			throw ex;
		}
		catch(Error er)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			System.out.println("Exception is : "+er.getMessage());
			throw er;
		}
		finally
		{
			hibernateSession.close();
		}
		
	}

}
