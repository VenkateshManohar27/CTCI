package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vm.ctci.chapter4.treesandgraphs.Graph.Node;

public class RouteBetweenNodesTest {
	private static Graph g;
	private static Node node0, node1, node2, node3, node4, node5, node6;

	@BeforeClass
	public static void setUp() {
		node0 = new Node("0");
		node1 = new Node("1");
		node2 = new Node("2");
		node3 = new Node("3");
		node4 = new Node("4");
		node5 = new Node("5");
		node6 = new Node("6");
		
		node0.addChild(node1);
		node1.addChild(node2);
		node2.addChild(node0);
		node2.addChild(node3);
		node3.addChild(node2);
		node4.addChild(node6);
		node5.addChild(node4);
		node6.addChild(node5);
		//node0.addChild(node1);
		
		g = new Graph(7);
		g.nodes[0] = node0;
		g.nodes[1] = node1;
		g.nodes[2] = node2;
		g.nodes[3] = node3;
		g.nodes[4] = node4;
		g.nodes[5] = node5;
		g.nodes[6] = node6;		
	}
	
	@Test
	public void testGraphisNull() {
		assertFalse(RouteBetweenNodes.search(null, node0, node4));
	}
	
	@Test
	public void testGraphWhenStartIsNull() {
		assertFalse(RouteBetweenNodes.search(g, null, node4));
	}

	@Test
	public void testGraphWhenEndIsNull() {
		assertFalse(RouteBetweenNodes.search(g, node0, null));
	}
	
	@Test
	public void testRouteBetween2nodes() {
		assertTrue(RouteBetweenNodes.search(g, node0, node3));
	}
	
	@Test
	public void testNoRoutes() {
		assertFalse(RouteBetweenNodes.search(g, node0, node5));
	}

}
