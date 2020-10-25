package com.capgemini;

import org.junit.*;
import java.util.*;

public class InvoiceGeneratorTest {
	InvoiceService invoiceGenerator = null;
	boolean isPremiumCustomer = false;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceService();
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
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(30, invoiceSummary.getFare(), 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary summary = new InvoiceSummary(2, 30);
		Assert.assertEquals(summary, invoiceSummary);
	}

	@Test
	public void givenUserId_ShouldReturnInvoiceBasedOnRides() {
		ArrayList<Ride> ride1 = new ArrayList<Ride>();
		ride1.add(new Ride(2.0, 5));
		ride1.add(new Ride(0.1, 1));
		String userId1 = "a@bc.com";
		invoiceGenerator.addRides(userId1, ride1);
		ArrayList<Ride> ride2 = new ArrayList<Ride>();
		ride2.add(new Ride(2.0, 5));
		ride2.add(new Ride(1.0, 1));
		String userId2 = "a@b.com";
		invoiceGenerator.addRides(userId2, ride2);
		isPremiumCustomer = false;
		InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(isPremiumCustomer, userId2);
		InvoiceSummary summary = new InvoiceSummary(2, 36);
		Assert.assertEquals(summary, invoiceSummary);
	}

	@Test
	public void givenUserId_ShouldReturnInvoiceBasedOnPremiumRides() {
		ArrayList<Ride> ride1 = new ArrayList<Ride>();
		ride1.add(new Ride(2.0, 5));
		ride1.add(new Ride(0.1, 1));
		String userId1 = "a@bc.com";
		invoiceGenerator.addRides(userId1, ride1);
		ArrayList<Ride> ride2 = new ArrayList<Ride>();
		ride2.add(new Ride(2.0, 5));
		ride2.add(new Ride(1.0, 1));
		String userId2 = "a@b.com";
		invoiceGenerator.addRides(userId2, ride2);
		isPremiumCustomer = true;
		InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(isPremiumCustomer, userId1);
		InvoiceSummary summary = new InvoiceSummary(2, 60);
		Assert.assertEquals(summary, invoiceSummary);
	}
}
