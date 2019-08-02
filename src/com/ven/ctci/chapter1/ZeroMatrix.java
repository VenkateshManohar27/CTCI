package com.ven.ctci.chapter1;

import com.vm.utility.ArrayUtility;

public class ZeroMatrix {

	public static int[][] zeroMatrixSimple(int[][] arr) {
		if (arr == null) {
			throw new IllegalArgumentException("Array cannot be null");
		}
		boolean[] rows = new boolean[arr.length];
		boolean[] cols = new boolean[arr[0].length];

		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				if (arr[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;

				}
			}
		}

		for (int i = 0; i < rows.length; i++) {
			if (rows[i]) {
				nullifyRow(arr, i);
			}
		}

		for (int i = 0; i < cols.length; i++) {
			if (cols[i]) {
				nullifyCol(arr, i);
			}
		}
		return arr;
	}

	private static void nullifyCol(int[][] arr, int i) {

		for (int j = 0; j < arr.length; j++) {
			arr[j][i] = 0;
		}
	}

	private static void nullifyRow(int[][] arr, int i) {
		for (int j = 0; j < arr[i].length; j++) {
			arr[i][j] = 0;
		}
	}

	public static int[][] zeroMatrixSpaceEfficient(int[][] arr) {
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;

		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == 0) {
				firstRowHasZero = true;
				break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 0) {
				firstColHasZero = true;
				break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					arr[0][j] = 0;
					arr[i][0] = 0;

				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 0) {
				nullifyRow(arr, i);
			}
		}

		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == 0) {
				nullifyCol(arr, i);
			}
		}
		if(firstColHasZero) {
			nullifyCol(arr,0);
		}

		if(firstRowHasZero) {
			nullifyRow(arr, 0);
		}
		return arr;
	}
	
	public static int[][] initialize(int[][] arr, int modulo) {
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				count++;
				arr[i][j] = count % modulo;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		initialize(arr, 6);
		System.out.println("Before:");
		ArrayUtility.print(arr);

		System.out.println("After:");
		ArrayUtility.print(zeroMatrixSimple(arr));
		
		initialize(arr, 10);
		System.out.println("Before:");
		ArrayUtility.print(arr);

		System.out.println("After:");
		ArrayUtility.print(zeroMatrixSpaceEfficient(arr));
		
		initialize(arr, 6);
		System.out.println("Before:");
		ArrayUtility.print(arr);

		System.out.println("After:");
		ArrayUtility.print(zeroMatrixSpaceEfficient(arr));
	}

}
