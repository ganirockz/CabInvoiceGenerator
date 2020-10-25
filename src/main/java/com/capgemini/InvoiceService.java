package com.capgemini;

import java.util.ArrayList;

public class InvoiceService {
	public final int COST_PER_KILOMETER = 10;
	public final int COST_PER_TIME = 1;
	public final int MINIMUM_FARE = 5;
	public final int PREMIUM_COST_PER_KILOMETER = 15;
	public final int PREMIUM_COST_PER_TIME = 2;
	public final int PREMIUM_MINIMUM_FARE = 20;
	RideRepository rideRepository = null;

	public InvoiceService() {
		rideRepository = new RideRepository();
	}

	public double calculateFare(double distance, int time) {
		double fare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(MINIMUM_FARE, fare);
	}

	public double calculatePremiumFare(double distance, int time) {
		double fare = distance * PREMIUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
		return Math.max(PREMIUM_MINIMUM_FARE, fare);
	}

	public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
		double fare = 0;
		for (Ride ride : rides) {
			fare += calculateFare(ride.getDistance(), ride.getTime());
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.size(), fare);
		return invoiceSummary;
	}

	public InvoiceSummary calculatePremiumFare(ArrayList<Ride> rides) {
		double fare = 0;
		for (Ride ride : rides) {
			fare += calculatePremiumFare(ride.getDistance(), ride.getTime());
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.size(), fare);
		return invoiceSummary;
	}

	public void addRides(String userId, ArrayList<Ride> rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(boolean IsPremium, String userId) {
		ArrayList<Ride> rides = rideRepository.getRides(userId);
		if (IsPremium) {
			return calculatePremiumFare(rides);
		} else {
			return calculateFare(rides);
		}
	}
}
