package com.vm.ctci.chapter4.treesandgraphs;

public class InOrderSuccessor {
	public static Node inorderSuccessor(Node node) {
		if (node == null) {
			return null;
		}
		// if node has a right subtree return the left most mode of right subtree
		if (node.right != null) {
			return leftMostChild(node.right);
		} else {
			Node parent = node.parent;
			Node temp = node;

			while (parent != null && parent.left != temp) {
				temp = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

	private static Node leftMostChild(Node node) {
		while (node.left != null) {
			node = node.left;
		}

		return node;
	}

}
