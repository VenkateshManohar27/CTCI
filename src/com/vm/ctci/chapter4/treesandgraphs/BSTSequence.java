package com.vm.ctci.chapter4.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {

	public ArrayList<LinkedList<Integer>> allSequence(Node node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if (node == null) {
			result.add(new LinkedList<>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.data);

		ArrayList<LinkedList<Integer>> leftSequence = allSequence(node.left);
		ArrayList<LinkedList<Integer>> rightSequence = allSequence(node.right);

		for (LinkedList<Integer> left : leftSequence) {
			for (LinkedList<Integer> right : rightSequence) {
				System.out.println(left+"-"+right);
			}
		}

		return result;
	}
	
	public static void main (String[] args) {
		BSTSequence bst = new BSTSequence();
		Node root = new Node(20);
		root.left = new Node(15);
		root.right = new Node(25);
		root.left.left = new Node(10);
		root.left.left.left = new Node(5);
		root.right.left = new Node(22);
		bst.allSequence(root);
	}

}
