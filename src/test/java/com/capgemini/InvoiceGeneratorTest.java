package com.capgemini;

import org.junit.*;

public class InvoiceGeneratorTest {
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double fare = invoiceGenerator.calculateFare(2.0, 5);
		Assert.assertEquals(25, fare, 0.0);
	}

}
