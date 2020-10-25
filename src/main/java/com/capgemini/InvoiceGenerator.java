package com.capgemini;

public class InvoiceGenerator {
	public final int COST_PER_KILOMETER = 10;
	public final int COST_PER_TIME = 1;
	public final int MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double fare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(MINIMUM_FARE, fare);
	}

}
