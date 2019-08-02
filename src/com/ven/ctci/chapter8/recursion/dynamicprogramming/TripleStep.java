package com.ven.ctci.chapter8.recursion.dynamicprogramming;

import static org.junit.Assert.assertEquals;

public class TripleStep {

	public static int steps(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (n == 3) {
			return 4;
		}

		return steps(n - 1) + steps(n - 2) + steps(n - 3);
	}

	public static int stepsMemoized(int n) {
		int[] memo = new int[n + 1];

		if (n == 0 || n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (n == 3) {
			return 4;
		}

		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for (int i = 4; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
		}

		return memo[n];
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		assertEquals(1, steps(0));
		assertEquals(1, steps(1));
		assertEquals(2, steps(2));
		assertEquals(4, steps(3));
		assertEquals(7, steps(4));
		assertEquals(13, steps(5));
		assertEquals(274, steps(10));
		assertEquals(121415, steps(20));
		long end = System.nanoTime();
		System.out.println(end - start);
		assertEquals(1, stepsMemoized(0));
		assertEquals(1, stepsMemoized(1));
		assertEquals(2, stepsMemoized(2));
		assertEquals(4, stepsMemoized(3));
		assertEquals(7, stepsMemoized(4));
		assertEquals(13, stepsMemoized(5));
		assertEquals(274, stepsMemoized(10));
		assertEquals(121415, stepsMemoized(20));
		System.out.println(System.nanoTime() - end);
	}

}
