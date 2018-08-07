package com.capg.bean;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountDetailsTest {
	AccountDetails details = new AccountDetails();

	@Test
	public void testGetUsername() {
		details.setUsername("Aman");
		assertEquals("Aman", details.getUsername());
		assertTrue("aman".equalsIgnoreCase(details.getUsername()));
		assertFalse("Anant".equalsIgnoreCase(details.getUsername()));
		assertFalse("Atharv".equalsIgnoreCase(details.getUsername()));

	}

	@Test
	public void testGetPassword() {
		details.setPassword("Ananth");
		assertEquals("Ananth", details.getPassword());
		assertTrue("Ananth".equalsIgnoreCase(details.getPassword()));
		// assertNull(" ".equalsIgnoreCase(details.getPassword()));

	}

	@Test
	public void testGetAccNo() {
		details.setAccNo(10000);
		assertFalse(89565 == details.getAccNo());
		assertFalse(56464 == details.getAccNo());
		assertFalse(141456464 == details.getAccNo());
		assertTrue(10000 == details.getAccNo());

	}

}
