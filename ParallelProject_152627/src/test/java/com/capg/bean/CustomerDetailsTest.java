package com.capg.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import junit.framework.TestCase;

public class CustomerDetailsTest extends TestCase {

	CustomerDetails cust = new CustomerDetails();

	public void testGetName() {
		cust.setName("Anant");
		assertEquals("Anant", cust.getName());
		assertTrue("Anant".equals(cust.getName()));
		assertTrue("Anant".equalsIgnoreCase(cust.getName()));
		assertFalse(" ".equals(cust.getName()));
		assertFalse("Aman".equals(cust.getName()));
		assertFalse("gfdfg".equals(cust.getName()));
	}

	@Test
	public void testGetPhoneNo() {
		cust.setPhoneNo("9876543210");
		assertTrue("9876543210".equals(cust.getPhoneNo()));
		assertEquals("9876543210", cust.getPhoneNo());
		assertFalse(" ".equals(cust.getPhoneNo()));
		assertFalse("9864574310".equals(cust.getPhoneNo()));

	}

	@Test
	public void testGetEmailId() {
		cust.setEmailId("Anant@gmail.com");
		assertEquals("Anant@gmail.com", cust.getEmailId());
		assertTrue("Anant@gmail.com".equals(cust.getEmailId()));
		assertFalse("Aman@gmail.com".equals(cust.getEmailId()));
		assertFalse("Amangmail.com".equals(cust.getEmailId()));

	}

	@Test
	public void testGetAge() {
		cust.setAge(18);
		assertEquals(18, 18);
		assertEquals(18, cust.getAge());
		assertNotSame(0, cust.getAge());
		assertNotSame(21, cust.getAge());

	}

	@Test
	public void testGetGender() {
		cust.setGender("Female");
		assertEquals("Female", cust.getGender());
		assertTrue("Female".equals(cust.getGender()));
		assertTrue("female".equalsIgnoreCase(cust.getGender()));
		assertFalse("male".equalsIgnoreCase(cust.getGender()));
		assertFalse("male".equalsIgnoreCase(cust.getGender()));

	}

}
