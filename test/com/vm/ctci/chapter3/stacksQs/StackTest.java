package com.vm.ctci.chapter3.stacksQs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import com.vm.ctci.chapter3.stacksQs.Stack;

public class StackTest {
	private static Stack<Integer> stack = new Stack<Integer>();

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
		stack.push(1);
		assertEquals(Integer.valueOf(1), stack.peak());
	}
	
	@Test
	public void TestPopOnStack() {
		stack.push(1);
		assertEquals(Integer.valueOf(1), stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void TestPush2ElementsOnStack() {
		stack.push(1);
		stack.push(2);
		assertEquals(Integer.valueOf(2), stack.peak());
	}
	
	@Test
	public void TestPop2ElementsOnStack() {
		stack.push(1);
		stack.push(2);
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertTrue(stack.isEmpty());
	}

}
