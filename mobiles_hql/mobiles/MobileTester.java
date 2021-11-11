package com.xworkz.mobiles;

import com.xworkz.mobile.dao.MobileDao;
import com.xworkz.mobile.dao.MobileDaoImpl;

public class MobileTester {

	public static void main(String[] args) {
		MobileDao mobileDAOImpl = new MobileDaoImpl();
		 mobileDAOImpl.saveMobileEntity();
		// mobileDAOImpl.getMobileEntity();
       // mobileDAOImpl.updateMobileEntity();
			//mobileDAOImpl.deleteMobileEntity();

	}

}
