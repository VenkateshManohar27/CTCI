package com.ven.ctci.chapter7.oodesign.parkinglot.model;

import java.util.HashMap;
import java.util.TreeSet;

import com.ven.ctci.chapter7.oodesign.parkinglot.strategy.SpotAllocationStrategy;

public class ParkingFloor {
	private int level;
	private TreeSet<Spot> availableSpots;
	private HashMap<Integer, Spot> occupiedSpots;
	private int numOfAvailableSpots;
	private SpotAllocationStrategy spotAllocation;

	public ParkingFloor(int level, int index, int numOfSpots, SpotAllocationStrategy spotAllocation) {
		this.level = level;
		this.availableSpots = new TreeSet<>();
		this.occupiedSpots = new HashMap<Integer, Spot>();
		for (int i = 1; i <= numOfSpots; i++) {
			availableSpots.add(new Spot(index + i));
		}
		this.numOfAvailableSpots = numOfSpots;
		this.spotAllocation = spotAllocation;
	}

	public int getNumOfAvailableSpots() {
		return numOfAvailableSpots;
	}

	public boolean isSpotsAvailable() {
		return numOfAvailableSpots != 0;
	}

	public int getLevel() {
		return level;
	}

	public Spot park(Vehicle vehicle) {
		if (!isSpotsAvailable()) {
			return null;
		}

		Spot spot = spotAllocation.findSpot(availableSpots);
		spot.occupy();
		occupiedSpots.put(spot.getId(), spot);
		numOfAvailableSpots--;
		return spot;
	}

	public boolean unpark(Spot spot) {

		Spot releasedSpot = occupiedSpots.remove(spot.getId());
		releasedSpot.release();
		availableSpots.add(releasedSpot);
		numOfAvailableSpots++;
		return true;
	}

}
