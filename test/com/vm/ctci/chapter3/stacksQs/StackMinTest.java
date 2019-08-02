package com.vm.ctci.chapter3.stacksQs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class StackMinTest {
	private static StackMin stack = new StackMin();

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
		assertEquals(Integer.valueOf(1), stack.min());
	}
	
	@Test
	public void TestPopOnStack() {
		stack.push(1);
		assertEquals(Integer.valueOf(1), stack.pop());
		assertTrue(stack.isEmpty());
		assertEquals(Integer.MAX_VALUE, stack.min().intValue());
	}
	
	@Test
	public void TestStackMin5elements() {
		stack.push(6);
		stack.push(5);
		stack.push(7);
		stack.push(3);
		stack.push(1);
		stack.push(2);
		assertEquals(1, stack.min().intValue());
		
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(1, stack.min().intValue());
		
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(3, stack.min().intValue());
		
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(5, stack.min().intValue());
		
		assertEquals(Integer.valueOf(7), stack.pop());
		assertEquals(5, stack.min().intValue());
		
		assertEquals(Integer.valueOf(5), stack.pop());
		assertEquals(6, stack.min().intValue());
		
		assertEquals(Integer.valueOf(6), stack.pop());
		assertEquals(Integer.MAX_VALUE, stack.min().intValue());
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
