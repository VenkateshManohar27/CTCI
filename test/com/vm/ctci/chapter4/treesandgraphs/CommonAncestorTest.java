package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CommonAncestorTest {
	private static Node treeroot1 = null;
	private static Node treeroot2 = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCommonAncestorUsingParent() {
		Node ancestor = CommonAncestor.commonAncestorUsingParent(treeroot1.left, treeroot1.right);
		
		assertEquals(treeroot1, ancestor);
	}
	@Test
	public void testCommonAncestorUsingBU() {
		Node ancestor = CommonAncestor.commonAncestorUsingBottomUp(treeroot1, treeroot1.left, treeroot1.right);
		
		assertEquals(treeroot1, ancestor);
	}
}
