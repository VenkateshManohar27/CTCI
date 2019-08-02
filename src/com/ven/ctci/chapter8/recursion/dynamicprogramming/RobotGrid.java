package com.ven.ctci.chapter8.recursion.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotGrid {

	public static ArrayList<Point> getPath(boolean[][] grid) {
		if (grid == null || grid.length == 0) {
			return null;
		}

		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<>();

		if (getPath(grid, grid.length - 1, grid[0].length - 1, path, failedPoints)) {
			return path;
		} else {
			return null;
		}
	}

	private static boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> path,
			HashSet<Point> failedPoints) {

		if (row < 0 || col < 0 || !grid[row][col]) {
			return false;
		}
		
		Point p  = new Point(row, col);
		
		if(failedPoints.contains(p)) {
			return false;
		}
		
		boolean isAtStart = (row == 0 && col ==0);
		if(isAtStart || getPath(grid, row-1, col, path, failedPoints) ||
				getPath(grid, row, col-1, path, failedPoints)) {
			path.add(p);
			return true;
		}
		failedPoints.add(p);
		return false;
	}

}

class Point {
	private int row;
	private int col;

	public Point(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "Point [row=" + row + ", col=" + col + "]";
	}
	
	

}