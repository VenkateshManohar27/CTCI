package com.ven.ctci.chapter8.recursion.dynamicprogramming;

public class MagicIndex {

	public static int magicIndexBruteForce(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicIndex(int[] arr) {
		if (arr == null) {
			return -1;
		}
		return magicIndex(arr, 0, arr.length - 1);
	}

	private static int magicIndex(int[] arr, int start, int end) {
		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (arr[mid] == mid) {
			return mid;
		} else if (arr[mid] > mid) {
			return magicIndex(arr, start, mid - 1);
		} else if (arr[mid] < mid) {
			return magicIndex(arr, mid + 1, end);
		}
		return -1;
	}

	public static int magicIndexWithDuplicates(int[] arr) {
		if (arr == null) {
			return -1;
		}
		return magicIndexD(arr, 0, arr.length - 1);
	}

	private static int magicIndexD(int[] arr, int start, int end) {
		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (arr[mid] == mid) {
			return mid;
		}

		int midValue = arr[mid];
		int leftIndex = Math.min(mid - 1, midValue);
		int left = magicIndex(arr, start, leftIndex);
		if (left > 0) {
			return left;
		}
		int rightIndex = Math.max(mid + 1, midValue);
		int right = magicIndex(arr, rightIndex, end);
		return right;

	}

}
