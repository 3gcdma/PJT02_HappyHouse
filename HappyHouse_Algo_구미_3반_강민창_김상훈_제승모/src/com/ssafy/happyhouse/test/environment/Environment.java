package com.ssafy.happyhouse.test.environment;

public class Environment {
	String factory;
	String license;
	int code;
	int date;
	String check;
	String disposal;
	String task;
	String location;
	String area;
	
	public Environment() {
	}

	public Environment(String factory, String license, int code, int date, String check, String disposal, String task,
			String location, String area) {
		super();
		this.factory = factory;
		this.license = license;
		this.code = code;
		this.date = date;
		this.check = check;
		this.disposal = disposal;
		this.task = task;
		this.location = location;
		this.area = area;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getDisposal() {
		return disposal;
	}

	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Environment [factory=" + factory + ", license=" + license + ", code=" + code + ", date=" + date
				+ ", check=" + check + ", disposal=" + disposal + ", task=" + task + ", location=" + location
				+ ", area=" + area + "]";
	}

	
	
	
}
