package com.capg.ConferenceRegistration.StepDefinition;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.capg.ConferenceRegistration.bean.ConferenceRegistrationBean;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;



public class ConferenceRegistrationStepDef {

	static WebDriver driver;
	private ConferenceRegistrationBean pageBean ;
	
	@Before
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:\\Srinivas\\drivers\\chromedriver.exe");
		
	}
	@Given("^User is on Conference room booking page$")
	public void user_is_on_Conference_room_booking_page() throws Throwable {
		driver = new ChromeDriver();
		driver.get("file:///D:/Alekya_Selenium/ConferenceRegistration/ConferenceRegistartion.html");
		driver.manage().window().maximize();
		pageBean= new ConferenceRegistrationBean();
		PageFactory.initElements(driver, pageBean); 
	}

	@When("^User select 'Next' link without entering 'FirstName'$")
	public void user_select_Next_link_without_entering_FirstName() throws Throwable {
		pageBean.clickNextPageLink();
	}

	@Then("^'Please fill the First Name' message should display$")
	public void please_fill_the_First_Name_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the First Name";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without entering 'LastName'$")
	public void user_select_Next_link_without_entering_LastName() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setFirstName("Alekya");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please fill the Last Name' message should display$")
	public void please_fill_the_Last_Name_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Last Name";
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	 

	@When("^User select 'Next' link without entering 'Email'$")
	public void user_select_Next_link_without_entering_Email() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setLastName("Raju");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please fill the Email' message should display$")
	public void please_fill_the_Email_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Email";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link after entering invalid 'Email' address$")
	public void user_select_Next_link_after_entering_invalid_Email_address() throws Throwable {
		driver.switchTo().alert().dismiss();
			pageBean.setEmail("alekya18.capgemini.com");
			pageBean.clickNextPageLink();
	}
	@Then("^'Please enter valid Email Id\\.' message should display$")
	public void please_enter_valid_Email_Id_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please enter valid Email Id.";
		Assert.assertEquals(expectedMessage, actualMessage);
	   
	}

	@When("^User select 'Next' link without entering 'Contact No'$")
	public void user_select_Next_link_without_entering_Contact_No() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setEmail("alekya18@capgemini.com");
		pageBean.clickNextPageLink();
	}
	
	@Then("^'Please fill the Contact No\\.' message should display$")
	public void please_fill_the_Contact_No_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Contact No.";
		Assert.assertEquals(expectedMessage, actualMessage);
	 
	}
	

	@When("^User select 'Next' link without selecting  'Number of people attending'$")
	public void user_select_Next_link_without_selecting_Number_of_people_attending() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setContactNo("9587463015");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please fill the Number of people attending' message should display$")
	public void please_fill_the_Number_of_people_attending_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Number of people attending";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without entering  'Building Name & Room No'$")
	public void user_select_Next_link_without_entering_Building_Name_Room_No() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setNoOfPerson("3");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please fill the Building & Room No' message should display$")
	public void please_fill_the_Building_Room_No_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Building & Room No";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without entering  'Area Name'$")
	public void user_select_Next_link_without_entering_Area_Name() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setBuildingAndRoomNo("A block, flat 172 ,Tirumala Nagar");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please fill the Area name' message should display$")
	public void please_fill_the_Area_name_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Area name";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without selecting  'City'$")
	public void user_select_Next_link_without_selecting_City() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setAreaName("Indira Nagar, Kondapur");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please select city' message should display$")
	public void please_select_city_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please select city";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without selecting  'State'$")
	public void user_select_Next_link_without_selecting_State() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setCity("Hyderabad");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please select state' message should display$")
	public void please_select_state_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please select state";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without selecting  'MemberShip Status$")
	public void user_select_Next_link_without_selecting_MemberShip_Status() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setState("Telangana");
		pageBean.clickNextPageLink();
	}

	@Then("^'Please Select MemeberShip status' message should display$")
	public void please_Select_MemeberShip_status_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please Select MemeberShip status";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link after entering Valid set of information$")
	public void user_select_Next_link_after_entering_Valid_set_of_information() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setFirstName("Alekya");
		pageBean.setLastName("Raju");
		pageBean.setEmail("alekya18@capgemini.com");
		pageBean.setContactNo("9587463015");
		pageBean.setNoOfPerson("3");
		pageBean.setBuildingAndRoomNo("A block, flat 172 ,Tirumala Nagar");
		pageBean.setAreaName("Indira Nagar, Kondapur");
		pageBean.setCity("Hyderabad");
		pageBean.setState("Telangana");
		pageBean.setMemberStatus("member");
		pageBean.clickNextPageLink();
	}

	@Then("^'Personal details are validated\\.' message should display$")
	public void personal_details_are_validated_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Personal details are validated.";
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(1000);
	}
	    

	@When("^User select 'Make Payment' link without entering 'Card Holder Name'$")
	public void user_select_Make_Payment_link_without_entering_Card_Holder_Name() throws Throwable {
		driver.switchTo().alert().dismiss();
       pageBean.makepaymentclick();

	}

	@Then("^'Please fill the Card Holder Name' message should display$")
	public void please_fill_the_Card_Holder_Name_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Card holder name";
		Assert.assertEquals(expectedMessage, actualMessage);


	}

	@When("^User select 'Make Payment' link without entering 'Debit Card Number'$")
	public void user_select_Make_Payment_link_without_entering_Debit_Card_Number() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setCardHolderName("Alekya");
		  pageBean.makepaymentclick();


	}

	@Then("^'Please fill the Debit Card Number' message should display$")
	public void please_fill_the_Debit_Card_Number_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Debit card Number";
		Assert.assertEquals(expectedMessage, actualMessage);


	}

	@When("^User select 'Make Payment' link without entering 'CVV'$")
	public void user_select_Make_Payment_link_without_entering_CVV() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setDebitcardNo("54698755566");
		 pageBean.makepaymentclick();
	   
	}

	@Then("^'Please fill the CVV' message should display$")
	public void please_fill_the_CVV_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the CVV";
		Assert.assertEquals(expectedMessage, actualMessage);
	    
	}

	@When("^User select 'Make Payment' link without entering 'Expiration month'$")
	public void user_select_Make_Payment_link_without_entering_Expiration_month() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setCvv("546");
		 pageBean.makepaymentclick();
	    
	}

	@Then("^'Please fill the Expiration month' message should display$")
	public void please_fill_the_Expiration_month_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill expiration month";
		Assert.assertEquals(expectedMessage, actualMessage);
	   
	}

	@When("^User select 'Make Payment' link without entering 'Expiration Year'$")
	public void user_select_Make_Payment_link_without_entering_Expiration_Year() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setExpMonth("12");
		 pageBean.makepaymentclick();
	    
	}

	@Then("^'Please fill the Expiration Year' message should display$")
	public void please_fill_the_Expiration_Year_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the expiration year";
		Assert.assertEquals(expectedMessage, actualMessage); 
	  
	}

	@When("^User select 'Make Payment' link after entering Valid set of information$")
	public void user_select_Make_Payment_link_after_entering_Valid_set_of_information() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setExpYear("2022");
		pageBean.makepaymentclick();
	}

	@Then("^'Conference Room Booking succesfully done!!!\\.' message should display$")
	public void conference_Room_Booking_succesfully_done_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Conference Room Booking successfully done!!!";
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().dismiss();
	    Thread.sleep(800);
	    driver.close();
	}

	public void exit()
	{

	}

}
