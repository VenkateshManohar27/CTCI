package com.vm.ctci.chapter4.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

	public static List inorder(Node root) {
		List visitedNodes = new ArrayList<>();
		inorder(visitedNodes, root);
		return visitedNodes;
	}

	private static void inorder(List visitedNodeOrder, Node node) {
		if (node != null) {
			inorder(visitedNodeOrder, node.left);
			visitedNodeOrder.add(node.data);
			inorder(visitedNodeOrder, node.right);
		}
	}

	public static List preorder(Node root) {
		List visitedNodes = new ArrayList<>();
		preorder(visitedNodes, root);
		return visitedNodes;
	}

	private static void preorder(List visitedNodeOrder, Node node) {
		if (node != null) {
			visitedNodeOrder.add(node.data);
			preorder(visitedNodeOrder, node.left);
			preorder(visitedNodeOrder, node.right);
		}
	}

	public static List postorder(Node root) {
		List visitedNodes = new ArrayList<>();
		postorder(visitedNodes, root);
		return visitedNodes;
	}

	private static void postorder(List visitedNodeOrder, Node node) {
		if (node != null) {
			postorder(visitedNodeOrder, node.left);
			postorder(visitedNodeOrder, node.right);
			visitedNodeOrder.add(node.data);
		}
	}

}

