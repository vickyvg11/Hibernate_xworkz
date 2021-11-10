package com.xworkz.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IncrementGenerator;

@Table(name = "details_of_mobiles")
@Entity

public class MobileEntity implements java.io.Serializable {

	
	@Id
	@Column(name = "MOBILE_ID")
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")
	private int mobileID;

	@Column(name = "MOBILE_BRAND")
	private String mobileBrand;

	@Column(name = "MOBILE_PRICE")
	private double mobilePrice;

	@Column(name = "RAM")
	private String ram;

	@Column(name = "COLOR")
	private String color;

	@Column(name = "CAMERA_SIZE ")
	private int cameraSize;

	@Column(name = "IS_FINGER_PRINT_SUPPORTED")
	private boolean isFingerPrintSupported;

	@Column(name = "OS_TYPE")
	private String osType;

	public MobileEntity() {
		super();
		IncrementGenerator generator = new IncrementGenerator();

	}

	public MobileEntity(String mobileBrand, double mobilePrice, String ram, String color, int cameraSize,
			boolean isFingerPrintSupported, String osType) {
		super();
	//	this.mobileID = mobileID;
		this.mobileBrand = mobileBrand;
		this.mobilePrice = mobilePrice;
		this.ram = ram;
		this.color = color;
		this.cameraSize = cameraSize;
		this.isFingerPrintSupported = isFingerPrintSupported;
		this.osType = osType;
	}

	public int getMobileID() {
		return mobileID;
	}

	public void setMobileID(int mobileID) {
		this.mobileID = mobileID;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public double getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCameraSize() {
		return cameraSize;
	}

	public void setCameraSize(int cameraSize) {
		this.cameraSize = cameraSize;
	}

	public boolean isFingerPrintSupported() {
		return isFingerPrintSupported;
	}

	public void setFingerPrintSupported(boolean isFingerPrintSupported) {
		this.isFingerPrintSupported = isFingerPrintSupported;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	@Override
	public String toString() {
		return "MobileEntity [mobileID=" + mobileID + ", mobileBrand=" + mobileBrand + ", mobilePrice=" + mobilePrice
				+ ", rom=" + ram + ", color=" + color + ", cameraSize=" + cameraSize + ", isFingerPrintSupported="
				+ isFingerPrintSupported + ", osType=" + osType + "]";
	}
	
}
