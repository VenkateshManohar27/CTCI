package com.vm.ctci.chapter4.treesandgraphs;

public class BinaryTreeBalanced {

	public static boolean isBinaryTreeBalancedRecursive(Node root) {
		if (root == null) {
			return true;
		}

		int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if (diff > 1) {
			return false;
		} else {
			return isBinaryTreeBalancedRecursive(root.left) && isBinaryTreeBalancedRecursive(root.right);
		}

	}

	private static int getHeight(Node node) {
		if (node == null) {
			return -1;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	public static boolean isBinaryTreeBalancedOptimized(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	private static int checkHeight(Node node) {
		if (node == null) {
			return -1;
		}

		int leftHeight = checkHeight(node.left);
		if(leftHeight == Integer.MIN_VALUE) return leftHeight;

		int rightHeight = checkHeight(node.right);
		if(rightHeight == Integer.MIN_VALUE) return rightHeight;

		int diff = Math.abs(leftHeight - rightHeight);
		if (diff > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
