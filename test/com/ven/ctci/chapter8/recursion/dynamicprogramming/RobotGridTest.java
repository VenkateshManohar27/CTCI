package com.ven.ctci.chapter8.recursion.dynamicprogramming;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class RobotGridTest {
	private boolean[][] grid3x3 = { { true, true, true }, { true, false, true }, { true, true, true } };
	private boolean[][] grid3x3failure = { { true, false, true }, { false, false, true }, { true, true, true } };

	private boolean[][] grid5x5 = { { true, true, true, false, false }, { false, false, true, true, true },
			{ true, false, true, false, false },{ false, false, true, true, true }, { true, true, true, false, true } };
	private boolean[][] grid5x5failure = { { true, true, true, false, false }, { false, false, false, true, true },
			{ true, false, true, false, false },{ false, false, true, true, true }, { true, true, true, false, true } };

	@Test
	public void testNullGrid() {
		ArrayList<Point> path = RobotGrid.getPath(null);
		assertNull(path);

	}
	
	@Test
	public void testEmptyGrid() {
		ArrayList<Point> path = RobotGrid.getPath(new boolean[0][]);
		assertNull(path);

	}

	@Test
	public void testHappyPath() {
		ArrayList<Point> path = RobotGrid.getPath(grid3x3);
		assertNotNull(path);
		assertTrue(path.size() > 0);
	}

	@Test
	public void test3x3Failure() {
		ArrayList<Point> path = RobotGrid.getPath(grid3x3failure);
		assertNull(path);

	}

	@Test
	public void test5X5() {
		ArrayList<Point> path = RobotGrid.getPath(grid5x5);
		assertNotNull(path);
		assertTrue(path.size() > 0);
	}

	@Test
	public void test5X5Failure() {
		ArrayList<Point> path = RobotGrid.getPath(grid5x5failure);
		assertNull(path);

	}
}
