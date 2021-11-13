package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDao {


	void saveMobileEntity( MobileEntity mobileEntity);

	void getMobileEntity();

	void updateMobileEntity();

	void deleteMobileEntity();

	void getAllMobileEntity();

	void getMobileBrandByID(int mobileID);

	void getMobileEntityByID(int mobileID);

	void updateMobilePriceByID(int mobileID);

	void deleteMobileEntityByID();

	void minMobileEntityByMobilePrice();

	void maxMobileEntityByMobilePrice();

	void avgMobileEntityByMobilePrice();

	void sumMobileEntityByMobilePrice();

	void countMobileEntity();

	void setFirstResult();

	void setMaxResult();

	void updateMobilePriceByMobileBrand();
	
	void getMobileEntityByMobileBrand(String mobileBrand);
	
	void deleteMobileEntityByMobileBrand();
	
	
	void updateMobileBrandByMobilePrice();
	
	void getMobileEntityByRam(); //By RAM
	
	

}
