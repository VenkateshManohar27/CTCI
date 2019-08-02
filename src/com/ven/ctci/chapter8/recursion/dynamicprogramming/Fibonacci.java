package com.ven.ctci.chapter8.recursion.dynamicprogramming;

import static org.junit.Assert.assertEquals;

public class Fibonacci {

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacciMemoized(int n) {
		int[] memo = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		return fibonacci(n, memo);
	}

	private static int fibonacci(int n, int[] memo) {
		if (n == 0 || n == 1) {
			return memo[n];
		}

		if (memo[n] == 0) {
			memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
		}

		return memo[n];
	}

	public static int fibonacciIterative(int n) {
		int[] memo = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}

	public static void main(String[] args) {
		assertEquals(2, fibonacci(3));
		assertEquals(3, fibonacci(4));
		assertEquals(5, fibonacci(5));
		assertEquals(8, fibonacci(6));
		assertEquals(13, fibonacci(7));

		assertEquals(2, fibonacciMemoized(3));
		assertEquals(3, fibonacciMemoized(4));
		assertEquals(5, fibonacciMemoized(5));
		assertEquals(8, fibonacciMemoized(6));
		assertEquals(13, fibonacciMemoized(7));
		
		assertEquals(2, fibonacciIterative(3));
		assertEquals(3, fibonacciIterative(4));
		assertEquals(5, fibonacciIterative(5));
		assertEquals(8, fibonacciIterative(6));
		assertEquals(13, fibonacciIterative(7));

	}

}
