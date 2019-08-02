package com.vm.ctci.chapter3.stacksQs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class QueueTest {
	private Queue<Integer> queue;
	
	@Test
	public void testQueueEmpty() {
		queue = new Queue<Integer>();
		assertTrue(queue.isEmpty());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRemoveWhenQueueEmpty() {
		queue = new Queue<Integer>();
		queue.remove();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testPeekWhenQueueEmpty() {
		queue = new Queue<Integer>();
		queue.peek();
	}
	
	@Test
	public void testHappyPath() {
		queue = new Queue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		assertEquals(1, queue.remove().intValue());
		assertEquals(2, queue.remove().intValue());
		assertEquals(3, queue.remove().intValue());
		assertEquals(4, queue.remove().intValue());
		assertTrue(queue.isEmpty());
	}
}
