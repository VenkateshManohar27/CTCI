package com.vm.ctci.chapter2.Linkedlists;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class IntersectionTest {
	private static Node intersectingListHead1 = null;
	private static Node intersectingListHead2 = null;
	private static Node nonIntersectingListHead1 = null;
	private static Node nonIntersectingListHead2 = null;
	private static Node intersectionNode = null;
	private static Intersection intersection = new Intersection();
	
	@BeforeClass
	public static void setUp() {
		LinkedList list1 = new LinkedList();
		list1.appendToTail(1);
		list1.appendToTail(2);
		list1.appendToTail(3);
		list1.appendToTail(4);
		list1.appendToTail(5);
		intersectingListHead1 = list1.head;
		
		intersectionNode = list1.kthNodeToLast(2);
		LinkedList list2 = new LinkedList();
		list2.appendToTail(1);
		list2.appendToTail(2);
		list2.appendToTail(intersectionNode);
		intersectingListHead2 = list2.head;
		
		LinkedList list3 = new LinkedList();
		list3.appendToTail(1);
		list3.appendToTail(2);
		list3.appendToTail(3);
		nonIntersectingListHead1 = list3.head;
		
		LinkedList list4 = new LinkedList();
		list4.appendToTail(4);
		list4.appendToTail(5);
		list4.appendToTail(6);
		nonIntersectingListHead2 = list4.head;
	}
	
	@Test
	public void testWhenListsAreNull() {
		assertNull(intersection.doIntersect(null, null));
	}
	
	@Test
	public void testWhenList1IsNull() {
		assertNull(intersection.doIntersect(null, intersectingListHead2));
	}
	
	@Test
	public void testWhenList2IsNull() {
		assertNull(intersection.doIntersect(intersectingListHead2, null));
	}
	
	@Test
	public void testIntersection() {
		Node node = intersection.doIntersect(intersectingListHead1, intersectingListHead2);
		assertEquals(intersectionNode, node);
	}
	
	@Test
	public void testNonIntersection() {
		assertNull(intersection.doIntersect(nonIntersectingListHead1, nonIntersectingListHead2));
	}

}
