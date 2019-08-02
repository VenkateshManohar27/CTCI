package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TreeTraversalTest {
	// private static TreeTraversal tt = new Tree;
	private static Node root;

	@Before
	public void setUp() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		//root.right = new Node(3);

	}

	@Test
	public void testInorder() {
		List li = TreeTraversal.inorder(root);
		assertEquals(4, li.get(0));
		assertEquals(2, li.get(1));
		assertEquals(5, li.get(2));
		assertEquals(1, li.get(3));
		assertEquals(6, li.get(4));
		assertEquals(3, li.get(5));
	}
	
	@Test
	public void testPreorder() {
		List li = TreeTraversal.preorder(root);
		
		assertEquals(1, li.get(0));
		assertEquals(2, li.get(1));
		assertEquals(4, li.get(2));
		assertEquals(5, li.get(3));
		assertEquals(3, li.get(4));
		assertEquals(6, li.get(5));
	}
	
	@Test
	public void testPostorder() {
		List li = TreeTraversal.postorder(root);
		assertEquals(4, li.get(0));
		assertEquals(5, li.get(1));
		assertEquals(2, li.get(2));
		assertEquals(6, li.get(3));
		assertEquals(3, li.get(4));
		assertEquals(1, li.get(5));
	}

}
