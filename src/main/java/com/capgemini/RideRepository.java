package com.capgemini;

import java.util.*;

public class RideRepository {
	Map<String, ArrayList<Ride>> rides = null;

	public RideRepository() {
		this.rides = new HashMap<>();
	}

	public void addRides(String userId, ArrayList<Ride> rides) {
		ArrayList<Ride> rideList = this.rides.get(userId);
		if (rideList == null) {
			this.rides.put(userId, new ArrayList<>(rides));
		}
	}

	public ArrayList<Ride> getRides(String userId) {
		return this.rides.get(userId);
	}
}
