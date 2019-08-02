package com.ven.ctci.chapter7.oodesign.parkinglot.strategy;

import java.util.TreeSet;

import com.ven.ctci.chapter7.oodesign.parkinglot.model.Spot;

public class LastSpot implements SpotAllocationStrategy {

	@Override
	public Spot findSpot(TreeSet<Spot> availableSpots) {
		return availableSpots.pollLast();
	}

}
