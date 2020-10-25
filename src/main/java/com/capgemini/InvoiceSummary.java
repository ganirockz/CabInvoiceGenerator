package com.capgemini;

public class InvoiceSummary {
	private int numberOfRides;
	private double fare;
	private double averageFare;

	public InvoiceSummary(int numberOfRides, double fare) {
		this.numberOfRides = numberOfRides;
		this.fare = fare;
		this.setAverageFare(this.fare / this.numberOfRides);
	}

	public int getNumberOfRides() {
		return numberOfRides;
	}

	public void setNumberOfRides(int numberOfRides) {
		this.numberOfRides = numberOfRides;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public double getAverageFare() {
		return averageFare;
	}

	public void setAverageFare(double averageFare) {
		this.averageFare = averageFare;
	}

	public boolean equals(Object o) {
		if (!(o instanceof InvoiceSummary)) {
			return false;
		} else {
			InvoiceSummary invoiceSummary = (InvoiceSummary) o;
			if (invoiceSummary.getNumberOfRides() == this.numberOfRides) {
				if (invoiceSummary.getFare() == this.fare) {
					return true;
				}
			}
		}
		return false;
	}
}
