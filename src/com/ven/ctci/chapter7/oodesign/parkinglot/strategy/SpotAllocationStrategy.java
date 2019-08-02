package com.ven.ctci.chapter7.oodesign.parkinglot.strategy;

import java.util.TreeSet;

import com.ven.ctci.chapter7.oodesign.parkinglot.model.Spot;

public interface SpotAllocationStrategy {
	Spot findSpot(TreeSet<Spot> availableSpots);
}
