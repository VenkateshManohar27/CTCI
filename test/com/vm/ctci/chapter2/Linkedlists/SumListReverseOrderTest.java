package com.vm.ctci.chapter2.Linkedlists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vm.ctci.chapter2.Linkedlists.SumListReverseOrder;

public class SumListReverseOrderTest {
	private static SumListReverseOrder sl = new SumListReverseOrder();
	private static List<Integer> l1 = new LinkedList<>();
	private static List<Integer> l2 = new LinkedList<>();
	private static List<Integer> l3 = new LinkedList<>();
	@BeforeClass
	public static void setUp() {
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

		assertNull(output);
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

		assertEquals(4, output.size());
		assertEquals(8, (int) output.get(0));
		assertEquals(0, (int) output.get(1));
		assertEquals(2, (int) output.get(2));
		assertEquals(1, (int) output.get(3));
	}
	
	@Test
	public void testListsDifferentLength() {
		
		List<Integer> output = sl.add(l1, l3);

		assertEquals(4, output.size());
		assertEquals(8, (int) output.get(0));
		assertEquals(0, (int) output.get(1));
		assertEquals(2, (int) output.get(2));
		assertEquals(7, (int) output.get(3));
	}

}
