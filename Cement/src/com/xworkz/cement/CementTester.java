package com.xworkz.cement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import  org.hibernate.exception.SQLGrammarException;

import com.xworkz.cement.dao.CementDaoImpl;
import com.xworkz.cement.entity.CementEntity;

import  org.hibernate.exception.SQLGrammarException;

public class CementTester {

	public static void main(String[] args) {

			CementDaoImpl cementDaoImpl = new CementDaoImpl();
		//	cementDaoImpl.saveCementEntity();
			
			cementDaoImpl.getCementEntity();
	}

}
