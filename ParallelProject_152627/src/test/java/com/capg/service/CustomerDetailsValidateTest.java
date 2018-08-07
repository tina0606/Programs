package com.capg.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capg.bean.CustomerDetails;

public class CustomerDetailsValidateTest {

	CustomerDetails cust=new CustomerDetails();
	CustomerDetailsValidate validation=new CustomerDetailsValidate();
	@Test
	public void testValidateLogIn() {
		
	}

	@Test
	public void testValidateName() {
		assertEquals(true,validation.validateName("Anant"));
		assertEquals(true,validation.validateName("Anant kumar"));
		assertEquals(true,validation.validateName("AnantKumar"));
		assertEquals(false,validation.validateName("88AnantKumar"));
		assertEquals(false,validation.validateName("))Kumar"));
	}

	@Test
	public void testValidateUsername() {
		assertEquals(true,validation.validateUsername("Anant_96"));
		assertEquals(true,validation.validateUsername("Anant77796"));
		assertEquals(true,validation.validateUsername("AnantKumar777"));
		assertEquals(false,validation.validateUsername(")((858"));
		assertEquals(false,validation.validateUsername("   "));
	}

	@Test
	public void testValidatePassword() {
		assertEquals(true,validation.validatePassword("Anant5475"));
		assertEquals(true,validation.validatePassword("3145475"));
		assertEquals(true,validation.validatePassword("KK5475"));
		assertEquals(false,validation.validatePassword("*%^%^"));
		assertEquals(false,validation.validatePassword(" "));
		
	}

	@Test
	public void testValidateEmailID() {
        assertEquals(true,validation.validateEmailID("Anant@gmail.com"));
		assertEquals(true,validation.validateEmailID("Anant@gmail.com"));
		assertEquals(true,validation.validateEmailID("Aman@gmail.com"));
		assertEquals(false,validation.validateEmailID("Anant5475gmail.com"));
		assertEquals(false,validation.validateEmailID("Anant5475@gmail"));
	}

	@Test
	public void testValidatePhoneNo() {
		assertEquals(true,validation.validatePhoneNo("9876543210"));
		assertEquals(true,validation.validatePhoneNo("2222222222"));
		assertEquals(false,validation.validatePhoneNo("987654321"));
		assertEquals(false,validation.validatePhoneNo(" "));
	}

	@Test
	public void testValidateAge() {
		assertEquals(true,validation.validateAge(21));
		assertEquals(true,validation.validateAge(54));
		assertEquals(true,validation.validateAge(50));
		assertEquals(false,validation.validateAge(-21));
	}

	@Test
	public void testValidateGender() {
		assertEquals(true,validation.validateGender("Female"));
		assertEquals(true,validation.validateGender("F"));
		assertEquals(false,validation.validateGender("M"));
		assertEquals(false,validation.validateGender("Female"));
	}

}
