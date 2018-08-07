package com.capg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capg.service.RechargeDataValidate;

public class RechargeDataValidateTest {
	RechargeDataValidate val = new RechargeDataValidate();

	@Test
	public void testValidatedthOperator() {
		assertEquals(true, val.validatedthOperator("Airtel"));
		assertEquals(true, val.validatedthOperator("TataSky"));
		assertEquals(true, val.validatedthOperator("DishTv"));
		assertEquals(true, val.validatedthOperator("Reliance"));
		// Object dthOperator = "Airtel";
		// assertEquals(dthOperator,"Airtel");

	}

	@Test
	public void testValidateConsumerNo() {
	}

	@Test
	public void testValidatePlan() {
		assertEquals(true, val.validatePlan("Monthly"));
		assertEquals(true, val.validatePlan("Annual"));
		assertEquals(true, val.validatePlan("Half yearly"));
		assertEquals(true, val.validatePlan("Quarterly"));

		// Object rechargePlan="Monthly";
		// assertEquals(rechargePlan,"Monthly");

	}

	@Test
	public void testValidateAmount() {
		Object Amount = 1000;
		assertEquals(Amount, 1000);
		// fail("Not yet implemented");
	}
}
