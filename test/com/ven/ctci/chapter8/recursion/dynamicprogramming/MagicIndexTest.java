package com.ven.ctci.chapter8.recursion.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MagicIndexTest {

	int[] arr = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
	int[] arr2 = { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
	int[] arr3 = {10,20,30,40,50};

	@Test
	public void testMagicIndexBruteForce() {
		int result = MagicIndex.magicIndexBruteForce(arr);
		assertEquals(7, result);
	}
	
	@Test
	public void testMagicIndexBruteForceArr2() {
		int result = MagicIndex.magicIndexBruteForce(arr2);
		assertEquals(2, result);
	}
	
	@Test
	public void testMagicIndexBruteForceArr3() {
		int result = MagicIndex.magicIndexBruteForce(arr3);
		assertEquals(-1, result);
	}
	
	
	@Test
	public void testMagicIndex() {
		int result = MagicIndex.magicIndex(arr);
		assertEquals(7, result);
	}

	
	@Test
	public void testMagicIndexArr3() {
		int result = MagicIndex.magicIndex(arr3);
		assertEquals(-1, result);
	}

	@Test
	public void testMagicIndexWithDuplicates() {
		int result = MagicIndex.magicIndexBruteForce(arr);
		assertEquals(7, result);
	}
	
	@Test
	public void testMagicIndexWithDuplicatesArr2() {
		int result = MagicIndex.magicIndexBruteForce(arr2);
		assertEquals(2, result);
	}
	
	@Test
	public void testMagicIndexWithDuplicatesArr3() {
		int result = MagicIndex.magicIndexBruteForce(arr3);
		assertEquals(-1, result);
	}

}
