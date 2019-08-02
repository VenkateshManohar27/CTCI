package com.vm.ctci.chapter3.stacksQs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class SortStackTest {
	private static SortStack<Integer> stack = new SortStack<>(SortStack.ascending);
	private static SortStack<Integer> stack2 = new SortStack<>(SortStack.descending);

	@Before
	public void setUp() {
		while (!stack.isEmpty()) {
			stack.pop();
		}
	}

	@Test
	public void TestEmptyStack() {
		assertTrue(stack.isEmpty());
	}

	@Test(expected = EmptyStackException.class)
	public void TestPopOnEmptyStack() {
		stack.pop();
	}

	@Test(expected = EmptyStackException.class)
	public void TestPeakOnEmptyStack() {
		stack.peak();
	}

	@Test
	public void TestSortStackAscending() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(Integer.valueOf(4), stack.pop());
	}

	@Test
	public void TestSortStackDescending() {
		stack2.push(4);
		stack2.push(3);
		stack2.push(2);
		stack2.push(1);
		assertEquals(Integer.valueOf(4), stack2.pop());
		assertEquals(Integer.valueOf(3), stack2.pop());
		assertEquals(Integer.valueOf(2), stack2.pop());
		assertEquals(Integer.valueOf(1), stack2.pop());
	}

}
