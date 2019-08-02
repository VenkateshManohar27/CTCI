package com.vm.ctci.chapter3.stacksQs;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ThreeInOneTest {

	@Test
	public void testStacksOfSize2() {
		ThreeInOne stacks = new ThreeInOne(2, 3);
		stacks.push(1, 1);
		stacks.push(1, 2);
		stacks.push(2, 3);
		stacks.push(2, 4);
		stacks.push(3, 5);
		stacks.push(3, 6);
		assertEquals(2, stacks.pop(1));
		assertEquals(1, stacks.pop(1));
		assertEquals(4, stacks.pop(2));
		assertEquals(3, stacks.pop(2));
		assertEquals(6, stacks.pop(3));
		assertEquals(5, stacks.pop(3));

	}

	@Test(expected = NoSuchElementException.class)
	public void testStackFullException() {
		ThreeInOne stacks = new ThreeInOne(2, 3);
		stacks.push(1, 1);
		stacks.push(1, 2);
		// try {
		stacks.push(1, 3);
		/*
		 * }catch (NoSuchElementException e) { assertTrue(true); }
		 * 
		 * stacks.push(2, 3); stacks.push(2, 4);
		 * 
		 * try { stacks.push(2, 3); }catch (NoSuchElementException e) {
		 * assertTrue(true); } stacks.push(3, 5); stacks.push(3, 6);
		 * 
		 * try { stacks.push(3, 3); }catch (NoSuchElementException e) {
		 * assertTrue(true); }
		 */
	}

	@Test(expected=EmptyStackException.class)
	public void testStackEmptyException() {
		ThreeInOne stacks = new ThreeInOne(2, 3);
		stacks.push(1, 1);
		stacks.push(1, 2);
		stacks.pop(1);
		stacks.pop(1);
		stacks.pop(1);
	}
}
