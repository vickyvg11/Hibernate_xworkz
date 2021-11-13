package com.xworkz.mobile.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;
import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.single_sectionfactory.SectionFactoryProvider;

public class MobileDaoImpl implements MobileDao {

	@Override
	public void saveMobileEntity(MobileEntity mobileEntity) {
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
			session.save(mobileEntity);
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


			org.hibernate.query.Query query = session.createQuery("hql");

			query.uniqueResult();



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

	@Override
	public void getAllMobileEntity() {
		System.out.println("INVOKED GET MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "from com.xworkz.mobile.entity.MobileEntity";
			org.hibernate.query.Query query = session.createQuery(hqlQuery);
			List listOfMobileEntity = query.list();
			System.out.println(listOfMobileEntity);
		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}

	}

	@Override
	public void getMobileBrandByID(int mobileID) {

		System.out.println("INVOKED Mobile by brqand ID MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "select mobileBrand from com.xworkz.mobile.entity.MobileEntity where  mobileID='"+mobileID+"'";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println(obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}
	}

	@Override
	public void getMobileEntityByID(int mobileID) {
		System.out.println("INVOKED Mobile Entity by ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "from com.xworkz.mobile.entity.MobileEntity where  mobileID='"+mobileID+"'";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println(obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void updateMobilePriceByID(int mobileID) {
		System.out.println("INVOKED Update Mobile Price by ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();
			session.beginTransaction();

			String hqlQuery = "update com.xworkz.mobile.entity.MobileEntity set mobilePrice='18000'  where  mobileID='"+mobileID+"'";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			int upadte=query.executeUpdate();

			session.getTransaction().commit();

			System.out.println(upadte);
			//	Object obj = query.uniqueResult();

			//	System.out.println(obj);

		}catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Rolled Back");
		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void deleteMobileEntityByID() {
		System.out.println("INVOKED Delete Mobile Entity by ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();
			session.beginTransaction();

			String hqlQuery = "delete from com.xworkz.mobile.entity.MobileEntity where mobileID=10";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			int upadte=query.executeUpdate();

			session.getTransaction().commit();

			System.out.println(upadte);
			//	Object obj = query.uniqueResult();

			//	System.out.println(obj);

		}catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Rolled Back");
		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void minMobileEntityByMobilePrice() {
		System.out.println("INVOKED min MobileEntity By Mobile Price ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "select min(mobilePrice) from com.xworkz.mobile.entity.MobileEntity";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println(obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void maxMobileEntityByMobilePrice() {
		System.out.println("INVOKED max MobileEntity By Mobile Price ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "select max(mobilePrice) from com.xworkz.mobile.entity.MobileEntity";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println(obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void avgMobileEntityByMobilePrice() {
		System.out.println("INVOKED max MobileEntity By Mobile Price ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "select avg(mobilePrice) from com.xworkz.mobile.entity.MobileEntity";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println(obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void sumMobileEntityByMobilePrice() {
		System.out.println("INVOKED Sum MobileEntity By Mobile Price ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "select sum(mobilePrice) from com.xworkz.mobile.entity.MobileEntity";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println(obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void countMobileEntity() {

		System.out.println("INVOKED Count MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "select count(*)from com.xworkz.mobile.entity.MobileEntity where ram =8 ";
			org.hibernate.query.Query query = session.createQuery(hqlQuery);
			List listOfMobileEntity = query.list();
			System.out.println(listOfMobileEntity);
		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}

	}

	@Override
	public void setFirstResult() {
		System.out.println("INVOKED First Row MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "from com.xworkz.mobile.entity.MobileEntity";
			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			query.setFirstResult(1);

			List listOfMobileEntity = query.list();
			System.out.println(listOfMobileEntity);
		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}


	}

	@Override
	public void setMaxResult() {
		System.out.println("INVOKED Max MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "from com.xworkz.mobile.entity.MobileEntity";
			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			//query.setFirstResult(1);

			query.setMaxResults(5);

			List listOfMobileEntity = query.list();
			System.out.println(listOfMobileEntity);
		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}

	}

	@Override
	public void updateMobilePriceByMobileBrand() {
		System.out.println("INVOKED Update Mobile Price by Mobile Brand");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();
			session.beginTransaction();

			String hqlQuery = "update com.xworkz.mobile.entity.MobileEntity set mobilePrice='15000.00'  where  mobileBrand = 'Iphone'";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			int upadte=query.executeUpdate();

			session.getTransaction().commit();
			System.out.println("Upadted"+upadte);
			System.out.println(upadte);
			//	Object obj = query.uniqueResult();

			//	System.out.println(obj);

		}catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Rolled Back");
		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void getMobileEntityByMobileBrand(String mobileBrand) {

		System.out.println("INVOKED Mobile Entity by Mobile Brand");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "from com.xworkz.mobile.entity.MobileEntity where  mobileBrand='"+mobileBrand+"'";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println(obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void deleteMobileEntityByMobileBrand() {

		System.out.println("INVOKED Delete Mobile Entity by Mobile Brand");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();
			session.beginTransaction();

			String hqlQuery = "delete from com.xworkz.mobile.entity.MobileEntity where mobileBrand='MicroMax'";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			int upadte=query.executeUpdate();

			session.getTransaction().commit();

			System.out.println(upadte);
			//	Object obj = query.uniqueResult();

			//	System.out.println(obj);

		}catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Rolled Back");
		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void updateMobileBrandByMobilePrice() {
		System.out.println("INVOKED Update Mobile Brand by Mobile Price");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();
			session.beginTransaction();

			String hqlQuery = "update com.xworkz.mobile.entity.MobileEntity set mobileBrand = 'Samsung' where  mobilePrice=15000";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			int upadte=query.executeUpdate();

			session.getTransaction().commit();
			System.out.println("Upadted"+upadte);
			System.out.println(upadte);
			//	Object obj = query.uniqueResult();

			//	System.out.println(obj);

		}catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Rolled Back");
		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void getMobileEntityByRam() {

		System.out.println("INVOKED Mobile Entity by RAM");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SectionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlQuery = "from com.xworkz.mobile.entity.MobileEntity where  ram='8GB'";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object obj = query.uniqueResult();

			System.out.println("Mobile Entity"+obj);

		}catch (HibernateException e) {

		}	finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}



}
