package com.ven.ctci.chapter7.oodesign.parkinglot.impl;

import java.util.ArrayList;

import com.ven.ctci.chapter7.oodesign.parkinglot.model.ParkingFloor;
import com.ven.ctci.chapter7.oodesign.parkinglot.strategy.AllocationStrategy;
import com.ven.ctci.chapter7.oodesign.parkinglot.strategy.AllocationStrategyFactory;

public class ParkingLot {
	ArrayList<ParkingFloor> floors;

	private ParkingLot(ArrayList<ParkingFloor> floors) {
		this.floors = floors;
	}
	
	

	static class ParkingLotBuilder {
		ArrayList<ParkingFloor> floors = new ArrayList<>();
		private int numOfSpots = 0;

		public ParkingLot build() {
			return new ParkingLot(floors);
		}

		public void addFloorAndSpots(int floor, int spots) {
			floors.add(new ParkingFloor(floor, numOfSpots, spots, AllocationStrategyFactory.getStrategy(null)));
			numOfSpots += spots;
		}

		public void addFloorAndSpotsWithNearestStrategy(int floor, int spots) {
			floors.add(new ParkingFloor(floor, numOfSpots, spots,
					AllocationStrategyFactory.getStrategy(AllocationStrategy.NEAREST)));
			numOfSpots += spots;
		}

		public void addFloorAndSpotsWithLastStrategy(int floor, int spots) {
			floors.add(new ParkingFloor(floor, numOfSpots, spots,
					AllocationStrategyFactory.getStrategy(AllocationStrategy.LAST)));
			numOfSpots += spots;
		}
	}
}
