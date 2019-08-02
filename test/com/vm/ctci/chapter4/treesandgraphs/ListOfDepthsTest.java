package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

public class ListOfDepthsTest {
	private static Node root = null;
	
	@BeforeClass
	public static void setUp() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
	}

	@Test
	public void testListOfDepthRecursive() {
		ArrayList<LinkedList<Node>> listOfDepths = ListOfDepths.createListOfDepthsRecursive(root);
		assertEquals(1, listOfDepths.get(0).removeFirst().data);
		assertEquals(2, listOfDepths.get(1).removeFirst().data);
		assertEquals(3, listOfDepths.get(1).removeFirst().data);
		assertEquals(4, listOfDepths.get(2).removeFirst().data);
		assertEquals(5, listOfDepths.get(2).removeFirst().data);
		assertEquals(6, listOfDepths.get(2).removeFirst().data);
	}
	
	@Test
	public void testListOfDepthRecursiveWithEmptyTree() {
		ArrayList<LinkedList<Node>> listOfDepths = ListOfDepths.createListOfDepthsRecursive(null);
		assertEquals(0, listOfDepths.size());
	}
	
	@Test
	public void testListOfDepthBFS() {
		ArrayList<LinkedList<Node>> listOfDepths = ListOfDepths.createListOfDepthsBFS(root);
		assertEquals(1, listOfDepths.get(0).removeFirst().data);
		assertEquals(2, listOfDepths.get(1).removeFirst().data);
		assertEquals(3, listOfDepths.get(1).removeFirst().data);
		assertEquals(4, listOfDepths.get(2).removeFirst().data);
		assertEquals(5, listOfDepths.get(2).removeFirst().data);
		assertEquals(6, listOfDepths.get(2).removeFirst().data);
	}
	
	@Test
	public void testListOfDepthBFSWithEmptyTree() {
		ArrayList<LinkedList<Node>> listOfDepths = ListOfDepths.createListOfDepthsRecursive(null);
		assertEquals(0, listOfDepths.size());
	}

}
