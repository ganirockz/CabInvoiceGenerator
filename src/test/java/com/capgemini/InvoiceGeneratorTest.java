package com.capgemini;

import org.junit.*;
import java.util.*;

public class InvoiceGeneratorTest {
	InvoiceGenerator invoiceGenerator = null;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double fare = invoiceGenerator.calculateFare(2.0, 5);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		double fare = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(30, fare, 0.0);
	}

}
