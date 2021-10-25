package com.xworkz.cement.entity;
import  java.sql.SQLSyntaxErrorException;
import  javax.persistence.PersistenceException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name ="CEMENT_DETAILS")
@Entity
public class CementEntity {
	
		@Id
		@Column(name="CEMENT_ID")
		private int cementID;
		
		@Column(name="CEMENT_BRAND")
		private String cementBrand;
		
		@Column(name="CEMENT_PRICE")
		private double cementPrice;
		
		@Column(name="CEMENT_GYPSUM")
		private boolean isGypsumAdded;
		
		@Column(name="CEMENT_WEIGHT")
		private int weight;
		
		@Column(name="CEMENT_ISI")
		private boolean isISIMark;
		
		
		public CementEntity(int cementID, String cementBrand, double cementPrice, boolean isGypsumAdded, int weight,
				boolean isISIMark) {
			super();
			this.cementID = cementID;
			this.cementBrand = cementBrand;
			this.cementPrice = cementPrice;
			this.isGypsumAdded = isGypsumAdded;
			this.weight = weight;
			this.isISIMark = isISIMark;
			
		}

		

		public int getCementID() {
			return cementID;
		}

		public void setCementID(int cementID) {
			this.cementID = cementID;
		}

		public String getCementBrand() {
			return cementBrand;
		}

		public void setCementBrand(String cementBrand) {
			this.cementBrand = cementBrand;
		}

		public double getCementPrice() {
			return cementPrice;
		}

		public void setCementPrice(double cementPrice) {
			this.cementPrice = cementPrice;
		}

		public boolean isGypsumAdded() {
			return isGypsumAdded;
		}

		public void setGypsumAdded(boolean isGypsumAdded) {
			this.isGypsumAdded = isGypsumAdded;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public boolean isISIMark() {
			return isISIMark;
		}

		public void setISIMark(boolean isISIMark) {
			this.isISIMark = isISIMark;
		}


		@Override
		public String toString() {
			return "CementEntity [cementID=" + cementID + ", cementBrand=" + cementBrand + ", cementPrice="
					+ cementPrice + ", isGypsumAdded=" + isGypsumAdded + ", weight=" + weight + ", isISIMark="
					+ isISIMark + "]";
		}
}
