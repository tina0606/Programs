package com.capg.ConferenceRegistration.bean;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ConferenceRegistrationBean {
	@FindBy(how=How.ID,id="txtFirstName")
	private WebElement firstName;
	
	@FindBy(how=How.ID,id="txtLastName")
	private WebElement lastName;
	
	@FindBy(how=How.ID,id="txtEmail")
	private WebElement email;

	@FindBy(how=How.ID, id="txtPhone")
	private WebElement contactNo;
	
	@FindBy(how=How.NAME,name="size")
	private WebElement noOfPerson;
	
	@FindBy(how=How.ID,id="txtAddress1")
	private WebElement buildingAndRoomNo;
	
	@FindBy(how=How.ID,id="txtAddress2")
	private WebElement areaName;
	
	@FindBy(how=How.NAME,name="city")
	private WebElement city;
	
	@FindBy(how=How.NAME,name="state")
	private WebElement state;
	
	
	@FindBy(how=How.NAME , name="memberStatus")
	private List<WebElement> memberStatus;
	
	
	@FindBy(how=How.LINK_TEXT,linkText="Next")
	private WebElement nextLink;
	
	public void clickNextPageLink() {
		nextLink.click();
	}
	
	@FindBy(how=How.ID,id="txtCardholderName")
	private WebElement cardHolderName;
	
	@FindBy(how=How.ID,id="txtDebit")
	private WebElement debitcardNo;
	
	@FindBy(how=How.ID,id="txtCvv")
	private WebElement cvv;
	
	@FindBy(how=How.ID,id="txtMonth")
	private WebElement ExpMonth;
	
	@FindBy(how=How.ID,id="txtYear")
	private WebElement ExpYear;
	
	@FindBy(how=How.ID,id="btnPayment")
	private WebElement makepayment;
	
	public void makepaymentclick()
	{
		makepayment.click();
	}

	public String getCardHolderName() {
		return cardHolderName.getAttribute("value");
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName.sendKeys(cardHolderName);
	}

public String getDebitcardNo() {
		return debitcardNo.getAttribute("value");
	}

	public void setDebitcardNo(String debitcardNo) {
		this.debitcardNo.sendKeys(debitcardNo);
	}

	public String getCvv() {
		return cvv.getAttribute("value");
	}


	public void setCvv(String cvv) {
		this.cvv.sendKeys(cvv);
	}


	public String getExpMonth() {
		return ExpMonth.getAttribute("value");
	}


	public void setExpMonth(String expMonth) {
		this.ExpMonth.sendKeys(expMonth);
	}


	public String getExpYear() {
		return ExpYear.getAttribute("value");
	}

	public void setExpYear(String expYear) {
		this.ExpYear.sendKeys(expYear);
	}


	public String  getMemberStatus() {
		for (WebElement webElement : memberStatus) 
			if(webElement.isSelected())
				return webElement.getAttribute("value");
			return null;
	}

	public void setMemberStatus(String memberStatus) {
		if(memberStatus.equals("member"))
			this.memberStatus.get(0).click();
		else if(memberStatus.equals("non-member"))
			this.memberStatus.get(1).click();
	}

	public String getState() {
		return new Select(this.state).getFirstSelectedOption().getText();
	}

	public void setState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	public String getCity() {
		return new Select(this.city).getFirstSelectedOption().getText();
	}

	public void setCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}

	public String getAreaName() {
		return areaName.getAttribute("value");
	}

	public void setAreaName(String areaName) {
		this.areaName.sendKeys(areaName);
	}

	public String getBuildingAndRoomNo() {
		return this.buildingAndRoomNo.getAttribute("value");
	}

	public void setBuildingAndRoomNo(String buildingAndRoomNo) {
		this.buildingAndRoomNo.sendKeys(buildingAndRoomNo);
	}

	public int getNoOfPerson() {
		return Integer.parseInt(new Select(noOfPerson).getFirstSelectedOption().getText());
	}

	public void setNoOfPerson(String noOfPerson) {
		 new Select(this.noOfPerson).selectByVisibleText(noOfPerson);
	}

	public String getContactNo() {
		return contactNo.getAttribute("value");
	}

	public void setContactNo(String contactNo) {
		this.contactNo.clear(); 
		this.contactNo.sendKeys(contactNo);
	}

	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public String getLastName() {
		return lastName.getAttribute("value");
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
}
