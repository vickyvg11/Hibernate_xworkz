package com.xworkz.cement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import  org.hibernate.exception.SQLGrammarException;
import com.xworkz.cement.entity.CementEntity;

import  org.hibernate.exception.SQLGrammarException;

public class CementTester {

	public static void main(String[] args) {

	Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(CementEntity.class);
		
		configuration.configure("CementHibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			CementEntity cementEntity = new CementEntity(1, "ACC", 380.00, true, 25, true);
			session.save(cementEntity);
			session.getTransaction().commit();
			
			session.close();
			sessionFactory.close();
			
	}

}
