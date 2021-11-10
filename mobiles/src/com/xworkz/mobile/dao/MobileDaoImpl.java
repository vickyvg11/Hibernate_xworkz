package com.xworkz.mobile.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.single_sectionfactory.SectionFactoryProvider;

public class MobileDaoImpl implements MobileDao {

	@Override
	public void saveMobileEntity() {
		System.out.println("INVOKED SAVE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;

		try {
			
			sessionFactory =SectionFactoryProvider.getSessionFactory();

			//sessionFactory = new Configuration().configure("hibernatemobiles.cfg.xml")
				//	.addAnnotatedClass(MobileEntity.class).buildSessionFactory();

			session = sessionFactory.openSession();

			transaction =session.beginTransaction();

		/*	MobileEntity mobileEntity1 = new MobileEntity(1, "realme", 20000.00, "8GB", "Blue", 7, false, "Android");
			MobileEntity mobileEntity2 = new MobileEntity(2, "Iphone", 98000.00, "16GB", "Silver", 10, true, "IOS");
			MobileEntity mobileEntity3 = new MobileEntity(3, "Oneplus", 45000.00, "16GB", "Black", 10, false,"Android");
			MobileEntity mobileEntity4 = new MobileEntity(4, "Samsung", 35000.00, "8GB", "White", 10, true, "Android");
			MobileEntity mobileEntity5 = new MobileEntity(5, "Redmi", 20000.00, "6GB", "Red", 10, false, "Android");
			session.save(mobileEntity1);
			session.save(mobileEntity2);
			session.save(mobileEntity3);
			session.save(mobileEntity4);
			session.save(mobileEntity5);*/
			MobileEntity mobileEntity6 = new MobileEntity("MicroMax", 20000.00, "8GB", "Blue", 7, false, "Android");
			session.save(mobileEntity6);
			transaction.commit();
	//		System.out.println("row inserted");
			
	//		SectionFactoryProvider.closeSessionFactory();

		} catch (Exception e) {
			System.out.println("inside catch block !!!");
			transaction.rollback();
		} finally {
			if (session != null) {

				session.close();
				System.out.println(" session is closed");

			} else {

				System.out.println("session is not closed");

			}
		/*	if (sessionFactory != null) {

				sessionFactory.close();
				System.out.println(" sessionFactory is closed");
			} else {

				System.out.println("sessionFactory is not closed");

			}*/
		}
	}

	@Override
	public void getMobileEntity() {
		
		System.out.println("INVOKED GET MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 2);

			System.out.println("read is done" + mobileEntity);

			// SessionFactoryProvider.closeSessionFactory();
		} catch (Exception e) {

			System.out.println("inside catch block!!!");

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		
		}
	}

	@Override
	public void updateMobileEntity() {
		System.out.println("INVOKED UPDATE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 5);

			System.out.println("MobileEntity" + mobileEntity);

			mobileEntity.setMobileBrand("Vivo");
			mobileEntity.setOsType("Android");
			mobileEntity.setColor("GREY");

			transaction = session.beginTransaction();

			session.update(mobileEntity);

			transaction.commit();

			System.out.println("Update");

			// SessionFactoryProvider.closeSessionFactory();

		} catch (Exception e) {

			System.out.println("inside catch block!!!");
			transaction.rollback();

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}
	}

	@Override // Delete Method
	public void deleteMobileEntity() {

		System.out.println("INVOKED DELETE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 4);

			System.out.println("MobileEntity" + mobileEntity);

			transaction = session.beginTransaction();

			session.delete(mobileEntity);

			transaction.commit();

			System.out.println("delete");

			SectionFactoryProvider.closeSessionFactory();

		} catch (Exception e) {

			System.out.println("inside catch block!!!");
			transaction.rollback();

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}
	}

}
