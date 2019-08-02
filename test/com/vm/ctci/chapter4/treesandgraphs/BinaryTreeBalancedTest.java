package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeBalancedTest {
	private static Node root = null;
	private static Node balancedTreeRoot = null;
	@BeforeClass
	public static void setUp() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(8);
		root.right.right = new Node(7);
		
		balancedTreeRoot= new Node(1);
		balancedTreeRoot.left= new Node(2);
		balancedTreeRoot.right= new Node(3);
		balancedTreeRoot.left.left= new Node(4);
		balancedTreeRoot.left.right= new Node(5);
	}

	@Test
	public void testImbalancedTreeRecursive() {
		assertFalse(BinaryTreeBalanced.isBinaryTreeBalancedRecursive(root));
	}
	
	@Test
	public void testImbalancedTreeOptimized() {
		assertFalse(BinaryTreeBalanced.isBinaryTreeBalancedOptimized(root));
	}
	
	@Test
	public void testIsBinaryTreeBalancedRecursive() {
		assertTrue(BinaryTreeBalanced.isBinaryTreeBalancedRecursive(balancedTreeRoot));
	}
	
	@Test
	public void testIsBinaryTreeBalancedOptimized() {
		assertTrue(BinaryTreeBalanced.isBinaryTreeBalancedOptimized(balancedTreeRoot));
	}

}
