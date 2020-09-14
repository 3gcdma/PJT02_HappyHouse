package com.ssafy.happyhouse.test.shopAnalysisTest;

public class Shop {
	String sName; // 상호명(2)
	String mType; // 상권 업종 소분류명(6)
	String sType; // 상권 업종 소분류명(8)
	String sCity; // 시(12)
	String sDong;// 법정동(18)
	String newLoc; // 주소 26

	public Shop() {
	};

	public Shop(String sName, String mType, String sType, String sCity, String sDong, String newLoc) {
		super();
		this.sName = sName;
		this.mType = mType;
		this.sType = sType;
		this.sCity = sCity;
		this.sDong = sDong;
		this.newLoc = newLoc;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	public String getsDong() {
		return sDong;
	}

	public void setsDong(String sDong) {
		this.sDong = sDong;
	}

	public String getNewLoc() {
		return newLoc;
	}

	public void setNewLoc(String newLoc) {
		this.newLoc = newLoc;
	}

	@Override
	public String toString() {
		return "Shop [sName=" + sName + ", mType=" + mType + ", sType=" + sType + ", sCity=" + sCity + ", sDong="
				+ sDong + ", newLoc=" + newLoc + "]";
	}

}
