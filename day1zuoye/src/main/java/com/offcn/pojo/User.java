package com.offcn.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Users")
public class User {
	
	private int id;
	private String MobileNumber;
	private String MobileArea;
    private String MobileType;
    private String AreaCode;
    private String PostCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getMobileArea() {
		return MobileArea;
	}
	public void setMobileArea(String mobileArea) {
		MobileArea = mobileArea;
	}
	public String getMobileType() {
		return MobileType;
	}
	public void setMobileType(String mobileType) {
		MobileType = mobileType;
	}
	public String getAreaCode() {
		return AreaCode;
	}
	public void setAreaCode(String areaCode) {
		AreaCode = areaCode;
	}
	public String getPostCode() {
		return PostCode;
	}
	public void setPostCode(String postCode) {
		PostCode = postCode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", MobileNumber=" + MobileNumber + ", MobileArea=" + MobileArea + ", MobileType="
				+ MobileType + ", AreaCode=" + AreaCode + ", PostCode=" + PostCode + "]";
	}


}
