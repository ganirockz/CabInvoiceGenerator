package com.capgemini;

import java.util.ArrayList;

public class InvoiceService {
	public final int COST_PER_KILOMETER = 10;
	public final int COST_PER_TIME = 1;
	public final int MINIMUM_FARE = 5;
	RideRepository rideRepository = null;

	public InvoiceService() {
		rideRepository = new RideRepository();
	}

	public double calculateFare(double distance, int time) {
		double fare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(MINIMUM_FARE, fare);
	}

	public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
		double fare = 0;
		for (Ride ride : rides) {
			fare += calculateFare(ride.getDistance(), ride.getTime());
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.size(), fare);
		return invoiceSummary;
	}

	public void addRides(String userId, ArrayList<Ride> rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		ArrayList<Ride> rides = rideRepository.getRides(userId);
		return calculateFare(rides);
	}
}
