package com.xworkz.cement.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.cement.entity.CementEntity;

public class CementDaoImpl implements CementDAO {
	
	@Override
	public void saveCementEntity() {
		System.out.println("Invoked Save Entity()");
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = null;
		try {	Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(CementEntity.class);
		
		configuration.configure("CementHibernate.cfg.xml");
		
		 sessionFactory = configuration.buildSessionFactory();
		 session = sessionFactory.openSession();
			
			 transaction = session.beginTransaction();
			
			CementEntity cementEntity = new CementEntity(3, "Dalamia", 415.00, true, 30, true);
			session.save(cementEntity);
			session.getTransaction().commit();
			
			
			//session.close();
			//sessionFactory.close();
			
		} catch (HibernateException e) {
			System.out.println("Catch Block");
			transaction.rollback();
		}finally {
			if (session!=null) {
				session.close();
			}else {
				System.out.println("session Not is Closed");
			}
		} if (sessionFactory!=null) {
			sessionFactory.close();
		}else {
			System.out.println("Session Factory NOT is Closed");
		}
		
		
	
		
	}

	@Override
	public void getCementEntity() {
		System.out.println("Invoked Get Entity()");
	
		Session session = null;
		SessionFactory sessionFactory = null;
		try {	Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(CementEntity.class);
		
		configuration.configure("CementHibernate.cfg.xml");
		
		 sessionFactory = configuration.buildSessionFactory();
		 session = sessionFactory.openSession();
			
		CementEntity cementEntity = session.get(CementEntity.class, 1);
		System.out.println("Read The ID :"+cementEntity);
			
		} catch (HibernateException e) {
			System.out.println("Catch Block");
			
		}finally {
			if (session!=null) {
				session.close();
			}else {
				System.out.println("session Not is Closed");
			}
		} if (sessionFactory!=null) {
			sessionFactory.close();
		}else {
			System.out.println("Session Factory NOT is Closed");
		}
		
		
	}
		
		
	
}
