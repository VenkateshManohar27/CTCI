package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class InOrderSuccessorTest {

	private static Node treeroot1 = null;
	private static Node treeroot2 = null;

	@BeforeClass
	public static void setUp() {
		treeroot1 = new Node(20);
		treeroot1.left = new Node(15, treeroot1);
		treeroot1.right = new Node(25, treeroot1);

		treeroot2 = new Node(30);
		treeroot2.left = new Node(20, treeroot2);
		treeroot2.right = new Node(35, treeroot2);
		treeroot2.left.left = new Node(10, treeroot2.left);
		treeroot2.left.right = new Node(25, treeroot2.left);
		treeroot2.left.left.left = new Node(7, treeroot2.left.left);
		treeroot2.left.left.right = new Node(15, treeroot2.left.left);
		treeroot2.left.right.left = new Node(23, treeroot2.left.right.left);
		treeroot2.left.right.right = new Node(27, treeroot2.left.right.right);

	}

	@Test
	public void testWhenTreeIsNull() {
		assertNull(InOrderSuccessor.inorderSuccessor(null));
	}

	@Test
	public void testWhenTreeHasOnlyOneNode() {
		assertNull(InOrderSuccessor.inorderSuccessor(new Node(1)));
	}

	@Test
	public void testWhenNoChildrens() {
		assertEquals(treeroot1, InOrderSuccessor.inorderSuccessor(treeroot1.left));
	}

	@Test
	public void testWhenRightNodeHasNoChildren() {
		assertEquals(treeroot1.right, InOrderSuccessor.inorderSuccessor(treeroot1));
	}

	@Test
	public void testWhenNoMoreNodesToVisit() {
		assertNull(InOrderSuccessor.inorderSuccessor(treeroot2.right));
	}

	@Test
	public void testRootWhenRightNodeWithoutChildren() {
		assertEquals(treeroot2.right, InOrderSuccessor.inorderSuccessor(treeroot2));
	}

	@Test
	public void testNodeWhenRightSubtreeHasLeftMostNode() {
		assertEquals(treeroot2.left.right.left, InOrderSuccessor.inorderSuccessor(treeroot2.left));
	}
}
