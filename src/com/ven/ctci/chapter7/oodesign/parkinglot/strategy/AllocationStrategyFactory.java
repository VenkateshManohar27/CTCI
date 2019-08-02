package com.ven.ctci.chapter7.oodesign.parkinglot.strategy;

public class AllocationStrategyFactory {

	private static SpotAllocationStrategy nearest = new NearestSpot();
	private static SpotAllocationStrategy last = new LastSpot();

	public static SpotAllocationStrategy getStrategy(AllocationStrategy allocationStrategy) {
		SpotAllocationStrategy spotAllocationStrategy = null;
		switch (allocationStrategy) {
			case NEAREST:
				spotAllocationStrategy = nearest;
				break;
			case LAST:
				spotAllocationStrategy = last;
				break;
	
			default:
				spotAllocationStrategy = nearest;
				break;

		}
		return spotAllocationStrategy;
	}

}
