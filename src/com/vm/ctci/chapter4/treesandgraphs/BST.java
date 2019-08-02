package com.vm.ctci.chapter4.treesandgraphs;

import com.vm.utility.TreeUtility;

public class BST {
	Node root;

	/*
	 * class Node { Node left, right; int value;
	 * 
	 * public Node(int value) { this.value = value; } }
	 */

	/**
	 * 
	 * @param sortedArr
	 * @return
	 */
	public Node constructBST(int[] sortedArr) {
		if (sortedArr == null) {
			return null;
		}
		root = constructBST(sortedArr, 0, sortedArr.length - 1);

		return root;
	}

	private Node constructBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);

		node.left = constructBST(arr, start, mid - 1);

		node.right = constructBST(arr, mid + 1, end);
		return node;
	}

	private int index = 0;

	public boolean validateBSTWithArray(Node root) {
		int arrLength = TreeUtility.calculateTreeNodes(root);
		int[] arr = new int[arrLength];
		index = 0;
		checkBST(root, arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1])
				return false;
		}

		return true;
	}

	private void checkBST(Node node, int[] arr) {
		if (node == null) {
			return;
		}
		checkBST(node.left, arr);
		arr[index] = node.data;
		index++;
		checkBST(node.right, arr);

	}

	public boolean validateBSTMinMax(Node root) {
		return checkBST(root, null, null);
	}

	private boolean checkBST(Node node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}

		if ((max != null && max < node.data) || (min != null && min >= node.data)) {
			return false;
		}

		if (!(checkBST(node.left, min, node.data)) || !checkBST(node.right, node.data, max)) {
			return false;
		}
		return true;
	}

}
