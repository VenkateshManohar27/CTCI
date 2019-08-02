package com.vm.ctci.chapter3.stacksQs.setOfstack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class SetOfStacksTest {

	private static Stack<Integer> stack = new Stack<Integer>(2);

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
	public void TestPushOnStack() {
		assertTrue(stack.push(1));
		assertTrue(stack.push(2));
		assertFalse(stack.push(3));

	}

	@Test
	public void TestPop2ElementsOnStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void TestSetOfStacks() {
		SetOfStacks setOfStacks = new SetOfStacks(2);
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		setOfStacks.push(5);
		setOfStacks.push(6);
		setOfStacks.push(7);
		setOfStacks.push(8);
		assertEquals(8, setOfStacks.pop());
		assertEquals(7, setOfStacks.pop());
		assertEquals(6, setOfStacks.pop());
		assertEquals(5, setOfStacks.pop());
		assertEquals(4, setOfStacks.pop());
		assertEquals(3, setOfStacks.pop());
		assertEquals(2, setOfStacks.pop());
		assertEquals(1, setOfStacks.pop());
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		assertEquals(3, setOfStacks.pop());
		assertEquals(2, setOfStacks.pop());
		assertEquals(1, setOfStacks.pop());
	}
}
