package com.xworkz.mobiles;

import java.util.Scanner;

import com.xworkz.mobile.dao.MobileDao;
import com.xworkz.mobile.dao.MobileDaoImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileTester {

	public static void main(String[] args) {
		MobileDao mobileDAOImpl = new MobileDaoImpl();
		
		MobileEntity mobileEntity = new MobileEntity( "Poco", 98000.00, "16GB", "Silver", 10, true, "IOS");
		mobileDAOImpl.saveMobileEntity(mobileEntity);
		
		
		
		
		// mobileDAOImpl.getMobileEntity();
		// mobileDAOImpl.updateMobileEntity();
		//mobileDAOImpl.deleteMobileEntity();

		//mobileDAOImpl.getAllMobileEntity();
		//mobileDAOImpl.getMobileBrandByID(3);
	//	Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter the Number:");
		
		//int mobileId =scanner.nextInt();
		
		//mobileDAOImpl.getMobileEntityByID();

		mobileDAOImpl.updateMobilePriceByID(1);

		//mobileDAOImpl.deleteMobileEntityByID();
		//mobileDAOImpl.minMobileEntityByMobilePrice();

		//mobileDAOImpl.maxMobileEntityByMobilePrice();

		//mobileDAOImpl.avgMobileEntityByMobilePrice();

		//mobileDAOImpl.sumMobileEntityByMobilePrice();

		//	mobileDAOImpl.countMobileEntity();

		//mobileDAOImpl.setFirstResult();

		//mobileDAOImpl.setMaxResult();

		//mobileDAOImpl.updateMobilePriceByMobileBrand();
	//	String brand=scanner.next();
		
	//	System.out.println("Enter the Brand:");
	//	mobileDAOImpl.getMobileEntityByMobileBrand(brand);

		//	mobileDAOImpl.deleteMobileEntityByMobileBrand();

		//mobileDAOImpl.updateMobileBrandByMobilePrice();

		//	mobileDAOImpl.getMobileEntityByRam();
	}



}
