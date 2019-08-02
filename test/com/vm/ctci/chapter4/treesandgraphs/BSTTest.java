package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class BSTTest {
	private int[] arr = { 1, 2, 3 };
	private int[] arr2 = { 1, 2, 3, 4, 5, 6 };
	private static BST bst = new BST();
	private static Node treeRoot, root;
	
	@BeforeClass
	public static void setUp() {
		root = new Node(20);
		root.left = new Node(15);
		root.right = new Node(25);
		root.left.left = new Node(10);
		root.left.left.left = new Node(5);
		root.right.left = new Node(22);
		root.right.left.left = new Node(21);
		root.right.right = new Node(7);
	}

	@Test
	public void testEmptyArray() {
		int[] array = {};
		Node n = bst.constructBST(array);
		assertNull(n);
	}

	@Test
	public void testWhenArrayIsNull() {

		Node n = bst.constructBST(null);
		assertNull(n);
	}

	@Test
	public void test() {
		// BST bst = new BST();
		Node n = bst.constructBST(arr);
		assertEquals(2, n.data);
		assertEquals(1, n.left.data);
		assertEquals(3, n.right.data);

	}

	@Test
	public void testWith6Elements() {
		BST bst = new BST();
		Node n = bst.constructBST(arr2);
		treeRoot = n;
		assertEquals(3, n.data);
		assertEquals(1, n.left.data);
		assertNull(n.left.left);
		assertEquals(2, n.left.right.data);
		assertEquals(5, n.right.data);
		assertEquals(4, n.right.left.data);
		assertEquals(6, n.right.right.data);
	}

	@Test
	public void testValidateBST() {
		assertTrue(bst.validateBSTWithArray(treeRoot));
	}
	
	@Test
	public void testValidateBSTMinMax() {
		assertTrue(bst.validateBSTMinMax(treeRoot));
	}
	
	@Test
	public void testInvalidBST() {
		assertFalse(bst.validateBSTWithArray(root));
	}
	
	@Test
	public void testInvalidBSTMinMax() {
		assertFalse(bst.validateBSTMinMax(root));
	}

}
