package com.vm.ctci.chapter2.Linkedlists;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vm.ctci.chapter2.Linkedlists.SumList;

public class SumListTest {
	private static SumList sl = new SumList();
	private static List<Integer> l1 = new LinkedList<>();
	private static List<Integer> l2 = new LinkedList<>();
	private static List<Integer> l3 = new LinkedList<>();
	
	@Before
	public void setUp() {
		l1.clear();
		l2.clear();
		l3.clear();
		l1.add(6);
		l1.add(1);
		l1.add(7);
		l2.add(2);
		l2.add(9);
		l2.add(5);
		l3.add(2);
		l3.add(9);
		l3.add(5);
		l3.add(6);
	}

	@Test
	public void testWithEmptyList() {

		List<Integer> output = sl.add(new LinkedList<>(), new LinkedList<>());

		assertEquals(0, output.size());
	}

	@Test
	public void testWithNullList1() {

		List<Integer> output = sl.add(null, l2);

		assertEquals(3, output.size());
		assertEquals(2, (int) output.get(0));
		assertEquals(9, (int) output.get(1));
		assertEquals(5, (int) output.get(2));
	}

	@Test
	public void testWithNullList2() {

		List<Integer> output = sl.add(l1, null);

		assertEquals(3, output.size());
		assertEquals(6, (int) output.get(0));
		assertEquals(1, (int) output.get(1));
		assertEquals(7, (int) output.get(2));
	}

	@Test
	public void testHappyPath() {
		List<Integer> output = sl.add(l1, l2);

		assertEquals(3, output.size());
		assertEquals(9, (int) output.get(0));
		assertEquals(1, (int) output.get(1));
		assertEquals(2, (int) output.get(2));
	}
	
	@Test
	public void testListsDifferentLength() {
		
		List<Integer> output = sl.add(l1, l3);

		assertEquals(4, output.size());
		assertEquals(3, (int) output.get(0));
		assertEquals(5, (int) output.get(1));
		assertEquals(7, (int) output.get(2));
		assertEquals(3, (int) output.get(3));
	}
}
