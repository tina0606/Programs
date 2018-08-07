package com.capg.bean;

import java.util.List;

public class CustomerDetails {
	private String name;
	private int age;
	private String emailId;
	private String phoneNo;
	private String gender;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", age=" + age + ", emailId=" + emailId + ", phoneNo="
				+ phoneNo + ", gender=" + gender + "]";
	}



}
